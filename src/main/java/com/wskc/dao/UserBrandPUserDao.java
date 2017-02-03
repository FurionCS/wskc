package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;

import com.wskc.dto.UserBrandPUserDto;
import com.wskc.model.UserBrandPUser;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户品牌上家接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:23:06
 */
public interface UserBrandPUserDao extends IBaseDao<UserBrandPUser>{
	/**
	 * 根据用户行业获得该行业下的品牌
	 * @param userId
	 * @param industryId
	 * @return
	 */
	public List<UserBrandPUser> getUserBrandPUserByIndustry(int userId,int industryId);
	
	/**
	 * 根据用户id获得所有品牌信息
	 * @param userId
	 * @return
	 */
	public List<UserBrandPUserDto> getUBPUDAll(int userId);
	
	/**
	 * 根据用户id和检索关键字获得品牌列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public List<UserBrandPUser> getUBPUDByP(int userId,String str);
	
	/**
	 * 根据用户id获得所有品牌信息
	 * @param userId
	 * @return
	 */
	public List<UserBrandPUserDto> getUBPUDByIndustry(int userId,int industryId);
	
	/**
	 * 根据品牌id,用户获得用户品牌信息
	 * @param userId
	 * @param brandId
	 * @return
	 */
	public UserBrandPUser getUBPUByUB(int userId,int brandId);
	
	/**
	 * 更加授权码获的用户品牌信息
	 * @param auth_code
	 * @return
	 */
	public UserBrandPUser getUBPUByCode(String authCode);
	
	/**
	 * 删除用户品牌
	 * @param userId
	 * @param brandId
	 */
	public void deleteUBPUByUB(int userId,int brandId);
}
