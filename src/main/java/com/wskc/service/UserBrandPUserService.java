package com.wskc.service;

import java.util.List;

import com.wskc.model.UserBrandPUser;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户品牌上家</p>
 * @author Mr.Cheng
 * @date 2017年1月23日 下午4:00:56
 */
public interface UserBrandPUserService {
	/**
	 * 根据用户行业获得该行业下的品牌
	 * @param userId
	 * @param industryId
	 * @return
	 */
	public List<UserBrandPUser> getUserBrandPUserByIndustry(int userId,int industryId);

}
