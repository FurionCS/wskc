package com.wskc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * <p>Title:</p>
 * <p>Description:行业表</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午8:21:30
 */
@Entity
@Table(name="t_industry_info")
public class Industry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name; //行业名称
	private int userNum; //用户数
	private int brandNum; //品牌数
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
	@Column(name="user_num")
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	@Column(name="brand_num")
	public int getBrandNum() {
		return brandNum;
	}
	public void setBrandNum(int brandNum) {
		this.brandNum = brandNum;
	}
	public Industry() {
		super();
	}
	
}
