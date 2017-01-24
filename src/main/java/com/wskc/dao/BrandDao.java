package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;

import com.wskc.model.Brand;
/**
 * 
 * <p>Title:</p>
 * <p>Description:品牌</p>
 * @author Mr.Cheng
 * @date 2017年1月24日 下午7:18:27
 */
public interface BrandDao extends IBaseDao<Brand>{
	
	/**
	 * 获得品牌
	 * @param id
	 * @return
	 */
	public Brand getBrandById(int id);
	
	/**
	 * 获得品牌列表通过行业
	 * @param industryId
	 * @return
	 */
	public List<Brand> getBrandSerach(String industryIds,String str);

}
