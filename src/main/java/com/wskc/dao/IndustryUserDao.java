package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;

import com.wskc.dto.IndustryUserDto;
import com.wskc.model.IndustryUser;
/**
 * 
 * <p>Title:</p>
 * <p>Description:行业用户表</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午2:30:42
 */
public interface IndustryUserDao extends IBaseDao<IndustryUser>{
	/**
	 * 获得该用户的行业信息
	 * @param userId
	 * @return
	 */
	public List<IndustryUserDto> getIndustryByUserId(int userId);
	/**
	 * 获得用户所属行业数量
	 * @param userId
	 * @return
	 */
	public int getIndustryUserNum(int userId);
	/**
	 * 根据userid和industryId用户所属行业
	 * @param userId
	 * @param industryId
	 * @return
	 */
	public IndustryUser getIndustryUserByUI(int userId,int industryId);
	
	/**
	 * 根据userId和IndustryId删除记录
	 * @param userId
	 * @param industryId
	 */
	public void deleteIndustryUserByUI(int userId,int industryId);
	
}
