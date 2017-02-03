package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductDao;
import com.wskc.dto.ProductDto;
import com.wskc.model.Product;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:24:19
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao{

	@Override
	public List<Product> getProductSearch(String brandIds, String str) {
		String hql="from Product where brandId in ("+brandIds+") and name like '"+str+"%'";
		return this.list(hql);
	}

	@Override
	public ProductDto getProductDto(int id) {
		String sql="select pi.id,pi.name as 'name',pi.`code` as 'code',pi.size as 'size',pi.unit as 'unit',pi.brand_id as 'brandId',bi.`name` as 'brandName' from t_product_info pi,t_brand_info bi where pi.brand_id=bi.id and pi.id=?";
		return (ProductDto) this.sqlObject(sql, id, ProductDto.class, false);
	}

}
