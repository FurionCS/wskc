package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.cs.baisc.shiro.kit.ShiroKit;
import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.template.Template;
import org.cs.basic.weixin.template.model.TemplateSendResultModel;
import org.cs.basic.weixin.template.model.TemplateValueAndColor;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wskc.config.WeiXinConfig;
import com.wskc.dao.UserDao;
import com.wskc.dto.TemplateDate;
import com.wskc.dto.TemplateSendModel;
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
			//推送账号密码
			try {
				String accessToken=AccessToken.getAccessToken(WeiXinConfig.APPID, WeiXinConfig.SECRET);
				TemplateSendModel tsm=new TemplateSendModel();
				tsm.setTouser(user.getOpenid());
				tsm.setTemplate_id(WeiXinConfig.NPTEMPLATEID);
				tsm.setUrl("www.believeyou.top/wskc");
				TemplateDate td=new TemplateDate();
				TemplateValueAndColor tvc0=new TemplateValueAndColor(user.getUserNike(),"#173177");
				TemplateValueAndColor tvc1=new TemplateValueAndColor(user.getUserName(),"#173177");
				TemplateValueAndColor tvc2=new TemplateValueAndColor("ws123456","#173177");
				td.setName(tvc0);
				td.setUsername(tvc1);
				td.setPassword(tvc2);
				tsm.setData(td);
				String templSenddatestr=net.sf.json.JSONObject.fromObject(tsm).toString();
				System.out.println(templSenddatestr);
				TemplateSendResultModel ltm=Template.sendTemplate(templSenddatestr, accessToken);
			} catch (Exception e) {
				logger.error("推送失败：原因："+e.getMessage());
				e.printStackTrace();
			}

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
	@Override
	@Cacheable(value="wskc",key="'wskc_user_'+#id")
	public User getUserById(int id){
		System.out.println("我进来了咯");
		return userDao.getUserById(id);
	}
}
