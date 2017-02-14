package com.wskc.dao.impl;

import java.util.Date;
import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.stereotype.Repository;

import com.wskc.dao.PurchaseDao;
import com.wskc.dto.BrandPurchaseChartDto;
import com.wskc.dto.BrandSoleChartDto;
import com.wskc.dto.PurchaseDto;
import com.wskc.dto.ShowTotalDto;
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

	@Override
	public void updatePurchaseStatusByNo(String no, int status) {
		String hql="update Purchase set status=? where purchaseNo=?";
		this.updateByHql(hql, new Object[]{status,no});
	}

	@Override
	public ShowTotalDto getTotalPurchaseMoney(int userId) {
		String sql="select sum(pi.price*pi.num+pi.other_fee+pi.delivery_fee) as 'purchaseTotalMoeny' from t_purchase_info pi where pi.user_id=? and pi.create_time>=?";
		return (ShowTotalDto) this.sqlObject(sql, new Object[]{userId,DateUtils.format("YYYY-MM", new Date())}, ShowTotalDto.class,false);
	}

	@Override
	public List<BrandPurchaseChartDto> listBrandPurchaseChartDto(int brandId,
			int userId) {
		String sql="select pi.product_id as 'productId', CONCAT(MONTH(pi.modify_time),'月') as 'month', sum(pi.num) as 'num',sum(pi.num*pi.price+pi.other_fee+pi.delivery_fee) as 'totalMoney' from t_purchase_info pi where  pi.user_id=? and pi.brand_id=? and pi.`status`=4 and pi.modify_time>? GROUP BY pi.product_id ,MONTH(pi.modify_time) ORDER BY pi.product_id";
		return this.listBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())}, BrandPurchaseChartDto.class, false);
	}

	@Override
	public List<String> listProductName(int brandId, int userId) {
		String sql="select CONCAT(pi.`name`,'(',pi.size,',',pi.unit,')')  from t_product_info pi ,(select distinct ppi.product_id  from t_purchase_info ppi where ppi.user_id=? and ppi.brand_id=? and ppi.`status`=4 and ppi.modify_time>?) ppit where pi.id=ppit.product_id  order by pi.id";
		return this.getListStringBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())});
	}

	@Override
	public List<String> listMonth(int brandId, int userId) {
		String sql="select DISTINCT CONCAT(MONTH(pi.modify_time),'月') as 'month' from t_purchase_info pi where pi.user_id =? and pi.brand_id=? and pi.`status`=4 and pi.modify_time>? order by pi.modify_time";
		return this.getListStringBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())});
	}
}
