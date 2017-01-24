package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.UserProductStockDao;
import com.wskc.model.UserProductStock;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户库存实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:30:28
 */
@Repository("userProductStockDao")
public class UserProductStockDaoImpl extends BaseDao<UserProductStock> implements UserProductStockDao{

}
