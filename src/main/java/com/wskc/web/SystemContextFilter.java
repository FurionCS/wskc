package com.wskc.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.cs.basic.model.SystemContext;

public class SystemContextFilter implements Filter{
	private Integer pageSize;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		Integer offset=0;
		try {
		//	offset=Integer.parseInt(req.getParameter("pager.offset"));
			offset=Integer.parseInt(req.getParameter("offset"));
			pageSize=Integer.parseInt(req.getParameter("pageSize"));
		} catch (NumberFormatException e) {}
		try {
			SystemContext.setOrder(req.getParameter("order"));
			SystemContext.setSort(req.getParameter("sort"));
			SystemContext.setPageOffset(offset);
			SystemContext.setPageSize(pageSize);
			chain.doFilter(req,res);
		} finally{
			SystemContext.removeOrder();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeSort();
		}
	}

	public void init(FilterConfig cfg) throws ServletException {
		try{
			pageSize=Integer.parseInt(cfg.getInitParameter("pageSize"));
		}catch(NumberFormatException e){
			pageSize=5;
		}
	}

}
