package com.wskc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.cs.basic.model.Pager;
import org.cs.basic.util.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wskc.dto.AjaxObj;
import com.wskc.model.Purchase;
import com.wskc.model.PurchaseStatus;
import com.wskc.model.User;
import com.wskc.service.PurchaseService;
import com.wskc.service.UserBrandPUserService;
import com.wskc.service.UserProductStockService;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private UserBrandPUserService userBrandPUserService;
	@Autowired
	private UserProductStockService userProductStockService;
	
	@Autowired
	private PurchaseService purchaseService;

	
	
	@RequestMapping(value="/AddPurchase",method=RequestMethod.GET)
	public String addPurchaseView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		model.addAttribute("menuids", menuids);
		model.addAttribute("status", EnumUtils.enum2Map(PurchaseStatus.class));
		return "purchase/AddPurchase";
	}
	
	
	/**
	 * 品牌搜索
	 * @param model
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/brandSearch")
	public @ResponseBody AjaxObj getBrandSearch(@RequestParam("q") String q,Model model,HttpSession session) throws UnsupportedEncodingException{
		User user=(User) session.getAttribute("loginer");
		q=new String(q.getBytes("iso8859-1"), "utf-8");  
		AjaxObj ajaxObj=new AjaxObj();
		if(StringUtils.isNotEmpty(q)){
			ajaxObj.setObj(userBrandPUserService.getUBPUDByP(user.getId(), q));
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
	/**
	 * 产品搜索
	 * @param model
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/productSearch")
	public @ResponseBody AjaxObj getProductSearch(@RequestParam("q") String q,HttpSession session) throws UnsupportedEncodingException{
		User user=(User) session.getAttribute("loginer");
		q=new String(q.getBytes("iso8859-1"), "utf-8");  
		AjaxObj ajaxObj=new AjaxObj();
		if(StringUtils.isNotEmpty(q)){
			ajaxObj.setObj(userProductStockService.getUserProductByq(user.getId(), q));
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
	
	/**
	 * 添加采购
	 * @param purchase
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AddPurchase",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addPurchase(Purchase purchase,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		purchase.setModifyTime(purchase.getCreateTime());
		purchase.setUserId(user.getId());
		Purchase purchase2=purchaseService.addPurchase(purchase);
		if(purchase2!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}
		return ajaxObj;
	}
	/**
	 * 采购订单列表视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/PurchaseList",method=RequestMethod.GET)
	public String PurchaseListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "purchase/PurchaseList";
	}
	/**
	 * 获得采购单列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/PurchaseList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj PurchaseList(@RequestParam("str") String str,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		Pager<Purchase> pp=purchaseService.findPurchaseList(user.getId(), str);
		if(pp!=null){
			ajaxObj.setResult(1);
			ajaxObj.setObj(pp);
		}else{
			ajaxObj.setResult(0); 
			ajaxObj.setMsg("查询失败");
		}
		return ajaxObj;
	}
}
