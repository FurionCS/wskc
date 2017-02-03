package com.wskc.service;

import java.util.List;

import com.wskc.model.Brand;
import com.wskc.model.Product;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品</p>
 * @author Mr.Cheng
 * @date 2017年1月30日 下午10:16:10
 */
public interface ProductService {
	/**
	 * 获得品牌列表通过行业
	 * @param industryId
	 * @return
	 */
	public List<Product> getProductSerach(String brandIds,String str);
	
	/**
	 * 添加产品
	 * @param product
	 * @return
	 */
	public Product addProduct(Product product);
}
