package com.wskc.dao.impl;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.dto.ProductAllocationDto;
import com.wskc.model.ProductAllocation;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品调拨实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:23:58
 */
@Repository("productAllocationDao")
public class ProductAllocationDaoImpl extends BaseDao<ProductAllocation> implements ProductAllocationDao{

	@Override
	public Pager<ProductAllocation> findProductAllocation(int userId, String str) {
		String hql="from ProductAllocation where allocationUserId=? and (allocationNo like ? or allocationTo like ? or productName like ? or brandName like ?)";
		return this.find(hql, new Object[]{userId,str+'%',str+'%',str+'%',str+'%'});
	}

	@Override
	public ProductAllocationDto getProductAllocationDtoById(int id) {
		String sql="select pa.id,pa.allocation_no as 'allocationNo',pa.allocation_to as 'allocationTo',pa.brand_name as 'brandName',pa.product_name as 'productName',pa.num,pa.counter_fee as 'counterFee',pa.`status`,pa.create_time as 'createTime',pa.modify_time as 'modifyTime',pa.type,pa.remark,pi.`code`,pi.size,pi.unit from t_product_allocation pa,t_product_info pi where pa.product_id=pi.id  and pa.id=?";
		return (ProductAllocationDto) this.sqlObject(sql, id, ProductAllocationDto.class, false);
	}
}
