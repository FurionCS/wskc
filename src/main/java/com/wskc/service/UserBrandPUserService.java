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
	 * 根据用户id和检索关键字获得品牌列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public List<UserBrandPUser> getUBPUDByP(int userId,String str);
	
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
	/**
	 * 删除用户品牌
	 * @param userId
	 * @param brandId
	 */
	public boolean deleteUBPU(int userId,int brandId);
	
	/**
	 * 根据品牌id,用户获得用户品牌信息
	 * @param userId
	 * @param brandId
	 * @return
	 */
	public UserBrandPUser getUBPUByUB(int userId,int brandId);
	
	/**
	 * 修改用户品牌
	 * @param ubpu
	 */
	public boolean updateUBPU(UserBrandPUser ubpu);
}
