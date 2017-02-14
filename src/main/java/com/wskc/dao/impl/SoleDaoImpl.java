package com.wskc.dao.impl;

import java.util.Date;
import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.cs.basic.util.DateUtils;
import org.springframework.stereotype.Repository;

import com.wskc.dao.SoleDao;
import com.wskc.dto.BrandSoleChartDto;
import com.wskc.dto.ShowTotalDto;
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
		String sql="select sum(si.num) from t_sole_info si where si.sole_user_id=? and si.product_id=? and si.`status` =2";
		return this.getCountSql(sql, new Object[]{userId,productId});
	}

	@Override
	public void updateSoleStatusByNo(String no, int status) {
		String hql="update Sole set status=? where soleNo=?";
		this.updateByHql(hql, new Object[]{status,no});
	}

	@Override
	public ShowTotalDto getSoleTotalMoney(int userId) {
		String sql="select sum(si.fact_price*si.num+si.other_fee+si.delivery_fee) as 'soleTotalMoney' from t_sole_info si where si.sole_user_id=? and create_time>=?";
		return (ShowTotalDto) this.sqlObject(sql, new Object[]{userId,DateUtils.format("YYYY-MM", new Date())}, ShowTotalDto.class, false);
	}

	@Override
	public ShowTotalDto getNet(int userId) {
		String sql="select sum(si.fact_price*si.num+si.other_fee+si.delivery_fee-si.price*si.num) as 'netMoeny' from t_sole_info si where si.sole_user_id=? and create_time>=?";
		return (ShowTotalDto) this.sqlObject(sql, new Object[]{userId,DateUtils.format("YYYY-MM", new Date())}, ShowTotalDto.class, false);
	}

	@Override
	public List<BrandSoleChartDto> listBrandSoleChartDto(int brandId, int userId) {
		String sql="select si.product_id as 'productId', CONCAT(MONTH(si.modify_time),'月') as 'month', sum(si.num) as 'num',sum(si.num*si.fact_price+si.other_fee+si.delivery_fee) as 'totalMoney' from t_sole_info si where  si.sole_user_id=? and si.brand_id=? and si.`status`=4 and si.modify_time>? GROUP BY si.product_id ,MONTH(si.modify_time) ORDER BY si.product_id";
		return this.listBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())}, BrandSoleChartDto.class, false);
	}

	@Override
	public List<String> listProductName(int brandId, int userId) {
		String sql="select CONCAT(pi.`name`,'(',pi.size,',',pi.unit,')')  from t_product_info pi ,(select distinct si.product_id  from t_sole_info si where si.sole_user_id=? and si.brand_id=? and si.`status`=4 and si.modify_time>?) sit where pi.id=sit.product_id  order by pi.id";  		
		return this.getListStringBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())});
	}

	@Override
	public List<String> listMonth(int brandId, int userId) {
		String sql="select DISTINCT CONCAT(MONTH(si.modify_time),'月') as 'month' from t_sole_info si where  si.sole_user_id=? and si.brand_id=? and si.`status`=4 and si.modify_time>? order by si.modify_time";
		return this.getListStringBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())});
	}

	@Override
	public List<BrandSoleChartDto> listBrandSoleNetChartDto(int brandId,
			int userId) {
		String sql="select si.product_id as 'productId', CONCAT(MONTH(si.modify_time),'月') as 'month', sum(si.num) as 'num',sum(si.num*(si.fact_price-si.price)+si.other_fee+si.delivery_fee) as 'totalMoney' from t_sole_info si where  si.sole_user_id=? and si.brand_id=? and si.`status`=4 and si.modify_time>? GROUP BY si.product_id ,MONTH(si.modify_time) ORDER BY si.product_id";
		return this.listBySql(sql, new Object[]{userId,brandId,DateUtils.format("YYYY", new Date())}, BrandSoleChartDto.class, false);
	}
	
	
}
