package com.wskc.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.cs.basic.model.Pager;
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
import com.wskc.dto.UserProductDto;
import com.wskc.model.Brand;
import com.wskc.model.IndustryUser;
import com.wskc.model.Product;
import com.wskc.model.User;
import com.wskc.model.UserBrandPUser;
import com.wskc.model.UserProductStock;
import com.wskc.service.BrandService;
import com.wskc.service.IndustryService;
import com.wskc.service.IndustryUserService;
import com.wskc.service.ProductService;
import com.wskc.service.UserBrandPUserService;
import com.wskc.service.UserProductStockService;

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
	
	@Autowired
	private UserProductStockService userProductStockService;
	
	@Autowired
	private ProductService productService;
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
		if(lubp!=null&&lubp.size()>0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("您将要删除的行业下还有品牌,不能删除");
			return ajaxObj;
		}
		industryUserService.deleteIndustryUserByUI(user.getId(), industryId);
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
	
	/**
	 * 删除用户品牌
	 * @param brandId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/deleteUserBrandPUser",method=RequestMethod.POST)
	public @ResponseBody AjaxObj deleteUserBrandPUser(@RequestParam("brandId") Integer brandId,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		// 先判断brandId是否为空
		AjaxObj ajaxObj=new AjaxObj();
		if(brandId==null || brandId<1){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("品牌ID不能为空");
			return ajaxObj;
		}
		boolean isSuccess=userBrandPUserService.deleteUBPU(user.getId(), brandId);
		if(isSuccess){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("删除成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("您品牌下还有产品,不能删除");
		}
		return ajaxObj;
	}
	
	/**
	 * 修改用户品牌页面
	 * @param menuids
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/editUserBrandPUser",method=RequestMethod.GET)
	public String editUserBrandPUser(@RequestParam("menuids") String menuids,@RequestParam("brandId") int brandId,HttpSession session,Model model){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		if(brandId<1){
			return "redirect:brandList";
		}
		// 根据用户id,品牌id获得用户品牌信息
		UserBrandPUser ubpu=userBrandPUserService.getUBPUByUB(user.getId(), brandId);
		model.addAttribute("ubpu", ubpu);
		return "/basic/ModifyBrand";
	}
	
	/**
	 * 修改用户品牌
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/editUserBrandPUser",method=RequestMethod.POST)
	public @ResponseBody AjaxObj editUserBrandPUser(UserBrandPUser ubpu){
		AjaxObj ajaxObj=new AjaxObj();
		boolean isSuccess=userBrandPUserService.updateUBPU(ubpu);
		if(isSuccess){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("更新成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("更新失败");
		}
		return ajaxObj;
	}
	/**
	 * 添加品牌到库
	 * @param menuids
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addBrandToPublic",method=RequestMethod.GET)
	public String addBrandToPublic(@RequestParam("menuids") String menuids,HttpSession session,Model model){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<IndustryUserDto> liud=industryUserService.getIndustryByUserId(user.getId());
		model.addAttribute("liud", liud);
		return "/basic/AddBrandToPublic";
	}
	
	/**
	 * 添加品牌到库
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addBrandToPublic",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addBrandToPublic(Brand brand,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		if(brand==null || brand.getIndustryId()<1|| brand.getCompany().equals("") || brand.getName().equals("")){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("您提交的参数不符合要求");
		}else{
			brand.setCreaterId(user.getId());
			brand.setCreateTime(new Date());
			brand.setLeastTime(new Date());
			brand.setStatus(2);
			int i=brandService.addBrandToPublic(brand);
			if(i==-1){
				ajaxObj.setResult(0);
				ajaxObj.setMsg("您没有该行业请勿添加");
			}else if(i==1){
				ajaxObj.setResult(1);
				ajaxObj.setMsg("成功添加该品牌到库,审核时间为24小时内");
			}
		}		
		return ajaxObj;
	}
	/**
	 * 得到所有产品列表
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/productList",method=RequestMethod.GET)
	public String productView(@RequestParam("menuids") String menuids,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		// 获取用户的所有品牌，
		List<UserBrandPUserDto> lubpud=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpud", lubpud);
		return "/basic/ProductList";
	}
	/**
	 * 得到用户产品分页
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/findUserProduct",method=RequestMethod.POST)
	public @ResponseBody AjaxObj findUserProduct(int brandId,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		// 获得第一页产品 0表示所有品牌
		Pager<UserProductDto> pups=userProductStockService.findUserProductStock(user.getId(), brandId);
		pups.setTotal(userProductStockService.getUserProductNum(user.getId(), brandId));
		ajaxObj.setResult(1);
		ajaxObj.setObj(pups);
		return ajaxObj;
	}
	/**
	 * 得到用户产品详细
	 * @param menuids
	 * @param stockId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showUserProduct",method=RequestMethod.GET)
	public String showUserProduct(@RequestParam("menuids") String menuids,@RequestParam("stockId") int stockId,Model model){
		model.addAttribute("menuids", menuids);
		UserProductDto upd=userProductStockService.showUserProductStock(stockId);
		model.addAttribute("upd", upd);
		return "/basic/ShowUserProduct";
	}
	
	/**
	 * 修改用户产品
	 * @return
	 */
	@RequestMapping(value="/updateUserProductStatus",method=RequestMethod.POST)
	public  @ResponseBody AjaxObj updateUserProductStatus(@RequestParam("stockId") int stockId,@RequestParam("status") int status){
		AjaxObj ajaxObj=new AjaxObj();
		if(stockId>0&&status>-1){
			userProductStockService.updateUserProductStatus(stockId, status);
			ajaxObj.setResult(1);
			ajaxObj.setMsg("修改成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("参数不对");
		}
		return ajaxObj;
	}
	
	
	/**
	 * 添加用户产品
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addUserProduct",method=RequestMethod.GET)
	public String addUserProduct(Model model,HttpSession session,@RequestParam("menuids") String menuids){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
			// 获得当前用户的品牌
		List<UserBrandPUserDto> libpud=userBrandPUserService.getUBPUDAll(user.getId());
		if(libpud!=null&&libpud.size()>0){
			model.addAttribute("libpud", libpud);
			return "/basic/AddUserProduct";
		}else{
			//正常情况下不会跳到这个
			return "redirect:addBrand?menuids=2_2";
		}
	}
	
	/**
	 * 产品搜索
	 * @param model
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/ProductSearch")
	public @ResponseBody AjaxObj getProductSearch(@RequestParam("q") String q,Model model,HttpSession session) throws UnsupportedEncodingException{
		User user=(User) session.getAttribute("loginer");
		q=new String(q.getBytes("iso8859-1"), "utf-8");  
		AjaxObj ajaxObj=new AjaxObj();
		if(StringUtils.isNotEmpty(q)){
			// 获得当前用户的品牌
		List<UserBrandPUserDto> libpud=userBrandPUserService.getUBPUDAll(user.getId());
		String brandIds="";
			for(int i=0;i<libpud.size();i++){
				if(i==0){
					brandIds+=libpud.get(i).getBrandId();
				}else{
					brandIds+=","+libpud.get(i).getBrandId();
				}
			}
			ajaxObj.setObj(productService.getProductSerach(brandIds, q));
		}else{
			ajaxObj.setResult(0);
		}
		return ajaxObj;
	}
	/**
	 * 添加用户产品
	 * @param userProductStock
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="AddUserProduct",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addUserProduct(UserProductStock userProductStock,Model model,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		if(userProductStock.getProductId()<1||userProductStock.getBrandId()<1||userProductStock.getNum()<0||userProductStock.getTotalMoney()<0){
			ajaxObj.setResult(0);
			ajaxObj.setMsg("参数不对");
		}
		userProductStock.setUserId(user.getId());
		UserProductStock ups=userProductStockService.addUserProductStock(userProductStock);
		if(ups!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("添加失败");
		}
		return ajaxObj;
	}
	
	/**
	 * 添加产品页面视图
	 * @param model
	 * @param menuids
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AddProduct",method=RequestMethod.GET)
	public String addProductView(Model model,@RequestParam("menuids") String menuids,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		model.addAttribute("menuids", menuids);
		List<UserBrandPUserDto> lubpd=userBrandPUserService.getUBPUDAll(user.getId());
		model.addAttribute("lubpd", lubpd);
		return "/basic/AddProduct";
	}
	
	/**
	 * 添加产品信息
	 * @param product
	 * @param session
	 * @return
	 */
	@RequestMapping(value="AddProduct",method=RequestMethod.POST)
	public @ResponseBody AjaxObj addProduct(Product product,HttpSession session){
		User user=(User) session.getAttribute("loginer");
		AjaxObj ajaxObj=new AjaxObj();
		product.setCreateUserId(user.getId());
		Product product2=productService.addProduct(product);
		if(product2!=null){
			ajaxObj.setResult(1);
			ajaxObj.setMsg("添加成功");
		}else{
			ajaxObj.setResult(0);
			ajaxObj.setMsg("添加失败");
		}
		return ajaxObj;
	}
}

