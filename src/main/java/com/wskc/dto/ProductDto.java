package com.wskc.dto;

/**
 * 
 * <p>Title:</p>
 * <p>Description:产品dto</p>
 * @author Mr.Cheng
 * @date 2017年1月31日 上午10:57:32
 */
public class ProductDto {
	private int id;   
	private String name;  //产品名称
	private String code; //产品编号
	private String size; //产品规格
	private String unit; //产品单位
	private int brandId;// 品牌id 
	private String brandName;//品牌名称
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public ProductDto() {
		super();
	}
	
	
}
