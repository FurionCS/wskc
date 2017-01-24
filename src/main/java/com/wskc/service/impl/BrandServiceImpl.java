package com.wskc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.BrandDao;
import com.wskc.model.Brand;
import com.wskc.service.BrandService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:品牌</p>
 * @author Mr.Cheng
 * @date 2017年1月24日 下午9:09:40
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> getBrandSerach(String industrys,String str) {
		// 查询品牌列表
		return	brandDao.getBrandSerach(industrys,str);
	}

}
