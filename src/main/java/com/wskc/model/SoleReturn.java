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
 * <p>Description:销售退货表</p>
 * @author Mr.Cheng
 * @date 2017年1月21日 下午3:17:08
 */
@Entity
@Table(name="t_sole_return")
public class SoleReturn {
	private int id;
	private int userId;   //用户id
	private String returnNo;//退货编号
	private String soleNo; //销售编号
	private int brandId; //品牌id 
	private String brandName;//品牌名称
	private int productId;//产品id 
	private String productName;//产品名称
	private int num;//数量
	private double price;//价格
	private double otherFee;//其他价格
	private double deliveryFee;//快递费
	private Date createTime;//创建时间
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
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="return_no")
	public String getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}
	@Column(name="sole_no")
	public String getSoleNo() {
		return soleNo;
	}
	public void setSoleNo(String soleNo) {
		this.soleNo = soleNo;
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
	@Column(name="other_fee")
	public double getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}
	@Column(name="delivery_fee")
	public double getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public SoleReturn() {
		super();
	}

	
}
