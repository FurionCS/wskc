package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductLibraryDao;
import com.wskc.model.ProductLibrary;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品出库实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:24:34
 */
@Repository("productLibraryDao")
public class ProductLibraryDaoImpl extends BaseDao<ProductLibrary> implements ProductLibraryDao{

}
