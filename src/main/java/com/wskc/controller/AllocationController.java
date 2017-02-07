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
import com.wskc.dto.ProductAllocationDto;
import com.wskc.dto.ProductStorageDto;
import com.wskc.model.ProductAllocation;
import com.wskc.model.ProductAllocationStatus;
import com.wskc.model.ProductStorage;
import com.wskc.model.ProductStorageStatus;
import com.wskc.model.User;
import com.wskc.service.ProductAllocationService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:调拨</p>
 * @author Mr.Cheng
 * @date 2017年2月5日 下午1:07:17
 */
@Controller
@RequestMapping("allocation")
public class AllocationController {

	@Autowired
	private ProductAllocationService productAllocationService;
	
	/**
	 * 调拨单列表视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/AllocationList",method=RequestMethod.GET)
	public String AllocationListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "allocation/AllocationList";
	}
	
	/**
	 * 入库列表
	 * @param str
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AllocationList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj storageList(@RequestParam("str") String str,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		Pager<ProductAllocation> ppa=productAllocationService.findProductAllocation(user.getId(), str);
		if(ppa==null||ppa.getTotal()<0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("查询暂无记录");
		}else{
			ajaxObj.setResult(1);
			ajaxObj.setObj(ppa);
		}
		return ajaxObj;
	}
	/**
	 * 添加调拨单视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/AddAllocation",method=RequestMethod.GET)
	public String addAllocationView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		model.addAttribute("status", EnumUtils.enum2Map(ProductAllocationStatus.class));
		return "allocation/AddAllocation";
	}
	
	/**
	 * 添加视图
	 * @param productAllocation
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AddAllocation",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addAllocation(ProductAllocation productAllocation,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		productAllocation.setAllocationUserId(user.getId());
		ProductAllocation productAllocation2=productAllocationService.addProductAllocaiton(productAllocation);
		if(productAllocation2!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("添加失败");
		}
		return ajaxObj;
	}
	
	
	/**
	 * 展示调拨单
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/showAllocation",method=RequestMethod.GET)
	public String showStorage(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			ProductAllocationDto pad=productAllocationService.getProductAllocationDtoById(id);
			model.addAttribute("pad", pad);
			return "allocation/ShowAllocation";
		}else{
			return "redirect:AllocationList?menuids="+menuids;
		}
	}
	
	/**
	 * 编辑入库页面
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/EditAllocation",method=RequestMethod.GET)
	public String editPurchaseView(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			ProductAllocationDto pad=productAllocationService.getProductAllocationDtoById(id);
			if(pad.getStatus()!=1){ //如果状态不是待审不能编辑
				return "redirect:showAllocation?id="+pad.getId()+"&menuids="+menuids;
			}
			model.addAttribute("pad", pad);
			model.addAttribute("status", EnumUtils.enum2Map(ProductAllocationStatus.class));
			return "allocation/EditAllocation";
		}else{
			return "redirect:AllocationList?menuids="+menuids;
		}
	}
	
	/**
	 * 编辑采购
	 * @param purchase
	 * @return
	 */
	@RequestMapping(value="/EditAllocation",method=RequestMethod.POST)
	public @ResponseBody AjaxObj editStorage(ProductAllocation productAllocation){
		AjaxObj ajaxObj=new AjaxObj();
		if(productAllocation.getId()<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("id不正确");
		}else{
			boolean isSuccess=productAllocationService.EditProductAllocation(productAllocation);
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
	 * 品牌搜索
	 * @param model
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/AllocationSearch")
	public @ResponseBody AjaxObj getAllocationSearch(@RequestParam("q") String q,@RequestParam("type") int type,Model model,HttpSession session) throws UnsupportedEncodingException{
		User user=(User) session.getAttribute("loginer");
		q=new String(q.getBytes("iso8859-1"), "utf-8");  
		AjaxObj ajaxObj=new AjaxObj();
		if(StringUtils.isNotEmpty(q)){
			if(type==1){
				ajaxObj.setObj(productAllocationService.getProductAllocation(user.getId(), q,"调入"));
			}else{
				ajaxObj.setObj(productAllocationService.getProductAllocation(user.getId(), q,"调出"));
			}
			
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
}
