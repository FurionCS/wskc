package com.wskc.dto;

import java.util.Date;
/**
 * 
 * <p>Title:</p>
 * <p>Description:产品代理详细库存</p>
 * @author Mr.Cheng
 * @date 2017年2月9日 上午9:57:46
 */
public class ProductAgentInfoDto {
	private String productName; //产品名
	private int productId;   //产品id
	private Integer num;     //库存
	private String userNike; //用户昵称
	private Date modifyTime; //库存修改时间
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getUserNike() {
		return userNike;
	}
	public void setUserNike(String userNike) {
		this.userNike = userNike;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	

}
