package com.wskc.service;

import java.util.List;

import org.cs.basic.model.Pager;

import com.wskc.dto.ProductAgentDto;
import com.wskc.dto.ProductAgentInfoDto;
import com.wskc.dto.ProductAgentTree;
import com.wskc.dto.ProductStockWarnDto;
import com.wskc.dto.UserProductDto;
import com.wskc.model.UserProductStock;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户产品库存</p>
 * @author Mr.Cheng
 * @date 2017年1月30日 下午2:44:58
 */
public interface UserProductStockService {
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
	 * 修改用户产品状态
	 * @param stockId
	 * @param status
	 */
	public void updateUserProductStatus(int stockId,int status);
	
	/**
	 * 添加用户产品库存
	 * @param userProductStock
	 * @return
	 */
	public UserProductStock addUserProductStock(UserProductStock userProductStock);
	/**
	 * 搜索用户产品通过用户id,搜索关键字
	 * @return
	 */
	public List<UserProductDto> getUserProductByq(int userId,String str);
	
	/**
	 * 分页获得用户产品信息为了查询
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
	
	/**
	 * 获得产品代理汇总信息
	 * @param brandId
	 * @param userId
	 * @param productId
	 * @return
	 */
	public List<ProductAgentDto> getProductAgentDto(int brandId,int userId,int productId);
	
	/**
	 * 获得产品代理详细信息
	 * @param brandId
	 * @param userId
	 * @param productId
	 * @return
	 */
	public Pager<ProductAgentInfoDto> findProductAgentInfoDto(int brandId,int userId,int productId);
	
	
	/**
	 * 获得产品代理树
	 * @param brandId
	 * @param userId
	 * @param productId
	 * @return
	 */
	public List<ProductAgentTree> listProductAgentTree(int brandId,int userId,int productId);
	/**
	 * 展示警告库存信息
	 * @param userId
	 * @return
	 */
	public List<ProductStockWarnDto> listProductStockWarn(int userId);
	
	/**
	 * 修改产品库存
	 * @param stockId
	 * @param warnNum
	 * @return
	 */
	boolean updateProductStockWarn(int stockId,int warnNum);
	
}
