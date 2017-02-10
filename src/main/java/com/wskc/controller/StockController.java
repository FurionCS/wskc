package com.wskc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.cs.basic.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wskc.dto.AgentKcSerachDto;
import com.wskc.dto.AjaxObj;
import com.wskc.dto.ProductAgentDto;
import com.wskc.dto.ProductAgentInfoDto;
import com.wskc.dto.ProductAgentTree;
import com.wskc.dto.ProductDto;
import com.wskc.dto.ProductStockWarnDto;
import com.wskc.dto.UserBrandPUserDto;
import com.wskc.dto.UserProductDto;
import com.wskc.model.User;
import com.wskc.service.ProductService;
import com.wskc.service.UserBrandPUserService;
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
	@Autowired
	private UserBrandPUserService userBrandPUserService;
	
	@Autowired
	private ProductService productService;
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
	/**
	 * 代理库存页面
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/AgentKc",method=RequestMethod.GET)
	public String getAgentKcView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<UserBrandPUserDto> lubpd=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpd", lubpd);
		return "stock/AgentKcList";
	}
	/**
	 * 代理库存
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AgentKc",method=RequestMethod.POST)
	public @ResponseBody AjaxObj getAgentKc(AgentKcSerachDto agentKcDto,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		if(agentKcDto.getBrandId()<0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("品牌id不能为空");
		}else{
			List<ProductAgentDto> ppad=userProductStockService.getProductAgentDto(agentKcDto.getBrandId(), user.getId(), agentKcDto.getProductId());
			ajaxObj.setResult(1);
			ajaxObj.setObj(ppad);
		}
		return ajaxObj;
	}
	/**
	 * 得到代理产品详细库存
	 * @return
	 */
	@RequestMapping(value="/productAgent",method=RequestMethod.GET)
	public String getProductAgentInfoView(@RequestParam("menuids") String menuids,@RequestParam("productId") int productId,Model model){
		model.addAttribute("menuids", menuids);
		ProductDto pd=productService.getProductDto(productId);
		model.addAttribute("pd",pd);
		return "stock/AgentKcInfoList";
	}
	
	/**
	 * 得到代理产品详细库存
	 * @return
	 */
	@RequestMapping(value="/productAgent",method=RequestMethod.POST)
	public @ResponseBody AjaxObj getProductAgentInfo( AgentKcSerachDto agentKcSerachDto,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		if(agentKcSerachDto.getBrandId()<1||agentKcSerachDto.getProductId()<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("品牌id,或产品id不能为空");
		}else{
			Pager<ProductAgentInfoDto> ppaid= userProductStockService.findProductAgentInfoDto(agentKcSerachDto.getBrandId(), user.getId(), agentKcSerachDto.getProductId());
			ajaxObj.setResult(1);
			ajaxObj.setObj(ppaid);
		}
		return ajaxObj;
	}
	
	/**
	 * 代理库存树页面
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/AgentKcTree",method=RequestMethod.GET)
	public String getAgentKcTreeView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<UserBrandPUserDto> lubpd=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpd", lubpd);
		return "stock/AgentKcTreeList";
	}
	/**
	 * 
	 * @param brandId
	 * @param productId
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/AgentKcTreeInfo",method=RequestMethod.POST)
	public @ResponseBody List<ProductAgentTree> treeList(int brandId,int productId,int id){
		List<ProductAgentTree> lg=userProductStockService.listProductAgentTree(brandId, id, productId);
		return lg;
	}
	/**
	 * 获得警告库存信息
	 * @return
	 */
	@RequestMapping(value="/listProductStockWarn",method=RequestMethod.POST)
	public @ResponseBody AjaxObj listProductStockWarn(HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		List<ProductStockWarnDto> lpswd=userProductStockService.listProductStockWarn(user.getId());
		ajaxObj.setResult(1);
		ajaxObj.setObj(lpswd);
		return ajaxObj;
	}
}
