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
 * <p>Description:行业用户表</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 上午10:01:32
 */
@Entity
@Table(name="t_industry_user")
public class IndustryUser {
	private int id;
	private int industryId;  //行业id
	private int userId; //用户id 
	private Date createTime;//创建时间
	private Date modifyTime;//修改时间
	private int modifyNum;//修改次数
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="industry_id")
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	@Column(name="modify_num")
	public int getModifyNum() {
		return modifyNum;
	}
	public void setModifyNum(int modifyNum) {
		this.modifyNum = modifyNum;
	}
	

}
