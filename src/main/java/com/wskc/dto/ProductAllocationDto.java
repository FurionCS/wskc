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
 * <p>Description:产品调拨单Dto</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午9:16:06
 */

public class ProductAllocationDto {
	private int id;
	private String allocationNo; //调拨单编号
	private String allocationTo;//调给人
	private String brandName;//品牌名称
	private String code; //产品编号
	private String unit;//单位
	private String size;//产品规格
	private String productName;//产品名称
	private int num;//数量
	private double counterFee;//手续费
	private int status;//状态
	private Date createTime;//创建时间
	private Date modifyTime;//修改时间
	private String type;//类型
	private String remark;//备注
	
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAllocationNo() {
		return allocationNo;
	}



	public void setAllocationNo(String allocationNo) {
		this.allocationNo = allocationNo;
	}




	public String getAllocationTo() {
		return allocationTo;
	}



	public void setAllocationTo(String allocationTo) {
		this.allocationTo = allocationTo;
	}






	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}





	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



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



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public ProductAllocationDto() {
		super();
	}

	
}
