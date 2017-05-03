package com.wskc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.dao.PurchaseDao;
import com.wskc.dao.SoleDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.BrandSoleChartDto;
import com.wskc.dto.ShowTotalDto;
import com.wskc.dto.SoleChartVO;
import com.wskc.dto.SoleDto;
import com.wskc.dto.SoleNetChartVO;
import com.wskc.model.Sole;
import com.wskc.model.UserProductStock;
import com.wskc.service.SoleService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:销售</p>
 * @author Mr.Cheng
 * @date 2017年2月6日 下午7:01:31
 */
@Service(value="SoleSerivce")
public class SoleServiceImpl implements SoleService {
	
	@Autowired
	private SoleDao soleDao;

	@Autowired
	private UserProductStockDao userProductStockDao;
	
	@Autowired
	private ProductAllocationDao productAllocationDao;
	
	@Autowired
	private PurchaseDao purchaseDao;

	@Override
	public Sole addSole(Sole sole) {
		// 先判断下是数量是否已经不够，库存数量-未完成的销售订单数量-当前销售订单数量-已审核的调拨出库单
		UserProductStock userProductStock=userProductStockDao.getUserProductStock(sole.getSoleUserId(), sole.getProductId());
		int solez=soleDao.getUserProudctSoleStratusZ(sole.getSoleUserId(), sole.getProductId());
		int allocationz=productAllocationDao.getAllocationStratusZ(sole.getSoleUserId(), sole.getProductId(), "调出");
		if(userProductStock.getNum()-solez-sole.getNum()-allocationz<0){
			return null;
		}
		sole.setModifyTime(sole.getCreateTime());
		//编号
		String soleNo=DateUtils.stringOfDate(sole.getCreateTime()).replace("-", "");
		soleNo+=5;//特殊编号
		if(sole.getProductId()>=1000){
			soleNo+=sole.getProductId()%1000;
		}else{
			soleNo+=String.format("%03d", sole.getProductId());
		}
		if(sole.getBrandId()>=1000){
			soleNo+=sole.getBrandId()%1000;
		}else{
			soleNo+=String.format("%03d", sole.getBrandId());
		}
		soleNo+=(int)(Math.random()*90)+10;
		sole.setSoleNo(soleNo);
		return soleDao.add(sole);
	}

	@Override
	public Pager<Sole> findSoleList(int userId, String str) {
		return soleDao.findSoleList(userId, str);
	}

	@Override
	public SoleDto getSoleDtoById(int id) {
		return soleDao.getSoleDtoById(id);
	}

	@Override
	public boolean editSole(Sole sole) {
		Sole sole2=soleDao.load(sole.getId());
		// 先判断下是数量是否已经不够，库存数量-已审核的销售订单数量-当前销售订单数量-已审核的调拨出库单
		UserProductStock userProductStock=userProductStockDao.getUserProductStock(sole2.getSoleUserId(), sole2.getProductId());
		int solez=soleDao.getUserProudctSoleStratusZ(sole2.getSoleUserId(), sole2.getProductId());
		int allocationz=productAllocationDao.getAllocationStratusZ(sole2.getSoleUserId(), sole2.getProductId(), "调出");
		if(sole2==null|| userProductStock.getNum()-solez-sole.getNum()-allocationz<0){
			return false;
		}else{
			sole2.setModifyTime(new Date());
			sole2.setNum(sole.getNum());
			sole2.setPrice(sole.getPrice());
			sole2.setOtherFee(sole.getOtherFee());
			sole2.setDeliveryFee(sole.getDeliveryFee());
			sole2.setStatus(sole.getStatus());
			sole2.setRemark(sole.getRemark());
			sole2.setFactPrice(sole.getFactPrice());
			soleDao.update(sole2);
			return true;
		}
	}
	@Override
	public List<Sole> getSoleList(int userId, String str) {
		return soleDao.getSoleList(userId, str);
	}

