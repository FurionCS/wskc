package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductLibraryDao;
import com.wskc.dto.ProductLibraryDto;
import com.wskc.model.ProductLibrary;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品出库实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:24:34
 */
@Repository("productLibraryDao")
public class ProductLibraryDaoImpl extends BaseDao<ProductLibrary> implements ProductLibraryDao{

	@Override
	public Pager<ProductLibrary> findProductLibraryList(int userId, String str) {
		String hql="from ProductLibrary where libraryUserId=? and (libraryNo like ? or productName like ? or brandName like ?) order by createTime desc";
		return this.find(hql, new Object[]{userId,str+'%',str+'%',str+'%'});
	}

	@Override
	public ProductLibrary getProductLibraryByRNo(String no) {
		String hql="from ProductLibrary where relevanceNo=?";
		return (ProductLibrary) this.queryObject(hql, no);
	}

	@Override
	public ProductLibraryDto getProductLibraryDtoById(int id) {
		String sql="select pl.id,pl.library_no as 'libraryNo',pl.type,pl.brand_name as 'brandName',pl.product_name as 'productName',pl.num,pl.`status`,pl.remark,pl.create_time as 'createTime',pl.modify_time as 'modifyTime',pl.price,pl.relevance_no as 'relevanceNo',pi.code,pi.size,pi.unit from t_product_library pl,t_product_info pi where pl.product_id=pi.id and pl.id=?";
		return (ProductLibraryDto) this.sqlObject(sql, id, ProductLibraryDto.class, false);
	}

}
