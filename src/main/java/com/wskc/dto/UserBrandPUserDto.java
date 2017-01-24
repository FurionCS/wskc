package com.wskc.dto;

import java.util.Date;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户品牌</p>
 * @author Mr.Cheng
 * @date 2017年1月24日 上午10:51:58
 */
public class UserBrandPUserDto {
	private int id;
	private int userId; //用户id 
	private int brandId;//品牌id
	private Integer puserId;//上家id 
	private String puserRemark;//上家备注
	private String authCode;//授权码
	private Date createTime;//创建时间
	private String brandName; //品牌名称
	private String industryName;//行业名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public Integer getPuserId() {
		return puserId;
	}
	public void setPuserId(Integer puserId) {
		this.puserId = puserId;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getPuserRemark() {
		return puserRemark;
	}
	public void setPuserRemark(String puserRemark) {
		this.puserRemark = puserRemark;
	}
	public UserBrandPUserDto() {
		super();
	}

	
	
	

}
