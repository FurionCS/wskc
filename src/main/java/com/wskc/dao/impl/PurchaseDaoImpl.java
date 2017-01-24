package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.PurchaseDao;
import com.wskc.model.Purchase;
/**
 * 
 * <p>Title:</p>
 * <p>Description:采购实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:26:38
 */
@Repository("purChaseDao")
public class PurchaseDaoImpl extends BaseDao<Purchase> implements PurchaseDao{

}
