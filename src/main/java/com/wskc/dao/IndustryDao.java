package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;

import com.wskc.model.Industry;
/**
 * 
 * <p>Title:</p>
 * <p>Description:行业表</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午2:22:30
 */
public interface IndustryDao extends IBaseDao<Industry>{
	/**
	 * 得到行业通过用户id
	 * @param userId
	 * @return
	 */
	public List<Industry> getIndustryList();
	/**
	 * 更新行业用户数
	 */
	public void updateIndustryUserNum(int num,int industryId);
	/**
	 * 更新行业品牌数
	 * @param num
	 * @param industryId
	 */
	public void updateIndustryBrandName(int num,int industryId);
	
}
