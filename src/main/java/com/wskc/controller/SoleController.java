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
import com.wskc.dto.SoleChartVO;
import com.wskc.dto.SoleDto;
import com.wskc.dto.SoleNetChartVO;
import com.wskc.dto.UserBrandPUserDto;
import com.wskc.model.PurchaseStatus;
import com.wskc.model.Sole;
import com.wskc.model.SoleStatus;
import com.wskc.model.SoleType;
import com.wskc.model.User;
import com.wskc.service.SoleService;
import com.wskc.service.UserBrandPUserService;
import com.wskc.service.UserProductStockService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:销售</p>
 * @author Mr.Cheng
 * @date 2017年2月6日 下午7:10:36
 */
@Controller
@RequestMapping("sole")
public class SoleController {
	@Autowired
	private UserBrandPUserService userBrandPUserService;
	@Autowired
	private UserProductStockService userProductStockService;
	@Autowired
	private SoleService soleService;
	
	@RequestMapping(value="/AddSole",method=RequestMethod.GET)
	public String addSoleView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		model.addAttribute("menuids", menuids);
		model.addAttribute("types", EnumUtils.enum2Name(SoleType.class));
		model.addAttribute("status", EnumUtils.enum2Map(SoleStatus.class));
		return "sole/AddSole";
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
	 * 添加销售
	 * @param purchase
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AddSole",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addSole(Sole sole,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		sole.setSoleUserId(user.getId());
		Sole sole2=soleService.addSole(sole);
		if(sole2!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("添加失败,查看是否可售库存小于当前销售单数量");
		}
		return ajaxObj;
	}
	/**
	 * 销售订单列表视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/SoleList",method=RequestMethod.GET)
	public String purchaseListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "sole/SoleList";
	}
	/**
	 * 获得销售列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/SoleList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj soleList(@RequestParam("str") String str,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		Pager<Sole> s=soleService.findSoleList(user.getId(), str);
		if(s!=null){
			ajaxObj.setResult(1);
			ajaxObj.setObj(s);
		}else{
			ajaxObj.setResult(0); 
			ajaxObj.setMsg("查询失败");
		}
		return ajaxObj;
	}
	/**
	 * 展示销售订单
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/showSole",method=RequestMethod.GET)
	public String showSole(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			SoleDto sd=soleService.getSoleDtoById(id);
			model.addAttribute("sd", sd);
			return "sole/ShowSole";
		}else{
			return "redirect:SoleList?menuids="+menuids;
		}
	}
	/**
	 * 编辑销售页面
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/EditSole",method=RequestMethod.GET)
	public String editSoleView(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			SoleDto sd=soleService.getSoleDtoById(id);
			model.addAttribute("sd", sd);
			model.addAttribute("status", EnumUtils.enum2Map(PurchaseStatus.class));
			return "sole/EditSole";
		}else{
			return "redirect:SoleList?menuids="+menuids;
		}
	}
	/**
	 * 编辑销售
	 * @param Sole
	 * @return
	 */
	@RequestMapping(value="/EditSole",method=RequestMethod.POST)
	public @ResponseBody AjaxObj editSole(Sole sole){
		AjaxObj ajaxObj=new AjaxObj();
		if(sole.getId()<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("id不正确");
		}else{
			boolean isSuccess=soleService.editSole(sole);
			if(isSuccess){
				ajaxObj.setResult(1);
				ajaxObj.setMsg("修改成功");
			}else{
				ajaxObj.setResult(0);
				ajaxObj.setMsg("修改失败,查不到该记录或者数量大于库存");
			}
		}
		return ajaxObj;
	}
	
	
	/**
	 * 销售单搜索
	 * @param model
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/SoleSearch")
	public @ResponseBody AjaxObj getSoleSearch(@RequestParam("q") String q,HttpSession session) throws UnsupportedEncodingException{
		User user=(User) session.getAttribute("loginer");
		q=new String(q.getBytes("iso8859-1"), "utf-8");  
		AjaxObj ajaxObj=new AjaxObj();
		if(StringUtils.isNotEmpty(q)){
			ajaxObj.setObj(soleService.getSoleList(user.getId(), q));
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
	/**
	 * 销售报表
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/SoleChart",method=RequestMethod.GET)
	public String soleChartView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<UserBrandPUserDto> lubpud=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpud", lubpud);
		return "sole/SoleChart";
	}
   /**
    * 获得销售表报信息
    * @param brandId
    * @param session
    * @return
    */
	@RequestMapping(value="/SoleChart",method=RequestMethod.POST)
	public @ResponseBody AjaxObj soleChart(@RequestParam("brandId") int brandId,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		if(brandId<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("参数不对");
		}else{
			SoleChartVO soleChartVo=soleService.getSoleChartVO(user.getId(), brandId);
			if(soleChartVo.getProductName().size()<1){
				ajaxObj.setResult(0);
				ajaxObj.setMsg("暂无记录");
			}else{
				ajaxObj.setResult(1);
				ajaxObj.setObj(soleChartVo);
			}
		}
		return ajaxObj;
	}
	/**
	 * 销售报表
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/SoleNetChart",method=RequestMethod.GET)
	public String soleNetView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<UserBrandPUserDto> lubpud=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpud", lubpud);
		return "sole/SoleNetChart";
	}
	/**
    * 获得销售利润信息
    * @param brandId
    * @param session
    * @return
    */
	@RequestMapping(value="/SoleNetChart",method=RequestMethod.POST)
	public @ResponseBody AjaxObj soleNetChart(@RequestParam("brandId") int brandId,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		if(brandId<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("参数不对");
		}else{
			SoleNetChartVO soleNetChartVO=soleService.getSoleNetChartVO(user.getId(), brandId);
			if(soleNetChartVO.getProductName().size()<1){
				ajaxObj.setResult(0);
				ajaxObj.setMsg("暂无记录");
			}else{
				ajaxObj.setResult(1);
				ajaxObj.setObj(soleNetChartVO);
			}
		}
		return ajaxObj;
	}

}
