package com.wskc.dto;

import java.util.List;
/**
 * 
 * <p>Title:</p>
 * <p>Description:</p>
 * @author Mr.Cheng
 * @date 2017年2月13日 下午6:37:30
 */
public class SoleNetChartVO {
	private List<String> productName; //产品名称列表
	private List<List<Double>> totalMoney; //产品销售利润金额列表
	private List<String> month; //产品月份列表
	public List<String> getProductName() {
		return productName;
	}
	public void setProductName(List<String> productName) {
		this.productName = productName;
	}
	
	public List<List<Double>> getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(List<List<Double>> totalMoney) {
		this.totalMoney = totalMoney;
	}

	public List<String> getMonth() {
		return month;
	}
	public void setMonth(List<String> month) {
		this.month = month;
	}

	

}
