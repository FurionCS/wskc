package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductDao;
import com.wskc.model.Product;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:24:19
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao{

}
