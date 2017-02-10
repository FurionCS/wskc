package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.PurchaseDto;
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

}
