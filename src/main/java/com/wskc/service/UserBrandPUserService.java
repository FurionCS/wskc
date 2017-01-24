package com.wskc.service;

import java.util.List;

import com.wskc.dto.UserBrandPUserDto;
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
	
	/**
	 * 根据用户id获得所有品牌信息
	 * @param userId
	 * @return
	 */
	public List<UserBrandPUserDto> getUBPUDAll(int userId);
	
	/**
	 * 根据用户id,行业Id获得所有品牌信息
	 * @param userId
	 * @return
	 */
	public List<UserBrandPUserDto> getUBPUDByIndustry(int userId,int industryId);
	/**
	 * 添加用户品牌信息
	 * @param ubpu
	 */
	public int addUBPU(UserBrandPUser ubpu);
}
