package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.ProductAllocationDto;
import com.wskc.model.ProductAllocation;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品调拨接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:20:40
 */
public interface ProductAllocationDao extends IBaseDao<ProductAllocation>{
	
	/**
	 * 分页获得调拨单
	 * @param userId
	 * @param str
	 * @return
	 */
	Pager<ProductAllocation> findProductAllocation(int userId,String str);
	
	/**
	 * 获得调拨单Dto
	 * @param id
	 * @return
	 */
	ProductAllocationDto getProductAllocationDtoById(int id);
	
	
	/**
	 * 获得调拨单
	 * @param userId
	 * @param str
	 * @return
	 */
	List<ProductAllocation> getProductAllocation(int userId,String str,String type);
	
	
	
}
