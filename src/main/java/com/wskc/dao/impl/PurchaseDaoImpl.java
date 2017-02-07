package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.PurchaseDao;
import com.wskc.dto.PurchaseDto;
import com.wskc.model.Purchase;
/**
 * 
 * <p>Title:</p>
 * <p>Description:采购实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:26:38
 */
@Repository("purchaseDao")
public class PurchaseDaoImpl extends BaseDao<Purchase> implements PurchaseDao{

	@Override
	public Pager<Purchase> findPurchaseList(int userId, String str) {
		String hql="from Purchase where userId=? and (purchaseNo like ? or productName like ? or brandName like ?) order by createTime desc";
		return this.find(hql, new Object[]{userId,str+'%',str+'%',str+'%'});
	}

	@Override
	public PurchaseDto getPurchaseDtoById(int id) {
		String sql=" select pci.id,pci.purchase_no as 'purchaseNo',pci.product_name as 'productName',pci.product_id as 'productId',pci.brand_id as 'brandId',pci.brand_name as 'brandName',pci.user_id as 'userId',pci.price as 'price',pci.num as 'num',pci.other_fee as 'otherFee',pci.delivery_fee as 'deliveryFee',pci.create_time as 'createTime',pci.`status` as 'status',pci.remark as 'remark',pi.`code` as 'code',pi.size as 'size',pi.unit as 'unit' from t_purchase_info pci,t_product_info pi where pci.product_id=pi.id and pci.id=?";
		return (PurchaseDto) this.sqlObject(sql, id, PurchaseDto.class, false);
	}

	@Override
	public List<Purchase> getPurchaseList(int userId, String str) {
		//只有状态为审核的情况下才能关联入库单
		String hql="from Purchase where userId=? and status=2 and (purchaseNo like ? or productName like ?)";
		return this.list(hql, new Object[]{userId,str+'%',str+'%'});
	}
}
