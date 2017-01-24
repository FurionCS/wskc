package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;

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
	
	
}
