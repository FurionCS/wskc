package com.wskc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.cs.baisc.shiro.kit.ShiroKit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wskc.model.User;
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		return "home/index";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "home/login";
	}
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public String checkLogin(User user,Model model){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
		
		String emsg=null;
		try {
			System.out.println(token);
			subject.login(token);
		} catch (AuthenticationException e) {
			emsg = e.getMessage();
			System.out.println("这里是报错:"+emsg);
		}
		if(!ShiroKit.isEmpty(emsg)) {
			model.addAttribute("error", 1);
			return "home/login";
		} else {		
			User u=(User)subject.getPrincipal();
			SecurityUtils.getSubject().getSession().setAttribute("loginer", u);
			return "redirect:index";
		}
	}
}
