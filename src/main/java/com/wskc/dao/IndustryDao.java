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
	
}
