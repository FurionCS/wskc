package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.UserProductDto;
import com.wskc.model.UserProductStock;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户产品库存接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:23:37
 */
public interface UserProductStockDao extends IBaseDao<UserProductStock>{
	/**
	 * 通过品牌获得用户该品牌下的产品
	 * @param brandId
	 * @return
	 */
	public List<UserProductStock> getUserProductStockByBrandId(int userId,int brandId);
	
	/**
	 * 分页获得用户产品信息
	 * @param pager
	 * @return
	 */
	public Pager<UserProductDto> findUserProductStock(int userId,int brandId);
	
	/**
	 * 得到用户产品数量
	 * @param userId
	 * @param brandId
	 * @return
	 */
	public Integer getUserProductNum(int userId,int brandId);
	
	/**
	 * 得到用户产品信息
	 * @param stockId
	 * @return
	 */
	public UserProductDto showUserProductStock(int stockId);
	
	/**
	 * 更改用户产品状态
	 * @param stockId
	 * @param status
	 */
	public void updateUserProductStatus(int stockId,int status);
	
	/**
	 * 搜索用户产品通过用户id,品牌ids,搜索关键字
	 * @return
	 */
	public List<UserProductDto> getUserProductByq(int userId,String str);
	
	/**
	 * 更新用户产品库存
	 * @param userId
	 * @param productId
	 * @param num
	 * @param totalMoney
	 */
	public void updateUserProductStock(int userId, int productId,int num,double totalMoney);
	
	/**
	 * 分页获得用户产品信息
	 * @param pager
	 * @return
	 */
	public Pager<UserProductDto> findUserProductStockForSerach(int userId,String str);
	/**
	 * 获得用户产品库存
	 * @param userId
	 * @param productId
	 * @return
	 */
	public UserProductStock getUserProductStock(int userId,int productId);
}
