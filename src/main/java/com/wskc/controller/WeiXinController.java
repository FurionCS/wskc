package com.wskc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.cs.basic.weixin.oauth.OAuthManage;
import org.cs.basic.weixin.oauth.model.OauthAccessToken;
import org.cs.basic.weixin.oauth.model.OauthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wskc.config.WeiXinConfig;
import com.wskc.model.User;
import com.wskc.service.UserService;

@Controller
@RequestMapping("/weixin")
public class WeiXinController {
	Logger logger=Logger.getLogger(WeiXinController.class);
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping(value="/authGz",method=RequestMethod.GET)
//	public void authgz(HttpServletResponse resp) throws IOException{
//		System.out.println("我进关注了处理");
//		String location=OAuthManage.getLeadOAuthUrl(WeiXinConfig.APPID, WeiXinConfig.REDIRECTGZ_URI, "snsapi_userinfo", "1");
//		resp.sendRedirect(location);
//	}
//	
//	
//	
//	@RequestMapping(value="/handleAuthGz")
//	public void handleAuthgz(@RequestParam("code") String code,@RequestParam("state") String state) throws Exception{
//		logger.info("code:"+code);
//		OauthAccessToken oauthAccessToken=OAuthManage.get_oauth_access_token_by_code(WeiXinConfig.APPID, WeiXinConfig.SECRET, code);
//		OauthUser oauthUser=OAuthManage.get_oauth_user_info(oauthAccessToken.getAccess_token(), oauthAccessToken.getOpenid());
//		//TODO 这里获得授权后调用-执行微信登录
////		String openid="o9pbww7-CwheMiCL9yfgmqx4mOdQ";
//		System.out.println(oauthUser.getOpenid()+"/"+oauthUser.getNickname()+"/"+oauthUser.getHeadimgurl());
//		User user=new User();
//		user.setOpenid(oauthUser.getOpenid());
//		user.setUrl(oauthUser.getHeadimgurl());
//		user.setGender(oauthUser.getSex());
//		user.setCity(oauthUser.getCity());
//		userService.addUserWx(user);
////		return "redirect:/home/weixinLogin?openid="+oauthUser.getOpenid();
//	}
	
	@RequestMapping(value="/auth",method=RequestMethod.GET)
	public void auth(HttpServletResponse resp) throws IOException{
		String location=OAuthManage.getLeadOAuthUrl(WeiXinConfig.APPID, WeiXinConfig.REDIRECT_URI, "snsapi_userinfo", "1");
		resp.sendRedirect(location);
	}
	
	
	
	@RequestMapping(value="/handleAuth")
	public String handleAuth(@RequestParam("code") String code,@RequestParam("state") String state) throws Exception{
		logger.info("code:"+code);
		OauthAccessToken oauthAccessToken=OAuthManage.get_oauth_access_token_by_code(WeiXinConfig.APPID, WeiXinConfig.SECRET, code);
		OauthUser oauthUser=OAuthManage.get_oauth_user_info(oauthAccessToken.getAccess_token(), oauthAccessToken.getOpenid());
		// 这里获得授权后调用-执行微信登录
//		String openid="o9pbww7-CwheMiCL9yfgmqx4mOdQ";
		User user=new User();
		user.setOpenid(oauthUser.getOpenid());
		user.setUrl(oauthUser.getHeadimgurl());
		user.setGender(oauthUser.getSex());
		user.setCity(oauthUser.getCity());
		user.setUserNike(oauthUser.getNickname());
		userService.addUserWx(user);
		return "redirect:/home/weixinLogin?openid="+oauthUser.getOpenid();
	}
	
}
