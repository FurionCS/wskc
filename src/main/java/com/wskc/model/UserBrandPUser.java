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
 * <p>Description:用户品牌上家表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午9:34:16
 */
@Entity
@Table(name="t_user_brand_puser")
public class UserBrandPUser {
	private int id;
	private int userId; //用户id 
	private int brandId;//品牌id
	private Integer puserId;//上家id 
	private String authCode;//授权码
	private Date creatTime;//创建时间
	private String pUserRemark;//上家备注
	private String brankName;//品牌名称
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
	@Column(name="brand_id")
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	@Column(name="puser_id")
	public int getPuserId() {
		return puserId;
	}
	public void setPuserId(Integer puserId) {
		this.puserId = puserId;
	}
	@Column(name="auth_code")
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	@Column(name="create_time")
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	@Column(name="puser_remark")
	public String getpUserRemark() {
		return pUserRemark;
	}
	public void setpUserRemark(String pUserRemark) {
		this.pUserRemark = pUserRemark;
	}
	@Column(name="brand_name")
	public String getBrankName() {
		return brankName;
	}
	public void setBrankName(String brankName) {
		this.brankName = brankName;
	}
	public UserBrandPUser() {
		super();
	}
	
}
