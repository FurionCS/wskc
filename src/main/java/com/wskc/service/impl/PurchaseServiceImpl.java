package com.wskc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.PurchaseDao;
import com.wskc.dto.BrandPurchaseChartDto;
import com.wskc.dto.BrandSoleChartDto;
import com.wskc.dto.PurchaseChartVO;
import com.wskc.dto.PurchaseDto;
import com.wskc.dto.SoleChartVO;
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
		purchaseNo+=1;//特殊编号
		if(purchase.getProductId()>=1000){
			purchaseNo+=purchase.getProductId()%1000;
		}else{
			purchaseNo+=String.format("%03d", purchase.getProductId());
		}
		if(purchase.getBrandId()>=1000){
			purchaseNo+=purchase.getBrandId()%1000;
		}else{
			purchaseNo+=String.format("%03d", purchase.getBrandId());
		}
		purchaseNo+=(int)(Math.random()*90)+10;
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
	@Override
	public boolean editPurchase(Purchase purchase) {
		Purchase purchase2=purchaseDao.load(purchase.getId());
		if(purchase2==null){
			return false;
		}else{
			purchase2.setModifyTime(new Date());
			purchase2.setNum(purchase.getNum());
			purchase2.setPrice(purchase.getPrice());
			purchase2.setOtherFee(purchase.getOtherFee());
			purchase2.setDeliveryFee(purchase.getDeliveryFee());
			purchase2.setStatus(purchase.getStatus());
			purchase2.setRemark(purchase.getRemark());
			purchaseDao.update(purchase2);
			return true;
		}
	}
	@Override
	public List<Purchase> getPurchaseList(int userId, String str) {
		return purchaseDao.getPurchaseList(userId, str);
	}
	@Override
	public PurchaseChartVO getPurchaseChartVO(int userId, int brandId) {
		PurchaseChartVO purchaseChartVO=new PurchaseChartVO();
		List<BrandPurchaseChartDto> lbscd=purchaseDao.listBrandPurchaseChartDto(brandId, userId);
		//获得一共有几个月份
		List<String> lmonth=purchaseDao.listMonth(brandId, userId);
		//获得一共有多少产品
		List<String> lproduct= purchaseDao.listProductName(brandId, userId);
		purchaseChartVO.setMonth(lmonth);
		purchaseChartVO.setProductName(lproduct);
		
		List<List<Integer>> lint=new ArrayList<List<Integer>>();
		List<List<Double>> ldouble=new ArrayList<List<Double>>();
		List<Integer> lnum=new ArrayList<Integer>();
		List<Double> ltotal=new ArrayList<Double>();
		boolean ischange=false;
		int j=0;
		for(int i=0;i<lbscd.size();i++){
				if(ischange){
					if(j<(lmonth.size()-1)){
						while(j==(lmonth.size()-1)){
							lnum.add(null);
							ltotal.add(null);
							j++;
						}
					}
					j=0;
					lint.add(lnum);
					ldouble.add(ltotal);
					lnum=new ArrayList<Integer>();
					ltotal=new ArrayList<Double>();
				}
				if(i<(lbscd.size()-1)){
					//还有两个以上记录，判断两个记录是不是同一个产品
					if(lbscd.get(i).getProductId().equals(lbscd.get(i+1).getProductId())){
						while(!lmonth.get(j).equals(lbscd.get(i).getMonth())){
							lnum.add(null);
							ltotal.add(null);
							j++;
						}
						lnum.add(Integer.valueOf(lbscd.get(i).getNum().toString()));
						ltotal.add(lbscd.get(i).getTotalMoney());
						ischange=false;
						j++;
					}else{
						while(!lmonth.get(j).equals(lbscd.get(i).getMonth())){
							lnum.add(null);
							ltotal.add(null);
							j++;
						}
						lnum.add(Integer.valueOf(lbscd.get(i).getNum().toString()));
						ltotal.add(lbscd.get(i).getTotalMoney());
						ischange=true;
						j++;
					}
				}else{
					if(lmonth.get(j).equals(lbscd.get(i).getMonth())){
						lnum.add(Integer.valueOf(lbscd.get(i).getNum().toString()));
						ltotal.add(lbscd.get(i).getTotalMoney());
						j++;
						while(j<lmonth.size()){
							lnum.add(null);
							ltotal.add(null);
							j++;
						}
					}else{
						while(!lmonth.get(j).equals(lbscd.get(i).getMonth())){
							lnum.add(null);
							ltotal.add(null);
							j++;
						}
						lnum.add(Integer.valueOf(lbscd.get(i).getNum().toString()));
						ltotal.add(lbscd.get(i).getTotalMoney());
						j++;
						while(j<lmonth.size()){
							lnum.add(null);
							ltotal.add(null);
							j++;
						}
					}
					
					lint.add(lnum);
					ischange=true;
					j=0;
					ldouble.add(ltotal);
				}
		}
		purchaseChartVO.setNum(lint);
		purchaseChartVO.setTotalMoney(ldouble);
		return purchaseChartVO;
	}
}