	@Override
	public ShowTotalDto getShowTotal(int userId) {
		if(userId<1){
			return null;
		}else{
			ShowTotalDto std=new ShowTotalDto();
			ShowTotalDto std1=soleDao.getSoleTotalMoney(userId);
			ShowTotalDto std2=soleDao.getNet(userId);
			ShowTotalDto std3=userProductStockDao.getProductStockTotalMoney(userId);
			ShowTotalDto std4=purchaseDao.getTotalPurchaseMoney(userId);
			if(std1!=null){
				std.setSoleTotalMoney(std1.getSoleTotalMoney());
			}
			if(std2!=null){
				std.setNetMoeny(std2.getNetMoeny());
			}
			if(std3!=null){
				std.setKcTotalMoney(std3.getKcTotalMoney());
			}
			if(std4!=null){
				std.setPurchaseTotalMoeny(std4.getPurchaseTotalMoeny());
			}
			return std;
		}
	}

	@Override
	public SoleChartVO getSoleChartVO(int userId, int brandId) {
		SoleChartVO soleChartVO=new SoleChartVO();
		List<BrandSoleChartDto> lbscd=soleDao.listBrandSoleChartDto(brandId, userId);
		List<String> lmonth=soleDao.listMonth(brandId, userId);
		List<String> lproduct= soleDao.listProductName(brandId, userId);
		soleChartVO.setMonth(lmonth);
		soleChartVO.setProductName(lproduct);
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
		soleChartVO.setNum(lint);
		soleChartVO.setTotalMoney(ldouble);
		return soleChartVO;
	}

	@Override
	public SoleNetChartVO getSoleNetChartVO(int userId, int brandId) {
		SoleNetChartVO soleNetChartVO=new SoleNetChartVO();
		List<BrandSoleChartDto> lbscd=soleDao.listBrandSoleNetChartDto(brandId, userId);
		List<String> lmonth=soleDao.listMonth(brandId, userId);
		List<String> lproduct= soleDao.listProductName(brandId, userId);
		soleNetChartVO.setMonth(lmonth);
		soleNetChartVO.setProductName(lproduct);
		List<List<Double>> ldouble=new ArrayList<List<Double>>();
		List<Double> ltotal=new ArrayList<Double>();
		boolean ischange=false;
		int j=0;
		for(int i=0;i<lbscd.size();i++){
				if(ischange){
					if(j<(lmonth.size()-1)){
						while(j==(lmonth.size()-1)){
							ltotal.add(null);
							j++;
						}
					}
					j=0;
					ldouble.add(ltotal);
					ltotal=new ArrayList<Double>();
				}
				if(i<(lbscd.size()-1)){
					if(lbscd.get(i).getProductId().equals(lbscd.get(i+1).getProductId())){
						while(!lmonth.get(j).equals(lbscd.get(i).getMonth())){
							ltotal.add(null);
							j++;
						}
						ltotal.add(lbscd.get(i).getTotalMoney());
						ischange=false;
						j++;
					}else{
						while(!lmonth.get(j).equals(lbscd.get(i).getMonth())){
							ltotal.add(null);
							j++;
						}
						ltotal.add(lbscd.get(i).getTotalMoney());
						ischange=true;
						j++;
					}
				}else{
					/*ltotal.add(lbscd.get(i).getTotalMoney());
					ldouble.add(ltotal);*/
					
					if(lmonth.get(j).equals(lbscd.get(i).getMonth())){
						ltotal.add(lbscd.get(i).getTotalMoney());
						j++;
						while(j<lmonth.size()){
							ltotal.add(null);
							j++;
						}
					}else{
						while(!lmonth.get(j).equals(lbscd.get(i).getMonth())){
							ltotal.add(null);
							j++;
						}
						ltotal.add(lbscd.get(i).getTotalMoney());
						j++;
						while(j<lmonth.size()){
							ltotal.add(null);
							j++;
						}
					}
					ischange=true;
					j=0;
					ldouble.add(ltotal);
				}
				
		}
		soleNetChartVO.setTotalMoney(ldouble);
		return soleNetChartVO;
	}
}
