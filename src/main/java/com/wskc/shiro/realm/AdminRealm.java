package com.wskc.shiro.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;






import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.cs.baisc.shiro.kit.ShiroKit;
import org.jboss.logging.Logger;

import com.wskc.model.Resource;
import com.wskc.model.User;
import com.wskc.service.UserService;
import com.wskc.web.InitServlet;

public class AdminRealm extends AuthorizingRealm {
	Logger logger = Logger.getLogger(AdminRealm.class);
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User user = ((User)principals.getPrimaryPrincipal());
		int uid = user.getId();
		System.out.println(user.getId()+","+user.getUserName());
		UserService userService = (UserService)InitServlet.getBean("userService");
	//	List<String> roles = userService.listRoleSnByAdmin(uid);
		List<Resource> reses = userService.listAllResource(uid);
		List<String> permissions = new ArrayList<String>();
		String url="";
		if(reses!=null){
			for(Resource r:reses) {
				permissions.add(r.getUrl());
				url+="--"+r.getUrl();
			}
		}
		System.out.println(url);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	//	info.setRoles(new HashSet<String>(roles));
		info.setStringPermissions(new HashSet<String>(permissions));
		return info;
	}
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UserService adminService = (UserService)InitServlet.getBean("userService");
		String adminname = token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		User user = adminService.login(adminname, password);
		if(password.equals("wx")){
			//TODO暂时先这么写，这里应该不能怎么写，是否有免密认证？
			String wxpassword=ShiroKit.md5(password,adminname);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, wxpassword,this.getName());
			info.setCredentialsSalt(ByteSource.Util.bytes(user.getUserName()));
			return info;
		}else{
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(),this.getName());
			//设置盐值
			info.setCredentialsSalt(ByteSource.Util.bytes(user.getUserName()));
			return info;
		}
	}


	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		//System.out.println("清除授权的缓存");
		Cache c = this.getAuthorizationCache();
		Set<Object> keys = c.keys();
		for(Object o:keys) {
			System.out.println("授权缓存:"+o+"-----"+c.get(o)+"----------");
		}
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		//System.out.println("清除认证的缓存");
		Cache c = this.getAuthenticationCache();
		Set<Object> keys = c.keys();
		for(Object o:keys) {
			System.out.println("认证缓存:"+o+"----------"+c.get(o)+"----------");
		}
		User admin = ((User)principals.getPrimaryPrincipal());
		SimplePrincipalCollection spc = new SimplePrincipalCollection(admin.getUserName(), getName());
		super.clearCachedAuthenticationInfo(spc);
	}
}
