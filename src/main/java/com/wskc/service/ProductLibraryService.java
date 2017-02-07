package com.wskc.service;

import org.cs.basic.model.Pager;

import com.wskc.dto.ProductLibraryDto;
import com.wskc.dto.ProductStorageDto;
import com.wskc.model.ProductLibrary;
import com.wskc.model.ProductStorage;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品出库</p>
 * @author Mr.Cheng
 * @date 2017年2月4日 下午2:32:24
 */
public interface ProductLibraryService {
	/**
	 * 出库列表
	 * @param userId
	 * @param str
	 * @return
	 */
	Pager<ProductLibrary> findProductLibraryList(int userId,String str);
	/**
	 * 添加出库
	 * @param productStorage
	 * @return
	 */
	ProductLibrary addProductLibrary(ProductLibrary productLibrary);
	
	
	/**
	 * 通过关联编号获得出库信息
	 * @param no
	 * @return
	 */
	ProductLibrary getProductLibraryByRNo(String no);
	
	/**
	 * 获得产品出库dto
	 * @param id
	 * @return
	 */
	ProductLibraryDto getProductLibraryDtoById(int id);
	
	/**
	 * 编辑产品出库
	 * @param productStorage
	 * @return
	 */
	boolean EditProductLibrary(ProductLibrary productLibrary);

}
