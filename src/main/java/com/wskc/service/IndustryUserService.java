package com.wskc.service;

import java.util.List;

import com.wskc.dto.IndustryUserDto;
import com.wskc.model.IndustryUser;

/**
 *
 * <p>Title:</p>
 * <p>Description:行业用户</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午3:22:03
 */
public interface IndustryUserService {
	/**
	 * 通过userId获得用户所属行业
	 * @param userId
	 * @return
	 */
	 List<IndustryUserDto> getIndustryByUserId(int userId);
	 
	 /**
	  * 添加用户所属行业
	  * @param industryUser
	  */
	 boolean addIndustryUser(IndustryUser industryUser);
	 
	/**
	 * 根据userId和IndustryId删除记录
	 * @param userId
	 * @param industryId
	 */
	public void deleteIndustryUserByUI(int userId,int industryId);
	 
	 
}
