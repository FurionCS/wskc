package com.wskc.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.cs.baisc.shiro.kit.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wskc.dto.AjaxObj;
import com.wskc.model.User;
import com.wskc.service.UserService;
@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		return "home/index";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpSession session){
		session.removeAttribute("loginer");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
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
	
	@RequestMapping(value="/weixinLogin")
	public String weixinLogin(@RequestParam("openid") String openid,Model model){
		Subject subject = SecurityUtils.getSubject();
		User user=userService.weixinLogin(openid);
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), "wx");
		String emsg=null;
		try {
			System.out.println("token:"+token);
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
	/**
	 * 展示用户信息
	 * @return
	 */
	@RequestMapping(value="/ShowUser",method=RequestMethod.GET)
	public String showUserView(HttpSession session,Model model){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("user", user);
		return "home/ShowUser";
	}
	/**
	 * 展示用户信息
	 * @return
	 */
	@RequestMapping(value="/EditUser",method=RequestMethod.GET)
	public String EditUserView(HttpSession session,Model model){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("user", user);
		return "home/EditUser";
	}
	/**
	 * 展示用户信息
	 * @return
	 */
	@RequestMapping(value="/EditUser",method=RequestMethod.POST)
	public @ResponseBody AjaxObj EditUser(User user,HttpSession session,Model model){
		AjaxObj ajaxObj=new AjaxObj();
		if(user.getId()<1||user.getUserNike().equals("")||user.getGender().equals("")){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("参数不对");
		}else{
			User user3=userService.updateUser(user);
			session.setAttribute("loginer", user3);
			ajaxObj.setResult(1);
			ajaxObj.setMsg("成功修改");
		}
		return ajaxObj;
	}
	@RequestMapping(value="/updatePassword",method=RequestMethod.GET)
	public String updatePasswordView(){
		return "home/UpdatePassword";
	}
	/**
	 * 修改用户密码
	 * @return
	 */
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)
	public @ResponseBody AjaxObj updatePassword(String password,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		if(password.length()<6||password.length()>12){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("密码长度不正确");
		}
		boolean isSuccess=userService.updatePassword(user, password);
		if(isSuccess){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("修改成功");
		}
		return ajaxObj;
	}
	
}
