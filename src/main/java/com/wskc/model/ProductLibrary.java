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
 * <p>Description:产品出库表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午8:46:07
 */
@Entity
@Table(name="t_product_library")
public class ProductLibrary {
	private int id;
	private int libraryUserId; //出库人id
	private String libraryNo; //出库编号
	private String type; //类型
	private int brandId; //品牌id
	private String brandName;//品牌名称
	private int productId;//产品id
	private String productName; //产品名称
	private int num; //数量
	private int status; //状态
	private String remark;//备注
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
	@Column(name="library_user_id")
	public int getLibraryUserId() {
		return libraryUserId;
	}
	public void setLibraryUserId(int libraryUserId) {
		this.libraryUserId = libraryUserId;
	}
	@Column(name="library_no")
	public String getLibraryNo() {
		return libraryNo;
	}
	public void setLibraryNo(String libraryNo) {
		this.libraryNo = libraryNo;
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
	public ProductLibrary() {
		super();
	}
	
}
