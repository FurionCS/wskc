package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.BrandDao;
import com.wskc.model.Brand;

/**
 * 
 * <p>Title:</p>
 * <p>Description:品牌</p>
 * @author Mr.Cheng
 * @date 2017年1月24日 下午7:19:54
 */
@Repository("brandDao")
public class BrandDaoImpl extends BaseDao<Brand> implements BrandDao {

	@Override
	public Brand getBrandById(int id) {
		String hql="from Brand where id=?";
		return (Brand) this.queryObject(hql,id);
	}

	@Override
	public List<Brand> getBrandSerach(String industryIds,String str) {
		String hql="from Brand where status=1 and industryId in ("+industryIds+") and name like '"+str+"%'";
		return this.list(hql);
	}

}
