package com.wskc.dao;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.ProductLibraryDto;
import com.wskc.model.ProductLibrary;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品出库接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:21:32
 */
public interface ProductLibraryDao extends IBaseDao<ProductLibrary>{
	/**
	 * 出库列表
	 * @param userId
	 * @param str
	 * @return
	 */
	Pager<ProductLibrary> findProductLibraryList(int userId,String str);
	
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
	

}
