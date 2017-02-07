package com.wskc.controller;

import javax.servlet.http.HttpSession;

import org.cs.basic.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wskc.dto.AjaxObj;
import com.wskc.dto.UserProductDto;
import com.wskc.model.User;
import com.wskc.service.UserProductStockService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:库存列表</p>
 * @author Mr.Cheng
 * @date 2017年2月6日 上午11:07:53
 */
@Controller
@RequestMapping("stock")
public class StockController {

	@Autowired
	private UserProductStockService userProductStockService;
	/**
	 * 库存列表视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/StockList",method=RequestMethod.GET)
	public String StockListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "stock/StockList";
	}
	/**
	 * 库存查询列表
	 * @param str
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/StockList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj getStockList(@RequestParam("str") String str,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		Pager<UserProductDto> pupd=userProductStockService.findUserProductStockForSerach(user.getId(), str);
		if(pupd==null||pupd.getTotal()<0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("查询暂无记录");
		}else{
			ajaxObj.setResult(1);
			ajaxObj.setObj(pupd);
		}
		return ajaxObj;
	}
}
