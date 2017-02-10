package com.wskc.dto;

import java.util.Date;
/**
 * 警告库存
 * <p>Title:</p>
 * <p>Description:</p>
 * @author Mr.Cheng
 * @date 2017年2月10日 下午5:01:04
 */
public class ProductStockWarnDto {
	private Integer brandId;  //品牌id
	private Integer productId;//产品id
	private String brandName; //品牌名称
	private String productName; //产品名称
	private Integer num;//库存
	private Integer warnNum;//警告值
	private Date modifyTime;//修改时间
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getWarnNum() {
		return warnNum;
	}
	public void setWarnNum(Integer warnNum) {
		this.warnNum = warnNum;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	

}
