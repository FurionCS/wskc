package com.wskc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.cs.basic.weixin.oauth.OAuthManage;
import org.cs.basic.weixin.oauth.model.OauthAccessToken;
import org.cs.basic.weixin.oauth.model.OauthUser;
import org.jboss.logging.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wskc.config.WeiXinConfig;

@Controller
@RequestMapping("/weixin")
public class WeiXinController {
	Logger logger=Logger.getLogger(WeiXinController.class);
	
	@RequestMapping(value="/auth",method=RequestMethod.GET)
	public void auth(HttpServletResponse resp) throws IOException{
		String location=OAuthManage.getLeadOAuthUrl(WeiXinConfig.APPID, WeiXinConfig.REDIRECT_URI, "snsapi_userinfo", "1");
		resp.sendRedirect(location);
	}
	
	
	
	@RequestMapping(value="/handleAuth")
	public void handleAuth(@RequestParam("code") String code,@RequestParam("state") String state) throws Exception{
		logger.info("code:"+code);
		OauthAccessToken oauthAccessToken=OAuthManage.get_oauth_access_token_by_code(WeiXinConfig.APPID, WeiXinConfig.SECRET, code);
		OauthUser oauthUser=OAuthManage.get_oauth_user_info(oauthAccessToken.getAccess_token(), oauthAccessToken.getOpenid());
		//TODO 这里获得授权后调用-执行微信登录
		
		System.out.println(oauthUser.getOpenid()+"/"+oauthUser.getNickname()+"/"+oauthUser.getHeadimgurl());
	}
	
}
