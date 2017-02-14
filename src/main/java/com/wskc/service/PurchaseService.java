package com.wskc.service;

import java.util.List;

import org.cs.basic.model.Pager;

import com.wskc.dto.PurchaseChartVO;
import com.wskc.dto.PurchaseDto;
import com.wskc.dto.SoleChartVO;
import com.wskc.model.Purchase;

/**
 * 
 * <p>Title:</p>
 * <p>Description:采购</p>
 * @author Mr.Cheng
 * @date 2017年2月3日 上午10:28:37
 */
public interface PurchaseService {
	
	/**
	 * 添加采购
	 * @param purchase
	 * @return
	 */
	public Purchase addPurchase(Purchase purchase);
	
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
	 * 编辑采购订单
	 * @param purchase
	 * @return
	 */
	public boolean editPurchase(Purchase purchase);
	
	/**
	 * 得到用户采购单列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public List<Purchase> getPurchaseList(int userId,String str);
	/**
	 * 获得本年每月销采购金额，数量
	 * @param userId
	 * @param brandId
	 * @return
	 */
	public PurchaseChartVO getPurchaseChartVO(int userId,int brandId);
}
