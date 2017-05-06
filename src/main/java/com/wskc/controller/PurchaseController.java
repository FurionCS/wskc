package com.wskc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
import com.wskc.dto.PurchaseChartVO;
import com.wskc.dto.PurchaseDto;
import com.wskc.dto.SoleNetChartVO;
import com.wskc.dto.UserBrandPUserDto;
import com.wskc.model.Purchase;
import com.wskc.model.PurchaseStatus;
import com.wskc.model.User;
import com.wskc.service.PurchaseService;
import com.wskc.service.UserBrandPUserService;
import com.wskc.service.UserProductStockService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:采购</p>
 * @author Mr.Cheng
 * @date 2017年5月5日 下午10:35:38
 */
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
	public String purchaseListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "purchase/PurchaseList";
	}
	/**
	 * 获得采购单列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/PurchaseList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj purchaseList(@RequestParam("str") String str,HttpSession session){
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
	/**
	 * 展示采购订单
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/showPurchase",method=RequestMethod.GET)
	public String showPurchase(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			PurchaseDto pd=purchaseService.getPurchaseDtoById(id);
			model.addAttribute("pd", pd);
			return "purchase/ShowPurchase";
		}else{
			return "redirect:PurchaseList?menuids="+menuids;
		}
	}
	/**
	 * 编辑采购页面
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/EditPurchase",method=RequestMethod.GET)
	public String editPurchaseView(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			PurchaseDto pd=purchaseService.getPurchaseDtoById(id);
			model.addAttribute("pd", pd);
			model.addAttribute("status", EnumUtils.enum2Map(PurchaseStatus.class));
			return "purchase/EditPurchase";
		}else{
			return "redirect:PurchaseList?menuids="+menuids;
		}
	}
	/**
	 * 编辑采购
	 * @param purchase
	 * @return
	 */
	@RequestMapping(value="/EditPurchase",method=RequestMethod.POST)
	public @ResponseBody AjaxObj editPurchase(Purchase purchase){
		AjaxObj ajaxObj=new AjaxObj();
		if(purchase.getId()<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("id不正确");
		}else{
			
			boolean isSuccess=purchaseService.editPurchase(purchase);
			if(isSuccess){
				ajaxObj.setResult(1);
				ajaxObj.setMsg("修改成功");
			}else{
				ajaxObj.setResult(0);
				ajaxObj.setMsg("修改失败,查不到该记录");
			}
		}
		return ajaxObj;
	}
	
	
	/**
	 * 采购单搜索
	 * @param model
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/PurchaseSearch")
	public @ResponseBody AjaxObj getPurchaseSearch(@RequestParam("q") String q,HttpSession session) throws UnsupportedEncodingException{
		User user=(User) session.getAttribute("loginer");
		q=new String(q.getBytes("iso8859-1"), "utf-8");  
		AjaxObj ajaxObj=new AjaxObj();
		if(StringUtils.isNotEmpty(q)){
			ajaxObj.setObj(purchaseService.getPurchaseList(user.getId(), q));
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
	
	
	/**
	 * 采购报表
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/PurchaseChart",method=RequestMethod.GET)
	public String soleNetView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<UserBrandPUserDto> lubpud=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpud", lubpud);
		return "purchase/PurchaseChart";
	}
	/**
    * 获得采购金额信息
    * @param brandId
    * @param session
    * @return
    */
	@RequestMapping(value="/PurchaseChart",method=RequestMethod.POST)
	public @ResponseBody AjaxObj soleNetChart(@RequestParam("brandId") int brandId,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		if(brandId<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("参数不对");
		}else{
			PurchaseChartVO purchaseChartVO=purchaseService.getPurchaseChartVO(user.getId(), brandId);
			if(purchaseChartVO.getProductName().size()<1){
				ajaxObj.setResult(0);
				ajaxObj.setMsg("暂无记录");
			}else{
				ajaxObj.setResult(1);
				ajaxObj.setObj(purchaseChartVO);
			}
		}
		return ajaxObj;
	}
	
}
