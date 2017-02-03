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
 * <p>Description:销售表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午9:04:33
 */
@Entity
@Table(name="t_sole_info")
public class Sole {
	private int id;
	private int soleUserId; //销售人id
	private String soleNo; //销售编号
	private String type; //销售类型
	private int brandId; //品牌id 
	private String brandName;//品牌名称
	private int productId;//产品id 
	private String productName;//产品名称
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
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="sole_user_id")
	public int getSoleUserId() {
		return soleUserId;
	}
	public void setSoleUserId(int soleUserId) {
		this.soleUserId = soleUserId;
	}
	@Column(name="sole_no")
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name="fact_price")
	public double getFactPrice() {
		return factPrice;
	}
	public void setFactPrice(double factPrice) {
		this.factPrice = factPrice;
	}

	@Column(name="total_money")
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Column(name="create_time")
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
	@Column(name="modify_time")
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
	@Column(name="delivery_fee")
	public double getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	@Column(name="other_fee")
	public double getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}
	public Sole() {
		super();
	}
	
	
}
