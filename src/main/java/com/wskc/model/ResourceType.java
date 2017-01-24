package com.wskc.model;

public enum ResourceType {
	UI("UI元素"),FORM("表单"),DATA_FORM("数据表格"),DATA_SEE("数据可视化"),POWER("权限");
	private String name;
	private ResourceType(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
