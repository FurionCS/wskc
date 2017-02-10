package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductDao;
import com.wskc.dto.ProductDto;
import com.wskc.model.Product;
import com.wskc.service.ProductService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品</p>
 * @author Mr.Cheng
 * @date 2017年1月30日 下午10:19:01
 */
@Service("productSerivce")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getProductSerach(String brandIds, String str) {
		return productDao.getProductSearch(brandIds, str);
	}
	@Override
	public Product addProduct(Product product) {
		product.setCreateTime(new Date());
		product.setLeastTime(new Date());
		return productDao.add(product);
	}
	@Override
	public ProductDto getProductDto(int id) {
		if(id>0){
			return productDao.getProductDto(id);
		}else{
			return null;
		}
	}

}
