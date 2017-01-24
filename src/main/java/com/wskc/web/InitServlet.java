package com.wskc.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static WebApplicationContext wc;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		wc=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		System.out.println("------------------系统初始化的地方----------------");
	}
	
	public static WebApplicationContext getWc(){
		return wc;
	}
	public static Object getBean(String name) {
		return wc.getBean(name);
	}
}
