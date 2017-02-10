package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.dao.SoleDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.SoleDto;
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

}
