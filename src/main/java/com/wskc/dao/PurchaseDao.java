package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.BrandPurchaseChartDto;
import com.wskc.dto.BrandSoleChartDto;
import com.wskc.dto.PurchaseDto;
import com.wskc.dto.ShowTotalDto;
import com.wskc.model.Purchase;
/**
 * 
 * <p>Title:</p>
 * <p>Description:采购接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:22:02
 */
public interface PurchaseDao extends IBaseDao<Purchase>{
	/**
	 * 采购单列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public Pager<Purchase> findPurchaseList(int userId,String str);
	
	/**
	 * 通过id获得采购订单详情
	 * @param id
	 * @return
	 */
	public PurchaseDto getPurchaseDtoById(int id);
	
	/**
	 * 得到用户采购单列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public List<Purchase> getPurchaseList(int userId,String str);
	

	/**
	 * 更新采购订单状态
	 * @param no
	 * @param status
	 */
	public void updatePurchaseStatusByNo(String no,int status);
	/**
	 * 得到本月采购金额
	 * @param userId
	 * @return
	 */
	public ShowTotalDto getTotalPurchaseMoney(int userId);
	/**
	 * 获得品牌今年每月销售情况
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<BrandPurchaseChartDto> listBrandPurchaseChartDto(int brandId,int userId);
	/**
	 * 获得产品名称列表
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<String> listProductName(int brandId,int userId);
	/**
	 * 获得产品月份
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<String> listMonth(int brandId,int userId);

}
