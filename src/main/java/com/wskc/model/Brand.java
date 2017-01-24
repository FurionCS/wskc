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
 * <p>Description:品牌表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午8:11:42
 */
@Entity
@Table(name="t_brand_info")
public class Brand {
	private int id;
	private String name;  //品牌名称
	private int industryId;//行业id
	private String company; //公司
	private Date brandCreateTime;//品牌创建时间
	private Date createTime; //记录创建时间
	private Date leastTime; //修改时间
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
	@Column(name="industry_id")
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name="brand_create_time")
	public Date getBrandCreateTime() {
		return brandCreateTime;
	}
	public void setBrandCreateTime(Date brandCreateTime) {
		this.brandCreateTime = brandCreateTime;
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
	public Brand() {
		super();
	}
	
	

}
