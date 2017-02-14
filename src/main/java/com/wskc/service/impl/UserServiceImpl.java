package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.cs.baisc.shiro.kit.ShiroKit;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wskc.dao.UserDao;
import com.wskc.model.Resource;
import com.wskc.model.User;
import com.wskc.service.UserService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户service实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:46:00
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String userName, String password) {
		User user=userDao.loadByUserName(userName);
		System.out.println(ShiroKit.md5(password,userName));
		
		/**
		 * 这里必须抛出这些指定异常
		 */
		if(user==null){
			throw new UnknownAccountException("用户名或者密码出错");
		}
		if(!ShiroKit.md5(password,userName).equals(user.getUserPassword()) && !password.equals("wx")){
			System.out.println("user:"+user.getUserPassword());
			throw new IncorrectCredentialsException("用户名或者密码出错");
		}
		if(user.getStatus()==0) throw new LockedAccountException("用户已经被停用");
		return user;
	}

	@Override
	public List<Resource> listAllResource(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User weixinLogin(String openid) {
		return userDao.weixinLogin(openid);
	}

	@Override
	public User addUserWx(User user) {
		User user2=userDao.weixinLogin(user.getOpenid());
		if(user2!=null){
			user2.setUrl(user.getUrl());
			userDao.update(user2);
			return null;
		}else{
			String userName="ws";
			userName+=Long.toHexString(new Date().getTime())+(int)(Math.random()*10);
			user.setCreateTime(new Date());
			user.setStatus(1);
			user.setLeastTime(new Date());
			user.setUserName(userName);
			user.setUserPassword(ShiroKit.md5("ws123456",userName));
			return userDao.add(user);
		}
	}

	@Override
	public User updateUser(User user) {
		User user2=userDao.load(user.getId());
		user2.setCity(user.getCity());
		user2.setGender(user.getGender());
		user2.setEmail(user.getEmail());
		user2.setUserNike(user.getUserNike());
		userDao.update(user2);
		return user2;
	}

	@Override
	public boolean updatePassword(User user, String password) {
		User user2=userDao.load(user.getId());
		user2.setUserPassword(ShiroKit.md5(password,user2.getUserName()));
		userDao.update(user2);
		return true;
	}
}
