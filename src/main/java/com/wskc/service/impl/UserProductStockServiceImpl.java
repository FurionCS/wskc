package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.cs.basic.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.ProductDto;
import com.wskc.dto.UserProductDto;
import com.wskc.model.UserProductStock;
import com.wskc.service.UserProductStockService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户产品库存</p>
 * @author Mr.Cheng
 * @date 2017年1月30日 下午2:46:31
 */
@Service("userProductStockSerice")
public class UserProductStockServiceImpl implements UserProductStockService {
	
	@Autowired
	private UserProductStockDao userProductStockDao;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Pager<UserProductDto> findUserProductStock(
			int userId, int brandId) {
		return userProductStockDao.findUserProductStock(userId, brandId);
	}

	@Override
	public Integer getUserProductNum(int userId, int brandId) {
		return userProductStockDao.getUserProductNum(userId, brandId);
	}

	@Override
	public UserProductDto showUserProductStock(int stockId) {
		return userProductStockDao.showUserProductStock(stockId);
	}

	@Override
	public void updateUserProductStatus(int stockId, int status) {
		if(status==0){  //如果原来是停用
			status=1;   //修改为启用
		}else{
			status=0;
		}
		 userProductStockDao.updateUserProductStatus(stockId, status);
	}

	@Override
	public UserProductStock addUserProductStock(
			UserProductStock userProductStock) {
		userProductStock.setStatus(1);
		userProductStock.setCreateTime(new Date());
		userProductStock.setModifyTime(new Date());
		ProductDto productDto=productDao.getProductDto(userProductStock.getProductId());
		userProductStock.setBrandId(productDto.getBrandId());
		userProductStock.setBrandName(productDto.getBrandName());
		userProductStock.setProductName(productDto.getName() );
		return userProductStockDao.add(userProductStock);
	}

	@Override
	public List<UserProductDto> getUserProductByq(int userId,
			 String str) {
		return userProductStockDao.getUserProductByq(userId, str);
	}

}
