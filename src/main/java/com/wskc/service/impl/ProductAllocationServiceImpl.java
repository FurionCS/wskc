package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.dto.ProductAllocationDto;
import com.wskc.model.ProductAllocation;
import com.wskc.model.ProductStorage;
import com.wskc.service.ProductAllocationService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品调拨serivce</p>
 * @author Mr.Cheng
 * @date 2017年2月5日 下午12:40:04
 */
@Service("productAllocaitonService")
public class ProductAllocationServiceImpl implements ProductAllocationService {

	@Autowired
	private ProductAllocationDao productAllocationDao;
	@Override
	public ProductAllocation addProductAllocaiton(
			ProductAllocation productAllocation) {
		productAllocation.setModifyTime(productAllocation.getCreateTime());
		String allocationNo=DateUtils.stringOfDate(productAllocation.getCreateTime()).replace("-", "");
		allocationNo+=3; //特殊编号
		if(productAllocation.getProductId()>=1000){
			allocationNo+=productAllocation.getProductId()%1000;
		}else{
			allocationNo+=String.format("%03d", productAllocation.getProductId());
		}
		if(productAllocation.getBrandId()>=1000){
			allocationNo+=productAllocation.getBrandId()%1000;
		}else{
			allocationNo+=String.format("%03d", productAllocation.getBrandId());
		}
		allocationNo+=(int)(Math.random()*90)+10;
		productAllocation.setAllocationNo(allocationNo);
		return productAllocationDao.add(productAllocation);
	}

	@Override
	public Pager<ProductAllocation> findProductAllocation(int userId, String str) {
		return productAllocationDao.findProductAllocation(userId, str);
	}

	@Override
	public ProductAllocationDto getProductAllocationDtoById(int id) {
		return productAllocationDao.getProductAllocationDtoById(id);
	}

	@Override
	public boolean EditProductAllocation(ProductAllocation productAllocation) {
		ProductAllocation productAllocation2=productAllocationDao.load(productAllocation.getId());
		if(productAllocation2==null){
			return false;
		}else{
			productAllocation2.setNum(productAllocation.getNum());
			productAllocation2.setCounterFee(productAllocation.getCounterFee());
			productAllocation2.setModifyTime(new Date());
			productAllocation2.setRemark(productAllocation.getRemark());
			productAllocation2.setStatus(productAllocation.getStatus());
			productAllocationDao.update(productAllocation2);
			return true;
		}
	}

	@Override
	public List<ProductAllocation> getProductAllocation(int userId, String str,String type) {
		return productAllocationDao.getProductAllocation(userId, str,type);
	}
}
