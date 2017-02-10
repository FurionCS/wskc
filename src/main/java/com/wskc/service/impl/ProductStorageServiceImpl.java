package com.wskc.service.impl;

import java.util.Date;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.BrandDao;
import com.wskc.dao.ProductAllocationDao;
import com.wskc.dao.ProductStorageDao;
import com.wskc.dao.PurchaseDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.ProductStorageDto;
import com.wskc.model.Brand;
import com.wskc.model.ProductStorage;
import com.wskc.service.ProductStorageService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品入库</p>
 * @author Mr.Cheng
 * @date 2017年2月4日 下午2:34:43
 */
@Service("productStorageService")
public class ProductStorageServiceImpl implements ProductStorageService {

	@Autowired
	private ProductStorageDao productStorageDao;
	
	@Autowired
	private UserProductStockDao userProductStockDao;
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@Autowired
	private ProductAllocationDao productAllocationDao;
	
	@Autowired
	private BrandDao brandDao;
	@Override
	public Pager<ProductStorage> findProductStorageList(int userId, String str) {
		return productStorageDao.findProductStorageList(userId, str);
	}

	@Override
	public ProductStorage addProductStorage(ProductStorage productStorage) {
		productStorage.setModifyTime(productStorage.getCreateTime());
		if(productStorage.getType().equals("其他入库")){
			Brand brand=brandDao.load(productStorage.getBrandId());
			productStorage.setBrandName(brand.getName());
		}
		String storageNo=DateUtils.stringOfDate(productStorage.getCreateTime()).replace("-", "");
		storageNo+=2; //特殊编号
		if(productStorage.getProductId()>=1000){
			storageNo+=productStorage.getProductId()%1000;
		}else{
			storageNo+=String.format("%03d", productStorage.getProductId());
		}
		if(productStorage.getBrandId()>=1000){
			storageNo+=productStorage.getBrandId()%1000;
		}else{
			storageNo+=String.format("%03d", productStorage.getBrandId());
		}
		storageNo+=(int)(Math.random()*90)+10;
		productStorage.setStorageNo(storageNo);
		if(productStorage.getStatus()==2){
			//如果是审核状态，更新用户产品库存信息
			userProductStockDao.updateUserProductStock(productStorage.getUserId(), productStorage.getProductId(), productStorage.getNum(), productStorage.getNum()*productStorage.getPrice());
		}
		//更新关联订单状态
		if(productStorage.getType().equals("采购入库")&&productStorage.getStatus()==1){
			purchaseDao.updatePurchaseStatusByNo(productStorage.getRelevanceNo(), 3);//待入库
		}else if(productStorage.getType().equals("采购入库")&&productStorage.getStatus()==2){
			purchaseDao.updatePurchaseStatusByNo(productStorage.getRelevanceNo(), 4);//完成
		}
		
		//更新关联订单状态
		if(productStorage.getType().equals("调拨入库")&&productStorage.getStatus()==1){
			productAllocationDao.updateAllocationStatusByNo(productStorage.getRelevanceNo(), 3);//待入库
		}else if(productStorage.getType().equals("调拨入库")&&productStorage.getStatus()==2){
			productAllocationDao.updateAllocationStatusByNo(productStorage.getRelevanceNo(), 5);//完成
		}
		return productStorageDao.add(productStorage);
	}

	@Override
	public ProductStorage getProductStorageByRNo(String no) {
		ProductStorage productStorage=productStorageDao.getProductStorageByRNo(no);
		return productStorage;
	}

	@Override
	public ProductStorageDto getProductStorageDtoById(int id) {
		return productStorageDao.getProductStorageDtoById(id);
	}

	@Override
	public boolean EditProductStorage(ProductStorage productStorage) {
		ProductStorage productStorage2=productStorageDao.load(productStorage.getId());
		if(productStorage2==null){
			return false;
		}else{
			productStorage2.setNum(productStorage.getNum());
			productStorage2.setPrice(productStorage.getPrice());
			productStorage2.setRemark(productStorage.getRemark());
			productStorage2.setModifyTime(new Date());
			productStorage2.setStatus(productStorage.getStatus());
			if(productStorage.getStatus()==2){
				//如果是审核状态，更新用户产品库存信息
				userProductStockDao.updateUserProductStock(productStorage2.getUserId(), productStorage2.getProductId(), productStorage.getNum(), productStorage.getNum()*productStorage.getPrice());
			} 
			if(productStorage2.getType().equals("采购入库")&&productStorage.getStatus()==2){
				purchaseDao.updatePurchaseStatusByNo(productStorage2.getRelevanceNo(), 4);//完成
			}
			if(productStorage2.getType().equals("调拨入库")&&productStorage.getStatus()==2){
				productAllocationDao.updateAllocationStatusByNo(productStorage2.getRelevanceNo(), 5);//完成
			}
			productStorageDao.update(productStorage2);
			return true;
		}
	}
}
