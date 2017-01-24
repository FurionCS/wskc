package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.model.ProductAllocation;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品调拨实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:23:58
 */
@Repository("productAllocationDao")
public class ProductAllocationDaoImpl extends BaseDao<ProductAllocation> implements ProductAllocationDao{

}
