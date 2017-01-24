package com.wskc.service;

import java.util.List;

import com.wskc.model.Industry;
/**
 * 
 * <p>Title:</p>
 * <p>Description:行业</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午4:34:19
 */
public interface IndustryService {
	/**
	 * 获得所有行业信息
	 * @return
	 */
	List<Industry> getIndustryList();
}
