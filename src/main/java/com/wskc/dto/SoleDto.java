package com.wskc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * <p>Title:</p>
 * <p>Description:销售表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午9:04:33
 */
public class SoleDto {
	private int id;
	private String soleNo; //销售编号
	private String type; //销售类型
	private String brandName;//品牌名称
	private String productName;//产品名称
	private String code;//产品编号
	private String size;//规格
	private String unit;//单位
	private int num;//数量
	private double price;//价格
	private double factPrice; //实际价格
	private double totalMoney;//总共金额
	private double deliveryFee; //快递费
	private double otherFee;//其他费用
	private Date createTime;//创建时间
	private int status;//状态
	private Date modifyTime;//修改时间
	private String remark;//备注
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSoleNo() {
		return soleNo;
	}

	public void setSoleNo(String soleNo) {
		this.soleNo = soleNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public double getFactPrice() {
		return factPrice;
	}

	public void setFactPrice(double factPrice) {
		this.factPrice = factPrice;
	}

	public double getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public double getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SoleDto() {
		super();
	}
	
	
}
