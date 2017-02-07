package com.wskc.service;

import java.util.List;

import org.cs.basic.model.Pager;

import com.wskc.dto.SoleDto;
import com.wskc.model.Sole;

/**
 * 
 * <p>Title:</p>
 * <p>Description:</p>
 * @author Mr.Cheng
 * @date 2017年2月6日 下午6:54:21
 */
public interface SoleService {
	/**
	 * 添加采购
	 * @param purchase
	 * @return
	 */
	public Sole addSole(Sole sole);
	
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
	 * 编辑采购订单
	 * @param purchase
	 * @return
	 */
	public boolean editSole(Sole sole);
	
	/**
	 * 得到用户采购单列表
	 * @param userId
	 * @param str
	 * @return
	 */
	public List<Sole> getSoleList(int userId,String str);
}
