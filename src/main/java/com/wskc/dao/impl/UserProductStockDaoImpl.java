package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.cs.basic.model.Pager;
import org.springframework.stereotype.Repository;

import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.ProductAgentDto;
import com.wskc.dto.ProductAgentInfoDto;
import com.wskc.dto.ProductAgentTree;
import com.wskc.dto.ProductStockWarnDto;
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
		String sql="select ups.id as 'stockId',ups.warn_num as 'warnNum',ups.user_id as 'userId',ups.product_id as 'productId',ups.status as 'status',ups.product_name as 'productName',ups.num as 'num',ups.total_money as 'totalMoney',ups.brand_name as 'brandName',ups.brand_id as 'brandId',ups.create_time as 'createTime',pi.size as 'size',pi.unit as 'unit',pi.code as 'code' from t_user_product_stock ups ,t_product_info pi where ups.product_id=pi.id and ups.id=?";
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

	@Override
	public void updateUserProductStock(int userId, int productId, int num,
			double totalMoney) {
		String hql="";
		hql="update UserProductStock set num=num+?,totalMoney=totalMoney+?,modifyTime=now() where userId=? and productId=?";
		 this.updateByHql(hql, new Object[]{num,totalMoney,userId,productId});
	}

	@Override
	public Pager<UserProductDto> findUserProductStockForSerach(int userId,
			String str) {
		 String sql="select ups.id as 'stockId',ups.user_id as 'userId',ups.product_id as 'productId',ups.product_name as 'productName',ups.num as 'num',ups.total_money as 'totalMoney',ups.brand_name as 'brandName',ups.status as 'status',ups.brand_id as 'brandId',ups.modify_time as 'modifyTime',pi.size as 'size',pi.unit as 'unit',pi.code as 'code' from t_user_product_stock ups ,t_product_info pi where ups.product_id=pi.id and ups.user_id=? and ups.status=1 and (pi.code like ? or ups.product_name like ? or ups.brand_name like ?) order by ups.num,ups.modify_time desc";
		 return this.findBySql(sql,new Object[]{userId,str+'%',str+'%',str+'%'}, UserProductDto.class, false);
	}

	@Override
	public UserProductStock getUserProductStock(int userId, int productId) {
		String hql="from UserProductStock where userId=? and productId=?";
		return (UserProductStock) this.queryObject(hql, new Object[]{userId,productId});
	}

	@Override
	public List<ProductAgentDto> getProductAgentDto(int brandId, int userId,
			int productId) {
		if(productId==-1){
			String sql=" select sum(ups.num) as 'totalNum',min(ups.num) as 'minNum',max(ups.num) as 'maxNum',ups.product_id as 'productId',ups.brand_id as 'brandId',pi.`name` as 'productName',ups.brand_name as 'brandName',pi.`code`,pi.size from t_user_product_stock ups,t_product_info pi where pi.id=ups.product_id and  ups.user_id in (select ubp.user_id from t_user_brand_puser ubp where ubp.puser_id=? and ubp.brand_id=?) and ups.brand_id=?  group by ups.product_id";
			return this.listBySql(sql, new Object[]{userId, brandId, brandId }, ProductAgentDto.class, false);
		}else{
			String sql=" select sum(ups.num) as 'totalNum',min(ups.num) as 'minNum',max(ups.num) as 'maxNum',ups.product_id as 'productId',ups.brand_id as 'brandId',pi.`name` as 'productName',ups.brand_name as 'brandName',pi.`code`,pi.size from t_user_product_stock ups,t_product_info pi where pi.id=ups.product_id and  ups.user_id in (select ubp.user_id from t_user_brand_puser ubp where ubp.puser_id=? and ubp.brand_id=?) and ups.product_id=?";
			return this.listBySql(sql, new Object[]{userId, brandId, productId }, ProductAgentDto.class, false);
		}
	}

	@Override
	public Pager<ProductAgentInfoDto> findProductAgentInfoDto(int brandId,
			int userId, int productId) {
		String sql="select ups.product_id as 'productId' ,ups.product_name as 'productName',ups.num,ups.modify_time as 'modifyTime',ui.user_nike as 'userNike' from t_user_product_stock ups,t_user_info ui where ups.user_id=ui.id  and ups.user_id in (select ubp.user_id from t_user_brand_puser ubp where ubp.puser_id=? and ubp.brand_id=?) and ups.product_id=?";
		return this.findBySql(sql, new Object[]{userId,brandId,productId}, ProductAgentInfoDto.class, false);
	}

	@Override
	public List<ProductAgentTree> listProductAgentTree(int brandId, int userId,
			int productId) {
		String sql="select  ups.num,ui.user_nike as 'name',ups.user_id as 'id',ubp.num as 'agentNum' from t_user_product_stock ups,t_user_info ui,(select ubp.user_id,ubp.num from t_user_brand_puser ubp where ubp.puser_id=? and ubp.brand_id=?) ubp where ups.user_id=ui.id  and ubp.user_id=ups.user_id  and ups.product_id=?";
		return this.listBySql(sql, new Object[]{userId,brandId,productId},ProductAgentTree.class, false);
	}

	@Override
	public List<ProductStockWarnDto> listProductStockWarn(int userId) {
		String sql="select ups.brand_id as 'brandId',ups.product_id as 'productId',ups.brand_name as 'brandName',ups.product_name as 'productName',ups.num,ups.modify_time as 'modifyTime',ups.warn_num as 'warnNum' from t_user_product_stock ups where  ups.user_id=? and ups.`status`=1 and ups.num<=ups.warn_num";
		return this.listBySql(sql, userId, ProductStockWarnDto.class, false);
	}
}
