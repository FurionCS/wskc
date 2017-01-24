package com.wskc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品调拨单</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午9:16:06
 */
@Entity
@Table(name="t_product_allocation")
public class ProductAllocation {
	private int id;
	private String allocationNo; //调拨单编号
	private int allocationUserId; //调拨人
	private String allocationTo;//调给人
	private int brandId; //品牌id 
	private String brandName;//品牌名称
	private int productId;//产品id 
	private String productName;//产品名称
	private int num;//数量
	private double counterFee;//手续费
	private int status;//状态
	private Date createTime;//创建时间
	private Date modifyTime;//修改时间
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="allocation_no")
	public String getAllocationNo() {
		return allocationNo;
	}
	public void setAllocationNo(String allocationNo) {
		this.allocationNo = allocationNo;
	}
	@Column(name="allocation_user_id")
	public int getAllocationUserId() {
		return allocationUserId;
	}
	public void setAllocationUserId(int allocationUserId) {
		this.allocationUserId = allocationUserId;
	}
	@Column(name="allocation_to")
	public String getAllocationTo() {
		return allocationTo;
	}
	public void setAllocationTo(String allocationTo) {
		this.allocationTo = allocationTo;
	}
	@Column(name="brand_id")
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	@Column(name="brand_name")
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Column(name="product_id")
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Column(name="product_name")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Column(name="counter_fee")
	public double getCounterFee() {
		return counterFee;
	}
	public void setCounterFee(double counterFee) {
		this.counterFee = counterFee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="modify_time")
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public ProductAllocation() {
		super();
	}

	
}
