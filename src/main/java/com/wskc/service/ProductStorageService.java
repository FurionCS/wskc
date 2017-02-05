package com.wskc.service;

import org.cs.basic.model.Pager;

import com.wskc.model.ProductStorage;
import com.wskc.model.ProductStorageDto;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品入库</p>
 * @author Mr.Cheng
 * @date 2017年2月4日 下午2:32:24
 */
public interface ProductStorageService {
	/**
	 * 入库列表
	 * @param userId
	 * @param str
	 * @return
	 */
	Pager<ProductStorage> findProductStorageList(int userId,String str);
	/**
	 * 添加入库
	 * @param productStorage
	 * @return
	 */
	ProductStorage addProductStorage(ProductStorage productStorage);
	
	
	/**
	 * 通过关联编号获得入库信息
	 * @param no
	 * @return
	 */
	ProductStorage getProductStorageByRNo(String no);
	
	/**
	 * 获得产品入库dto
	 * @param id
	 * @return
	 */
	ProductStorageDto getProductStorageDtoById(int id);
	
	/**
	 * 编辑产品入库
	 * @param productStorage
	 * @return
	 */
	boolean EditProductStorage(ProductStorage productStorage);

}
