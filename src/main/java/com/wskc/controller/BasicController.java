package com.wskc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wskc.dto.AjaxObj;
import com.wskc.dto.IndustryUserDto;
import com.wskc.model.Industry;
import com.wskc.model.IndustryUser;
import com.wskc.model.User;
import com.wskc.model.UserBrandPUser;
import com.wskc.service.IndustryService;
import com.wskc.service.IndustryUserService;
import com.wskc.service.UserBrandPUserService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:基础档案模块的controller</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午4:26:07
 */
@Controller
@RequestMapping("/basic")
public class BasicController {
	Logger logger =Logger.getLogger(BasicController.class);
	
	@Autowired
	private IndustryUserService industryUserService;
	
	@Autowired
	private IndustryService industryService;
	
	@Autowired
	private UserBrandPUserService userBrandPUserService;
	/**
	 * 
	 * 获得用户行业列表
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/industryList",method=RequestMethod.GET)
	public String industryView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		logger.info("I am coming industryList");
		model.addAttribute("menuids", menuids);
		User user=(User) session.getAttribute("loginer");
		List<IndustryUserDto> liud=industryUserService.getIndustryByUserId(user.getId());
//		List<IndustryUserDto> liud=industryUserService.getIndustryByUserId(1);
		model.addAttribute("liud", liud);
		return "basic/Industry";
	}
	/**
	 * 跳转到添加用户所属行业
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addIndustryUser",method=RequestMethod.GET)
	public  String addIndustryUser(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		model.addAttribute("li", industryService.getIndustryList());
		return "basic/AddIndustryUser";
	}
	
	/**
	 * 添加用户所属行业
	 * @param industryUserDto
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addIndustryUser",method=RequestMethod.POST)
	public String addIndustryUser(@RequestParam("menuids") String menuids,@Param Integer industryId,HttpSession session,Model model){
		User user=(User) session.getAttribute("loginer");
		if(industryId<1){
			model.addAttribute("msg", "添加失败,tip:请选择行业");
			model.addAttribute("menuids", menuids);
			model.addAttribute("li", industryService.getIndustryList());
			return "basic/AddIndustryUser";
		}
		IndustryUser industryUser=new IndustryUser();
		industryUser.setIndustryId(industryId);
		industryUser.setCreateTime(new Date());
		industryUser.setModifyTime(new Date());
//		industryUser.setUserId(1);
		industryUser.setUserId(user.getId());
		boolean isSuccess=industryUserService.addIndustryUser(industryUser);
		if(isSuccess){
			return "redirect:industryList?menuids="+menuids;
		}else{
			model.addAttribute("msg", "添加失败,tip:可能已经有该行业");
			model.addAttribute("menuids", menuids);
			model.addAttribute("li", industryService.getIndustryList());
			return "basic/AddIndustryUser";
		}
	}
	
	/**
	 * 删除行业用户
	 * @param menuids
	 * @param industryId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/deleteIndustryUser",method=RequestMethod.POST)
	public @ResponseBody AjaxObj deleteIndustryUser(@RequestParam("menuids") String menuids,@Param Integer industryId,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		// 先判断是否该行业下有品牌
		List<UserBrandPUser> lubp=userBrandPUserService.getUserBrandPUserByIndustry(user.getId(), industryId);
//		List<UserBrandPUser> lubp=userBrandPUserService.getUserBrandPUserByIndustry(1, industryId);
		if(lubp!=null&&lubp.size()>0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("您将要删除的行业下还有品牌,不能删除");
			return ajaxObj;
		}
		industryUserService.deleteIndustryUserByUI(user.getId(), industryId);
//		industryUserService.deleteIndustryUserByUI(1, industryId);
		ajaxObj.setResult(1);
		ajaxObj.setMsg("删除成功");
		return ajaxObj;
	}
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/brandList",method=RequestMethod.GET)
	public String brandView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		//TODO 获得当前用户的所属行业
		
		//TODO 获得当前用户的品牌
		return "/basic/BrandList";
	}
}
