package com.wskc.service.impl;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.PurchaseDao;
import com.wskc.dto.PurchaseDto;
import com.wskc.model.Purchase;
import com.wskc.service.PurchaseService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:</p>
 * @author Mr.Cheng
 * @date 2017年2月3日 上午10:29:16
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseDao purchaseDao;
	@Override
	public Purchase addPurchase(Purchase purchase) {
		String purchaseNo=DateUtils.stringOfDate(purchase.getCreateTime()).replace("-", "");
		if(purchase.getProductId()>=10000){
			purchaseNo+=purchase.getProductId()%10000;
		}else{
			purchaseNo+=String.format("%04d", purchase.getProductId());
		}
		if(purchase.getBrandId()>=1000){
			purchaseNo+=purchase.getBrandId()%1000;
		}else{
			purchaseNo+=String.format("%03d", purchase.getBrandId());
		}
		purchaseNo+=(int)(Math.random()*100);
		purchase.setPurchaseNo(purchaseNo);
		return purchaseDao.add(purchase);
	}
	@Override
	public Pager<Purchase> findPurchaseList(int userId, String str) {
		return purchaseDao.findPurchaseList(userId, str);
	}
	@Override
	public PurchaseDto getPurchaseDtoById(int id) {
		if(id>0){
			return purchaseDao.getPurchaseDtoById(id);
		}else{
			return null;
		}
	}
}
