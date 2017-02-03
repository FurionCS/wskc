package com.wskc.dto;

import java.util.Date;
/**
 * 
 * <p>Title:</p>
 * <p>Description:采购产品Dto</p>
 * @author Mr.Cheng
 * @date 2017年2月3日 下午12:42:31
 */
public class PurchaseDto {
	private int id;
	private String purchaseNo;  //采购表编号
	private String productName; //产品名称
	private int productId; //产品id
	private String code;//产品编号
	private String size; //规格
	private String unit; //单位
	private int brandId;//品牌id
	private String brandName;//品牌名称
	private int userId; //用户id
	private double price; //价格
	private int num; //数量
	private double otherFee;//其他费用
	private double deliveryFee;//快递费用
	private Date createTime; //创建时间
	private Date modifyTime; //修改时间
	private int status; //状态
	private String remark;//备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}
	public double getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public PurchaseDto() {
		super();
	}
}
