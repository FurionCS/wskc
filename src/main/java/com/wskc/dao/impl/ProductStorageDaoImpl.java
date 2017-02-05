package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductStorageDao;
import com.wskc.dto.ProductStorageDto;
import com.wskc.model.ProductStorage;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品入库实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:24:50
 */
@Repository("productStorageDao")
public class ProductStorageDaoImpl extends BaseDao<ProductStorage> implements ProductStorageDao{

	@Override
	public Pager<ProductStorage> findProductStorageList(int userId, String str) {
		String hql="from ProductStorage where userId=? and (storageNo like ? or brandName like ? or productName like ?) order by createTime desc";
		return this.find(hql, new Object[]{userId,str+'%',str+'%',str+'%'});
	}

	@Override
	public ProductStorage getProductStorageByRNo(String no) {
		String hql="from ProductStorage where relevanceNo=?";
		return (ProductStorage) this.queryObject(hql, no);
	}

	@Override
	public ProductStorageDto getProductStorageDtoById(int id) {
		String sql="select ps.id, ps.storage_no as 'storageNo',ps.type ,ps.brand_name as 'brandName',ps.relevance_no as 'relevanceNo',ps.product_name as 'productName',ps.num,ps.price,ps.`status`,ps.remark,ps.create_time as 'createTime',ps.modify_time as 'modifyTime',pi.`code`,pi.unit,pi.size from t_product_storage ps,t_product_info pi where pi.id=ps.product_id and ps.id=?";
		return (ProductStorageDto) this.sqlObject(sql, id, ProductStorageDto.class, false);
	}

}
