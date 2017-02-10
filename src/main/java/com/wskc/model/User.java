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
 * <p>Description:用户表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午8:12:43
 */
@Entity
@Table(name="t_user_info")
public class User {
	private int id;
	private String openid;   //微信openid
	private String userName; //用户名
	private String userPassword;//用户密码
	private String userNike;//用户姓名
	private String url;  //头像链接
	private String email;//email
	private String gender; //性别 1:男2:女3:保密
	private String city;//城市
	private int status;//状态
	private Date createTime;//创建时间
	private Date leastTime; //上次登录时间
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="user_password")
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	@Column(name="user_nike")
	public String getUserNike() {
		return userNike;
	}
	public void setUserNike(String userNike) {
		this.userNike = userNike;
	}
	public User() {
		super();
	}
	
	
}
