package com.wskc.dao.impl;

import java.util.List;

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
		String hql="from ProductAllocation where allocationUserId=? and (allocationNo like ? or allocationTo like ? or productName like ? or brandName like ?) order by createTime desc";
		return this.find(hql, new Object[]{userId,str+'%',str+'%',str+'%',str+'%'});
	}

	@Override
	public ProductAllocationDto getProductAllocationDtoById(int id) {
		String sql="select pa.id,pa.allocation_no as 'allocationNo',pa.allocation_to as 'allocationTo',pa.brand_name as 'brandName',pa.product_name as 'productName',pa.num,pa.counter_fee as 'counterFee',pa.`status`,pa.create_time as 'createTime',pa.modify_time as 'modifyTime',pa.type,pa.remark,pi.`code`,pi.size,pi.unit from t_product_allocation pa,t_product_info pi where pa.product_id=pi.id  and pa.id=?";
		return (ProductAllocationDto) this.sqlObject(sql, id, ProductAllocationDto.class, false);
	}

	@Override
	public List<ProductAllocation> getProductAllocation(int userId, String str,String type) {
		String hql="from ProductAllocation where allocationUserId=? and type=? and status=2 and (allocationNo like ? or productName like ?)";
		return this.list(hql, new Object[]{userId,type,str+'%',str+'%'});
	}

	@Override
	public void updateAllocationStatusByNo(String no, int status) {
		String hql="update ProductAllocation set status=? where allocationNo=?";
		 this.updateByHql(hql, new Object[]{status,no});
	}

	@Override
	public Integer getAllocationStratusZ(int userId, int productId, String type) {
		String sql="select sum(pa.num) from t_product_allocation pa where pa.allocation_user_id=? and pa.product_id=? and pa.type=? and pa.status=2";
		return this.getCountSql(sql, new Object[]{userId,productId,type});
	}
}
