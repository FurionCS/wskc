package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductStorageDao;
import com.wskc.model.ProductStorage;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品入库实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:24:50
 */
@Repository("productStorageDao")
public class ProductStorageDaoImpl extends BaseDao<ProductStorage> implements ProductStorageDao{

}
