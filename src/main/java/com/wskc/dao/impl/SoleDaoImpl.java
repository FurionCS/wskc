package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.SoleDao;
import com.wskc.dto.SoleDto;
import com.wskc.model.Sole;
/**
 * 
 * <p>Title:</p>
 * <p>Description:销售实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:28:05
 */
@Repository("soleDao")
public class SoleDaoImpl extends BaseDao<Sole> implements SoleDao{

	@Override
	public Pager<Sole> findSoleList(int userId, String str) {
		String hql="from Sole where soleUserId=? and(soleNo like ? or brandName like ? or productName like ?) order by createTime desc";
		return this.find(hql, new Object[]{userId,str+'%',str+'%',str+'%'});
	}

	@Override
	public SoleDto getSoleDtoById(int id) {
		String sql="select si.id,si.sole_no as 'soleNo',si.brand_name as 'brandName',si.product_name as 'productName',si.num,si.price,si.other_fee as 'otherFee',si.delivery_fee as 'deliveryFee',si.fact_price as 'factPrice',si.`status`,si.create_time as 'createTime',si.type,si.remark,si.modify_time as 'modifyTime',pi.unit,pi.size,pi.`code` from t_sole_info si,t_product_info pi where si.product_id=pi.id and si.id=?";
		return (SoleDto) this.sqlObject(sql, id, SoleDto.class, false);
	}

	@Override
	public List<Sole> getSoleList(int userId, String str) {
		//只有状态为审核的才能用于关联出库单
		String hql="from Sole where soleUserId=? and status=2 and (soleNo like ? or productName like ?)";
		return this.list(hql, new Object[]{userId,str+'%',str+'%'});
	}

	@Override
	public Integer getUserProudctSoleStratusZ(int userId, int productId) {
		String sql="select sum(si.num) from t_sole_info si where si.sole_user_id=? and si.product_id=? and si.`status`=1";
		return this.getCountSql(sql, new Object[]{userId,productId});
	}
}
