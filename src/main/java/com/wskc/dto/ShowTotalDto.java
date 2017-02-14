package com.wskc.dto;
/**
 * 首页展示
 * <p>Title:</p>
 * <p>Description:</p>
 * @author Mr.Cheng
 * @date 2017年2月11日 下午6:48:58
 */
public class ShowTotalDto {
	private Double kcTotalMoney; //库存总金额
	private Double soleTotalMoney;//本月销售总金额
	private Double purchaseTotalMoeny;//本月采购总金额
	private Double netMoeny;//本月净利润
	public Double getKcTotalMoney() {
		return kcTotalMoney;
	}
	public void setKcTotalMoney(Double kcTotalMoney) {
		this.kcTotalMoney = kcTotalMoney;
	}
	public Double getSoleTotalMoney() {
		return soleTotalMoney;
	}
	public void setSoleTotalMoney(Double soleTotalMoney) {
		this.soleTotalMoney = soleTotalMoney;
	}
	public Double getPurchaseTotalMoeny() {
		return purchaseTotalMoeny;
	}
	public void setPurchaseTotalMoeny(Double purchaseTotalMoeny) {
		this.purchaseTotalMoeny = purchaseTotalMoeny;
	}
	public Double getNetMoeny() {
		return netMoeny;
	}
	public void setNetMoeny(Double netMoeny) {
		this.netMoeny = netMoeny;
	}
	

}
