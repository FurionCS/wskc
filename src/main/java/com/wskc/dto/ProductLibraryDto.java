package com.wskc.dto;

import java.util.Date;
/**
 * 产品
 * <p>Title:</p>
 * <p>Description:产品出库Dto</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午9:24:12
 */
public class ProductLibraryDto {
	private int id;
	private String libraryNo; //出库编号
	private String type; //类型
	private String brandName;//品牌名称
	private String productName; //产品名称
	private String code;//产品编号
	private String unit;//单位
	private String size;//规格
	private int num; //数量
	private double price;//单价
	private int status; //状态
	private String remark;//备注
	private Date createTime;//创建时间
	private Date modifyTime;//修改时间
	private String relevanceNo;//关联
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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


	public String getRelevanceNo() {
		return relevanceNo;
	}


	public void setRelevanceNo(String relevanceNo) {
		this.relevanceNo = relevanceNo;
	}


	public ProductLibraryDto() {
		super();
	}

}
