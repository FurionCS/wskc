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
 * <p>Description:产品表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午8:10:51
 */
@Entity
@Table(name="t_product_info")
public class Product {
	private int id;
	private String name; //产品名称表
	private String code; //产品编号
	private String size; //规格
	private String unit; //单位
	private int brandId; //品牌id
	private Date createTime;//创建时间
	private Date leastTime; //修改时间
	private int createUserId;//创建者
	private int leastUserId;//修改者
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Column(name="brand_id")
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="least_time")
	public Date getLeastTime() {
		return leastTime;
	}
	public void setLeastTime(Date leastTime) {
		this.leastTime = leastTime;
	}
	@Column(name="create_user_id")
	public int getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	@Column(name="least_user_id")
	public int getLeastUserId() {
		return leastUserId;
	}
	public void setLeastUserId(int leastUserId) {
		this.leastUserId = leastUserId;
	}
	public Product() {
		super();
	}
	
}
