package com.wskc.dto;

import java.util.Date;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户所属行业dto</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午2:39:37
 */
public class IndustryUserDto {
	private int industryUserId; //用户行业id
	private int industryId; //行业id
	private int userId; //用户id
	private Date createTime;//创建时间
	private Date modifyTime; //修改时间
	private int modifyNum; //修改次数
	private String industryName;//行业名称
	public int getIndustryUserId() {
		return industryUserId;
	}
	public void setIndustryUserId(int industryUserId) {
		this.industryUserId = industryUserId;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getModifyNum() {
		return modifyNum;
	}
	public void setModifyNum(int modifyNum) {
		this.modifyNum = modifyNum;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public IndustryUserDto(int industryUserId, int industryId, int userId,
			Date createTime, Date modifyTime, int modifyNum, String industryName) {
		super();
		this.industryUserId = industryUserId;
		this.industryId = industryId;
		this.userId = userId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.modifyNum = modifyNum;
		this.industryName = industryName;
	}
	public IndustryUserDto() {
		super();
	}
	
	

}
