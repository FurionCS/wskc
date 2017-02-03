package com.wskc.service;

import java.util.List;

import com.wskc.model.Brand;


/**
 * 
 * <p>Title:</p>
 * <p>Description:品牌</p>
 * @author Mr.Cheng
 * @date 2017年1月24日 下午9:08:17
 */
public interface BrandService {
	/**
	 * 获得品牌列表通过行业
	 * @param industryId
	 * @return
	 */
	public List<Brand> getBrandSerach(String industrys,String str);
	
	/**
	 * 添加品牌到库
	 * @param brand
	 */
	public int addBrandToPublic(Brand brand);

}
