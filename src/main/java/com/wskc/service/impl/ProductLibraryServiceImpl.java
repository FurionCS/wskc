package com.wskc.service.impl;

import java.util.Date;

import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.dao.ProductLibraryDao;
import com.wskc.dao.SoleDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.ProductLibraryDto;
import com.wskc.model.ProductLibrary;
import com.wskc.model.ProductStorage;
import com.wskc.service.ProductLibraryService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品出库</p>
 * @author Mr.Cheng
 * @date 2017年2月5日 下午7:20:52
 */
@Service("productLibraryService")
public class ProductLibraryServiceImpl implements ProductLibraryService {
	
	@Autowired
	private ProductLibraryDao productLibraryDao;
	@Autowired
	private UserProductStockDao userProductStockDao;
	
	@Autowired
	private SoleDao soleDao;
	
	@Autowired
	private ProductAllocationDao productAllocationDao;

	@Override
	public Pager<ProductLibrary> findProductLibraryList(int userId, String str) {
		return productLibraryDao.findProductLibraryList(userId, str);
	}

	@Override
	public ProductLibrary addProductLibrary(ProductLibrary productLibrary) {
		productLibrary.setModifyTime(productLibrary.getCreateTime());
		// 生成编码
		String libraryNo=DateUtils.stringOfDate(productLibrary.getCreateTime()).replace("-", "");
		libraryNo+=4; //特殊编号
		if(productLibrary.getProductId()>=1000){
			libraryNo+=productLibrary.getProductId()%1000;
		}else{
			libraryNo+=String.format("%03d", productLibrary.getProductId());
		}
		if(productLibrary.getBrandId()>=1000){
			libraryNo+=productLibrary.getBrandId()%1000;
		}else{
			libraryNo+=String.format("%03d", productLibrary.getBrandId());
		}
		libraryNo+=(int)(Math.random()*90)+10;
		productLibrary.setLibraryNo(libraryNo);
		// 如果状态为审核就要更新库存
		if(productLibrary.getStatus()==2){
			//如果是审核状态，更新用户产品库存信息
			userProductStockDao.updateUserProductStock(productLibrary.getLibraryUserId(), productLibrary.getProductId(),-productLibrary.getNum(), -productLibrary.getNum()*productLibrary.getPrice());
		}
		//更新销售单状态
		if(productLibrary.getType().equals("销售出库")&&productLibrary.getStatus()==1){
			soleDao.updateSoleStatusByNo(productLibrary.getRelevanceNo(), 3);//待出库
		}else if(productLibrary.getType().equals("销售出库")&&productLibrary.getStatus()==2){
			soleDao.updateSoleStatusByNo(productLibrary.getRelevanceNo(), 4);//完成
		}
		//更新调拨单状态
		if(productLibrary.getType().equals("调拨出库")&&productLibrary.getStatus()==1){
			productAllocationDao.updateAllocationStatusByNo(productLibrary.getRelevanceNo(), 4);//待出库
		}else if(productLibrary.getType().equals("调拨出库")&&productLibrary.getStatus()==2){
			productAllocationDao.updateAllocationStatusByNo(productLibrary.getRelevanceNo(), 5);//完成
		}
		return productLibraryDao.add(productLibrary);
	}



	@Override
	public ProductLibraryDto getProductLibraryDtoById(int id) {
		return productLibraryDao.getProductLibraryDtoById(id);
	}

	@Override
	public boolean EditProductLibrary(ProductLibrary productLibrary) {
		ProductLibrary productLibrary2=productLibraryDao.load(productLibrary.getId());
		if(productLibrary2==null){
			return false;
		}else{
			productLibrary2.setNum(productLibrary.getNum());
			productLibrary2.setPrice(productLibrary.getPrice());
			productLibrary2.setRemark(productLibrary.getRemark());
			productLibrary2.setModifyTime(new Date());
			productLibrary2.setStatus(productLibrary.getStatus());
			if(productLibrary.getStatus()==2){
				//如果是审核状态，更新用户产品库存信息
				userProductStockDao.updateUserProductStock(productLibrary2.getLibraryUserId(), productLibrary2.getProductId(),-productLibrary.getNum(), -productLibrary.getNum()*productLibrary.getPrice());
			}
			if(productLibrary2.getType().equals("销售出库")&&productLibrary.getStatus()==2){
				soleDao.updateSoleStatusByNo(productLibrary2.getRelevanceNo(), 4);//完成
			}
			if(productLibrary2.getType().equals("调拨出库")&&productLibrary.getStatus()==2){
				productAllocationDao.updateAllocationStatusByNo(productLibrary2.getRelevanceNo(), 5);//完成
			}
			productLibraryDao.update(productLibrary2);
			return true;
		}
	}

	@Override
	public ProductLibrary getProductLibraryByRNo(String no) {
		return productLibraryDao.getProductLibraryByRNo(no);
	}

}
