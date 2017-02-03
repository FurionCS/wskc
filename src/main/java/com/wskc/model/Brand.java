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
	private String industryName;//行业名称
	private String company; //公司
	private Date createTime; //记录创建时间
	private Date leastTime; //修改时间
	private int createrId;//创建者id
	private int status; //状态1正常，0停用，2审核中
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
	@Column(name="industry_name")
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	@Column(name="creater_id")
	public int getCreaterId() {
		return createrId;
	}
	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Brand() {
		super();
	}
	
	

}
