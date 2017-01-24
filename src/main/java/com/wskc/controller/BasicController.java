package com.wskc.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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
import com.wskc.dto.UserBrandPUserDto;
import com.wskc.model.IndustryUser;
import com.wskc.model.User;
import com.wskc.model.UserBrandPUser;
import com.wskc.service.BrandService;
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
	
	@Autowired
	private BrandService brandService;
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
	 * 品牌列表
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/brandList",method=RequestMethod.GET)
	public String brandView(@RequestParam("menuids") String menuids,@RequestParam("industryId") Integer industryId,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
			// 获得当前用户的所属行业
		List<IndustryUserDto> liud=industryUserService.getIndustryByUserId(user.getId());
		if(liud!=null&&liud.size()>0){
			// 获得当前用户的品牌
			model.addAttribute("liud", liud);
			if(industryId==null||industryId<1){
				List<UserBrandPUserDto> lubpd=userBrandPUserService.getUBPUDAll(user.getId());
				model.addAttribute("lubpd", lubpd);
			}else{
				List<UserBrandPUserDto> lubpd=userBrandPUserService.getUBPUDByIndustry(user.getId(), industryId);
				model.addAttribute("lubpd", lubpd);
			}
		}
		return "/basic/BrandList";
	}
	/**
	 * 添加品牌
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addBrand",method=RequestMethod.GET)
	public String addBrand(Model model,HttpSession session,@RequestParam("menuids") String menuids){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
			// 获得当前用户的所属行业
		List<IndustryUserDto> liud=industryUserService.getIndustryByUserId(user.getId());
		if(liud!=null&&liud.size()>0){
			model.addAttribute("liud", liud);
			return "/basic/AddBrand";
		}else{
			//正常情况下不会跳到这个
			return "redirect:addIndustryUser?menuids=2_1";
		}
	}
	
	/**
	 * 添加品牌
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addUserBrandPUser",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addUserBrandPUser(UserBrandPUser userBrandPUser,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		userBrandPUser.setUserId(user.getId());
		int code=userBrandPUserService.addUBPU(userBrandPUser);
		if(code==1){
			ajaxObj.setResult(1);
		}else if(code==-1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("您已经有该品牌，请勿重复添加");
		}else if(code==-2){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("您填写的授权码不存在,请和上家核实");
		}
		return ajaxObj;
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
			List<IndustryUserDto> liud=industryUserService.getIndustryByUserId(user.getId());
			String industrys="";
			for(int i=0;i<liud.size();i++){
				if(i==0){
					industrys+=liud.get(i).getIndustryId();
				}else{
					industrys+=","+liud.get(i).getIndustryId();
				}
			}
			ajaxObj.setObj(brandService.getBrandSerach(industrys, q));
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
}
