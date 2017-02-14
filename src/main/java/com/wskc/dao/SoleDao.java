package com.wskc.dao;

import java.util.List;

import org.cs.basic.dao.IBaseDao;
import org.cs.basic.model.Pager;

import com.wskc.dto.BrandSoleChartDto;
import com.wskc.dto.ShowTotalDto;
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
	
	/**
	 * 获得产品本月销售总金额
	 * @param userId
	 * @return
	 */
	public ShowTotalDto getSoleTotalMoney(int userId);
	/**
	 * 获得本月销售近利润
	 * @param userId
	 * @return
	 */
	public ShowTotalDto getNet(int userId);
	/**
	 * 获得品牌今年每月销售情况
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<BrandSoleChartDto> listBrandSoleChartDto(int brandId,int userId);
	/**
	 * 获得品牌今年每月销售利润情况
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<BrandSoleChartDto> listBrandSoleNetChartDto(int brandId,int userId);
	/**
	 * 获得产品名称列表
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<String> listProductName(int brandId,int userId);
	/**
	 * 获得产品月份
	 * @param brandId
	 * @param userId
	 * @return
	 */
	public List<String> listMonth(int brandId,int userId);
}
