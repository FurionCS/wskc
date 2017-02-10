package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.SoleDto;
import com.wskc.model.Sole;
/**
 * 
 * <p>Title:</p>
 * <p>Description:销售接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:22:54
 */
public interface SoleDao extends IBaseDao<Sole>{
	/**
	 * 采购单列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public Pager<Sole> findSoleList(int userId,String str);
	
	/**
	 * 通过id获得采购订单详情
	 * @param id
	 * @return
	 */
	public SoleDto getSoleDtoById(int id);
	
	/**
	 * 得到用户采购单列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public List<Sole> getSoleList(int userId,String str);
	/**
	 * 得到用户产品没有审核的数量
	 * @param userId
	 * @param productId
	 * @return
	 */
	public Integer getUserProudctSoleStratusZ(int userId,int productId);
	
	/**
	 * 更新销售订单状态
	 * @param no
	 * @param status
	 */
	public void updateSoleStatusByNo(String no,int status);
}
