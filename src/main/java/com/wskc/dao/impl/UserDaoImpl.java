package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.UserDao;
import com.wskc.model.User;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户表实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:25:07
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User login(String userName, String password) {
		String hql="from User where userName=? and userPassword=?";
		return (User) this.queryObject(hql, new Object[]{userName,password});
	}

	@Override
	public User loadByUserName(String userName) {
		String hql="from User where userName=?";
		return (User) this.queryObject(hql,userName);
	}

	@Override
	public User weixinLogin(String openid) {
		String hql="from User where openid=?";
		return (User) this.queryObject(hql, openid);
	}

	@Override
	public User getUserById(int id) {
		String hql="from User where id=?";
		return (User) this.queryObject(hql, id);
	}

}
