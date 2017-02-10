package com.wskc.dto;
/**
 * 
 * <p>Title:</p>
 * <p>Description:代理库存查询</p>
 * @author Mr.Cheng
 * @date 2017年2月8日 下午5:48:23
 */
public class AgentKcSerachDto {
	private int brandId;     //品牌id
	private int productId;   //产品id 
	private int userId;      //用户id
	private int maxNum;      //最大库存数量
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	
	
	

}
