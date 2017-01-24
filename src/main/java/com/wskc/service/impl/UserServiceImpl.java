package com.wskc.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.cs.baisc.shiro.kit.ShiroKit;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
		if(!ShiroKit.md5(password,userName).equals(user.getUserPassword())){
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

}
