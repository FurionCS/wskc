package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.UserProductDto;
import com.wskc.model.UserProductStock;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户库存实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:30:28
 */
@Repository("userProductStockDao")
public class UserProductStockDaoImpl extends BaseDao<UserProductStock> implements UserProductStockDao{

	@Override
	public List<UserProductStock> getUserProductStockByBrandId(int userId,int brandId) {
		String hql="from UserProductStock where userId=? and brandId=?";
		return this.list(hql, new Object[]{userId,brandId});
	}

	@Override
	public Pager<UserProductDto> findUserProductStock(int userId,int brandId) {
		String sql="";
		if(brandId>0){
			 sql="select ups.id as 'stockId',ups.user_id as 'userId',ups.product_id as 'productId',ups.product_name as 'productName',ups.num as 'num',ups.total_money as 'totalMoney',ups.brand_name as 'brandName',ups.status as 'status',ups.brand_id as 'brandId',ups.create_time as 'createTime',pi.size as 'size',pi.unit as 'unit',pi.code as 'code' from t_user_product_stock ups ,t_product_info pi where ups.product_id=pi.id and ups.user_id=? and ups.brand_id=? order by status";
			 return this.findBySql(sql, new Object[]{userId,brandId}, UserProductDto.class, false);
			 
		}else{
			 sql="select ups.id as 'stockId',ups.user_id as 'userId',ups.product_id as 'productId',ups.product_name as 'productName',ups.num as 'num',ups.total_money as 'totalMoney',ups.brand_name as 'brandName',ups.status as 'status',ups.brand_id as 'brandId',ups.create_time as 'createTime',pi.size as 'size',pi.unit as 'unit',pi.code as 'code' from t_user_product_stock ups ,t_product_info pi where ups.product_id=pi.id and ups.user_id=? order by status";
			 return this.findBySql(sql,userId, UserProductDto.class, false);
		}
	}

	@Override
	public Integer getUserProductNum(int userId, int brandId) {
		if(brandId>0){
			String sql="select count(id) from t_user_product_stock  ups where ups.user_id=? and ups.brand_id=?";
			return this.getCountSql(sql, new Object[]{userId,brandId});
		}else{
			String sql="select count(id) from t_user_product_stock ups where ups.user_id=?";
			return this.getCountSql(sql, userId);
		}
	}

	@Override
	public UserProductDto showUserProductStock(int stockId) {
		String sql="select ups.id as 'stockId',ups.user_id as 'userId',ups.product_id as 'productId',ups.status as 'status',ups.product_name as 'productName',ups.num as 'num',ups.total_money as 'totalMoney',ups.brand_name as 'brandName',ups.brand_id as 'brandId',ups.create_time as 'createTime',pi.size as 'size',pi.unit as 'unit',pi.code as 'code' from t_user_product_stock ups ,t_product_info pi where ups.product_id=pi.id and ups.id=?";
		return (UserProductDto) this.sqlObject(sql, stockId, UserProductDto.class,false);
	}
	@Override
	public void updateUserProductStatus(int stockId, int status) {
		String hql="update UserProductStock set status=? where id=?";
		this.updateByHql(hql, new Object[]{status,stockId});
	}

	@Override
	public List<UserProductDto> getUserProductByq(int userId,String str) {
		String sql="select ups.id as 'stockId',ups.user_id as 'userId',ups.product_id as 'productId',ups.status as 'status',ups.product_name as 'productName',ups.num as 'num',ups.total_money as 'totalMoney',ups.brand_name as 'brandName',ups.brand_id as 'brandId',ups.create_time as 'createTime',pi.size as 'size',pi.unit as 'unit',pi.code as 'code' from t_user_product_stock ups ,t_product_info pi where ups.product_id=pi.id and ups.user_id=? and ups.`status`=1 and ups.product_name like ?";
		return this.listBySql(sql, new Object[]{userId,str+'%'},UserProductDto.class,false);
	}
}
