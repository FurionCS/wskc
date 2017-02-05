package com.wskc.service;

import org.cs.basic.model.Pager;

import com.wskc.dto.ProductAllocationDto;
import com.wskc.model.ProductAllocation;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品调拨</p>
 * @author Mr.Cheng
 * @date 2017年2月5日 下午12:36:35
 */
public interface ProductAllocationService {
	/**
	 * 添加产品入库
	 * @param productAllocation
	 * @return
	 */
	ProductAllocation addProductAllocaiton(ProductAllocation productAllocation);
	
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
	 * 保存编辑调拨
	 * @param productAllocation
	 * @return
	 */
	boolean EditProductAllocation(ProductAllocation productAllocation);

}
