package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.BrandDao;
import com.wskc.dao.IndustryDao;
import com.wskc.dao.UserBrandPUserDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.UserBrandPUserDto;
import com.wskc.model.BasicException;
import com.wskc.model.Brand;
import com.wskc.model.UserBrandPUser;
import com.wskc.model.UserProductStock;
import com.wskc.service.UserBrandPUserService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户品牌上家</p>
 * @author Mr.Cheng
 * @date 2017年1月23日 下午4:02:06
 */
@Service("userBrandPUserService")
public class UserBrandPUserServiceImpl implements UserBrandPUserService{

	@Autowired
	private UserBrandPUserDao userBrandPUserDao;
	
	@Autowired
	private IndustryDao industryDao;
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private UserProductStockDao userProductStockDao;
	@Override
	public List<UserBrandPUser> getUserBrandPUserByIndustry(int userId,
			int industryId) {
		return userBrandPUserDao.getUserBrandPUserByIndustry(userId, industryId);
	}
	@Override
	public List<UserBrandPUserDto> getUBPUDAll(int userId) {
		return userBrandPUserDao.getUBPUDAll(userId);
	}
	@Override
	public List<UserBrandPUserDto> getUBPUDByIndustry(int userId, int industryId) {
		return userBrandPUserDao.getUBPUDByIndustry(userId, industryId);
	}
	@Override
	public int addUBPU(UserBrandPUser ubpu) {
		//根据品牌获得行业
		Brand brand=brandDao.getBrandById(ubpu.getBrandId());
		if(brand==null){
			throw new BasicException("没有该品牌");
		}
		//先判断是否已经有改品牌，如果有则返回false
		UserBrandPUser ubpu2=userBrandPUserDao.getUBPUByUB(ubpu.getUserId(), ubpu.getBrandId());
		if(ubpu2!=null){
			return -1;
		}
		// 添加
		//根据授权码获得上家id
		if(StringUtils.isNotEmpty(ubpu.getAuthCode())){
			UserBrandPUser ubpu3=userBrandPUserDao.getUBPUByCode(ubpu.getAuthCode());
			if(ubpu3!=null){
				ubpu.setPuserId(ubpu3.getUserId());
				//更新代理数量
				ubpu3.setNum(ubpu3.getNum()+1);
				userBrandPUserDao.update(ubpu3);
			}else{
				return -2;
			}
		}else{
			ubpu.setPuserId(-1);
			ubpu.setpUserRemark("无");
		}
		//授权码通过获得当前时间秒数转成16进制为8位
		ubpu.setAuthCode(Long.toHexString(new Date().getTime()));
		ubpu.setCreatTime(new Date());
		userBrandPUserDao.add(ubpu);
		return 1;
	}
	@Override
	public boolean deleteUBPU(int userId, int brandId) {
		//判断用户该品牌下是否有产品
		List<UserProductStock> lups=userProductStockDao.getUserProductStockByBrandId(userId,brandId);
		if(lups!=null&&lups.size()>0){
			System.out.println("还有产品");
			return false;
		}else{
			//删除品牌
			userBrandPUserDao.deleteUBPUByUB(userId, brandId);
			//更新原来的上级代理数量
			UserBrandPUser ubpu=userBrandPUserDao.getUBPUByUB(userId, brandId);
			UserBrandPUser ubpu4=userBrandPUserDao.getUBPUByUB(ubpu.getPuserId(), ubpu.getBrandId());
			ubpu4.setNum(ubpu4.getNum()-1);
			userBrandPUserDao.update(ubpu4);
			return true;
		}
	}
	@Override
	public UserBrandPUser getUBPUByUB(int userId, int brandId) {
		return userBrandPUserDao.getUBPUByUB(userId, brandId);
	}
	@Override
	public boolean updateUBPU(UserBrandPUser ubpu) {
		if(ubpu.getId()<1|| !StringUtils.isNotEmpty(ubpu.getAuthCode()) || !StringUtils.isNotEmpty(ubpu.getpUserRemark())){
			return false;
		}
		UserBrandPUser ubpu2=userBrandPUserDao.load(ubpu.getId());
		UserBrandPUser ubpu3=userBrandPUserDao.getUBPUByCode(ubpu.getAuthCode());
		UserBrandPUser ubpu4=userBrandPUserDao.getUBPUByUB(ubpu2.getPuserId(), ubpu2.getBrandId());
		////更新原来的上级代理数量
		ubpu4.setNum(ubpu4.getNum()-1);
		userBrandPUserDao.update(ubpu4);
		//更新上级代理
		ubpu2.setPuserId(ubpu3.getUserId());
		ubpu2.setpUserRemark(ubpu.getpUserRemark());
		//更新现上级代理数量
		ubpu3.setNum(ubpu3.getNum()+1);
		userBrandPUserDao.update(ubpu3);
		userBrandPUserDao.update(ubpu2);
		return true;
	}
	@Override
	public List<UserBrandPUser> getUBPUDByP(int userId, String str) {
		return userBrandPUserDao.getUBPUDByP(userId, str);
	}

}
