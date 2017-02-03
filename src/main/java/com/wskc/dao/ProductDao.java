package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;

import com.wskc.dto.ProductDto;
import com.wskc.model.Product;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:21:18
 */
public interface ProductDao extends IBaseDao<Product>{
	
	/**
	 * 根据品牌id,搜索字符串获得产品
	 * @param productId
	 * @param str
	 * @return
	 */
	public List<Product> getProductSearch(String brandIds,String str);
	
	/**
	 * 根据产品id获得产品品牌相关信息
	 * @param id
	 * @return
	 */
	public ProductDto getProductDto(int id);

}
