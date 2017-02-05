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
import com.wskc.dto.PurchaseDto;
import com.wskc.model.ProductStorage;
import com.wskc.model.ProductStorageDto;
import com.wskc.model.ProductStorageStatus;
import com.wskc.model.ProductStorageType;
import com.wskc.model.Purchase;
import com.wskc.model.PurchaseStatus;
import com.wskc.model.User;
import com.wskc.service.ProductStorageService;


@Controller
@RequestMapping("storage")
public class StorageController {
	
	@Autowired
	private ProductStorageService productStorageService;
	
	/**
	 * 入库列表视图
	 * @param menuids
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/StorageList",method=RequestMethod.GET)
	public String storageListView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		return "storage/StorageList";
	}
	/**
	 * 入库列表
	 * @param str
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/StorageList",method=RequestMethod.POST)
	public @ResponseBody AjaxObj storageList(@RequestParam("str") String str,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		Pager<ProductStorage> pps=productStorageService.findProductStorageList(user.getId(), str);
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
	 * 添加入库信息视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/AddStorage",method=RequestMethod.GET)
	public String addStorageView(@RequestParam("menuids") String menuids,Model model){
		model.addAttribute("menuids", menuids);
		model.addAttribute("status", EnumUtils.enum2Map(ProductStorageStatus.class));
		model.addAttribute("types", EnumUtils.enum2Map(ProductStorageType.class));
		return "storage/AddStorage";
	}
	/**
	 * 添加入库信息
	 * @param productStorage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AddStorage",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addStorage(ProductStorage productStorage,HttpSession session){
		AjaxObj ajaxObj=new AjaxObj();
		User user=(User) session.getAttribute("loginer");
		productStorage.setUserId(user.getId());
		if(!productStorage.getRelevanceNo().equals("0")){
			ProductStorage productStorage3=productStorageService.getProductStorageByRNo(productStorage.getRelevanceNo());
			if(productStorage3!=null){
				ajaxObj.setResult(0);
				ajaxObj.setMsg("该关联已经已添加过");
				return ajaxObj;
			}
		}
		ProductStorage productStorage2=productStorageService.addProductStorage(productStorage);
		if(productStorage2!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("添加失败");
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
	@RequestMapping(value="/showStorage",method=RequestMethod.GET)
	public String showStorage(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			ProductStorageDto psd=productStorageService.getProductStorageDtoById(id);
			model.addAttribute("psd", psd);
			return "storage/ShowStorage";
		}else{
			return "redirect:StorageList?menuids="+menuids;
		}
	}
	/**
	 * 编辑入库页面
	 * @param id
	 * @param model
	 * @param menuids
	 * @return
	 */
	@RequestMapping(value="/EditStorage",method=RequestMethod.GET)
	public String editPurchaseView(@RequestParam("id") int id,Model model,@RequestParam("menuids") String menuids){
		model.addAttribute("menuids", menuids);
		if(id>0){
			ProductStorageDto psd=productStorageService.getProductStorageDtoById(id);
			if(psd.getStatus()!=1){ //如果状态不是待审不能编辑
				return "redirect:showStorage?id="+psd.getId()+"&menuids="+menuids;
			}
			model.addAttribute("psd", psd);
			model.addAttribute("status", EnumUtils.enum2Map(ProductStorageStatus.class));
			return "storage/EditStorage";
		}else{
			return "redirect:StorageList?menuids="+menuids;
		}
	}
	
	/**
	 * 编辑采购
	 * @param purchase
	 * @return
	 */
	@RequestMapping(value="/EditStorage",method=RequestMethod.POST)
	public @ResponseBody AjaxObj editStorage(ProductStorage productStorage){
		AjaxObj ajaxObj=new AjaxObj();
		if(productStorage.getId()<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("id不正确");
		}else{
			boolean isSuccess=productStorageService.EditProductStorage(productStorage);
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
