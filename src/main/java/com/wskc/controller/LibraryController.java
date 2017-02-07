package com.wskc.controller;

import javax.servlet.http.HttpSession;

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
import com.wskc.dto.ProductLibraryDto;
import com.wskc.model.ProductLibrary;
import com.wskc.model.ProductLibraryStatus;
import com.wskc.model.ProductLibraryType;
import com.wskc.model.User;
import com.wskc.service.ProductLibraryService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:出库</p>
 * @author Mr.Cheng
 * @date 2017年2月5日 下午7:25:00
 */
@Controller
@RequestMapping("library")
public class LibraryController {
	@Autowired
	private ProductLibraryService productLibraryService;
	
	/**
	 * 出库列表视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/LibraryList",method=RequestMethod.GET)
	public String LibraryListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "library/LibraryList";
	}
	/**
	 * 出库列表
	 * @param str
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/LibraryList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj libraryList(@RequestParam("str") String str,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		Pager<ProductLibrary> pps=productLibraryService.findProductLibraryList(user.getId(), str);
		if(pps==null||pps.getTotal()<0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("查询暂无记录");
		}else{
			ajaxObj.setResult(1);
			ajaxObj.setObj(pps);
		}
		return ajaxObj;
	}
	/**
	 * 添加出库信息视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/AddLibrary",method=RequestMethod.GET)
	public String addLibraryView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		model.addAttribute("status", EnumUtils.enum2Map(ProductLibraryStatus.class));
		model.addAttribute("types", EnumUtils.enum2Map(ProductLibraryType.class));
		return "library/AddLibrary";
	}
	/**
	 * 添加出库信息
	 * @param productLibrary
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AddLibrary",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addLibrary(ProductLibrary productLibrary,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		productLibrary.setLibraryUserId(user.getId());
		if(!productLibrary.getRelevanceNo().equals("0")){
			ProductLibrary productLibrary3=productLibraryService.getProductLibraryByRNo(productLibrary.getRelevanceNo());
			if(productLibrary3!=null){
				ajaxObj.setResult(0);
				ajaxObj.setMsg("该关联已经已添加过");
				return ajaxObj;
			}
		}
		ProductLibrary productLibrary2=productLibraryService.addProductLibrary(productLibrary);
		if(productLibrary2!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("添加失败");
		}
		return ajaxObj;
	}
	
	/**
	 * 展示出库信息
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/showLibrary",method=RequestMethod.GET)
	public String showLibrary(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			ProductLibraryDto pld=productLibraryService.getProductLibraryDtoById(id);
			model.addAttribute("pld", pld);
			return "library/ShowLibrary";
		}else{
			return "redirect:LibraryList?menuids="+menuids;
		}
	}
	/**
	 * 编辑出库页面
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/EditLibrary",method=RequestMethod.GET)
	public String editLibraryView(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			ProductLibraryDto pld=productLibraryService.getProductLibraryDtoById(id);
			if(pld.getStatus()!=1){ //如果状态不是待审不能编辑
				return "redirect:showLibrary?id="+pld.getId()+"&menuids="+menuids;
			}
			model.addAttribute("pld", pld);
			model.addAttribute("status", EnumUtils.enum2Map(ProductLibraryStatus.class));
			return "library/EditLibrary";
		}else{
			return "redirect:LibraryList?menuids="+menuids;
		}
	}
	
	/**
	 * 编辑出库
	 * @param purchase
	 * @return
	 */
	@RequestMapping(value="/EditLibrary",method=RequestMethod.POST)
	public @ResponseBody AjaxObj editLibrary(ProductLibrary productLibrary){
		AjaxObj ajaxObj=new AjaxObj();
		if(productLibrary.getId()<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("id不正确");
		}else{
			boolean isSuccess=productLibraryService.EditProductLibrary(productLibrary);
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

}
