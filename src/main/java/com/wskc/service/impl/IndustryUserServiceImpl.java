package com.wskc.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







import com.wskc.config.IndustryUserConfig;
import com.wskc.dao.IndustryDao;
import com.wskc.dao.IndustryUserDao;
import com.wskc.dto.IndustryUserDto;
import com.wskc.model.BasicException;
import com.wskc.model.IndustryUser;
import com.wskc.service.IndustryUserService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户所属行业</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午3:25:59
 */
@Service("industryUserService")
public class IndustryUserServiceImpl implements IndustryUserService{

	
	@Autowired
	private IndustryUserDao industryUserDao;
	
	@Autowired
	private IndustryDao industryDao;
	@Override
	public List<IndustryUserDto> getIndustryByUserId(int userId) {
		if(userId>0){
			return industryUserDao.getIndustryByUserId(userId);
		}else {
			return null;
		}
	}

	@Override
	public boolean addIndustryUser(IndustryUser industryUser) {
		//判断参数是否符合规则
		if(industryUser==null || industryUser.getUserId()<1 || industryUser.getIndustryId()<1){
			throw new BasicException("添加的用户所属行业不能为空，或者用户id不能为空,或者行业id不能为空");
		}
		//先判断是否符合规则，已经有两个行业不能添加,判断是否已经有了该行业
		int num=industryUserDao.getIndustryUserNum(industryUser.getUserId());
		IndustryUser industryUser2=industryUserDao.getIndustryUserByUI(industryUser.getUserId(),industryUser.getIndustryId());
		if(num>=IndustryUserConfig.NUM){
			throw new BasicException("已经有两个或及以上行业不能再添加");
		}
		if(industryUser2!=null){
			return false;
		}else{
			//更新行业用户数量
			industryDao.updateIndustryUserNum(1, industryUser.getIndustryId());
			industryUserDao.add(industryUser);
			return true;
		}
	}

	@Override
	public void deleteIndustryUserByUI(int userId, int industryId) {
		//更新行业用户数量
		industryDao.updateIndustryUserNum(-1, industryId);
		//删除用户所属行业
		industryUserDao.deleteIndustryUserByUI(userId, industryId);
	}

}
