package com.wskc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wskc.dao.IndustryDao;
import com.wskc.model.Industry;
import com.wskc.service.IndustryService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:行业</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午4:36:04
 */
@Service("industryService")
public class IndustryServiceImpl implements IndustryService{

	@Autowired
	private IndustryDao industryDao;
	/**
	 *  从缓存中读取
	 */
	@Override
	@Cacheable(value="wskc_industry",key="'wskc_industryList'")
	public List<Industry> getIndustryList() {
		return industryDao.getIndustryList();
	}
	@Override
	@Cacheable(value="wskc_industry_id",key="'wskc_industry_'+#id")
	public Industry getIndustryById(int id) {
		return industryDao.load(id);
	}
}
