package com.wskc.dto;

import java.util.Date;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户产品dto</p>
 * @author Mr.Cheng
 * @date 2017年1月30日 下午3:13:40
 */
public class UserProductDto {
	private int userId; //用户id
	private int stockId;  //库存id
	private int productId; //产品id
	private String productName; //产品名称
	private String code;//产品编号
	private int brandId; //品牌id
	private String brandName; //品牌名称
	private String size; //规格
	private String unit; //单位
	private Date createTime; //用户产品创建时间
	private Date modifyTime;//修改时间
	private Integer num; //数量
	private Integer soleNum;//可售库存
	private Integer warnNum;//警告库存
	private Double totalMoney; //总价格
	private int status;//状态
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public Integer getWarnNum() {
		return warnNum;
	}
	public void setWarnNum(Integer warnNum) {
		this.warnNum = warnNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getCode() {
		return code;
	}
	
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getSoleNum() {
		return soleNum;
	}
	public void setSoleNum(Integer soleNum) {
		this.soleNum = soleNum;
	}
	public UserProductDto() {
		super();
	}
	
	
}














