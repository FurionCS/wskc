package com.wskc.dao;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.model.ProductStorage;
import com.wskc.model.ProductStorageDto;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品入库接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:21:46
 */
public interface ProductStorageDao extends IBaseDao<ProductStorage>{
	
	/**
	 * 入库列表
	 * @param userId
	 * @param str
	 * @return
	 */
	Pager<ProductStorage> findProductStorageList(int userId,String str);
	
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
	
}
