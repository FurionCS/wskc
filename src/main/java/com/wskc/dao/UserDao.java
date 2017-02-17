package com.wskc.dao;

import org.cs.basic.dao.IBaseDao;

import com.wskc.model.User;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:23:26
 */
public interface UserDao extends IBaseDao<User>{
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName,String password);
	/**
	 * 通过userName获取用户信息
	 * @param userName
	 * @return
	 */
	User loadByUserName(String userName);
	/**
	 * 通过openid获得登入
	 * @param openid
	 * @return
	 */
	User weixinLogin(String openid);
	/**
	 * 通过id获得用户信息
	 * @param id
	 * @return
	 */
	User getUserById(int id);
}
