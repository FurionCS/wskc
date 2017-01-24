package com.wskc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_resource_info")
public class Resource {
	public static final String ROOT_NAME="网站总资源";
	public static final int ROOT_ID=0;
	private int id;          //资源id
	private String name;     //资源名字
	private String permission;  //许可
	private String url;       //链接
	private ResourceType type; //类型
	private Resource parent;          //父类资源
	private int status;       //是否启用  0：表示启用，1表示停用
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ResourceType getType() {
		return type;
	}
	public void setType(ResourceType type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name="pid")
	public Resource getParent() {
		return parent;
	}
	public void setParent(Resource parent) {
		this.parent = parent;
	}
	public Resource() {
		super();
	}
	public Resource(int id, String name, String permission, String url,
			ResourceType type, Resource parent, int status) {
		super();
		this.id = id;
		this.name = name;
		this.permission = permission;
		this.url = url;
		this.type = type;
		this.parent = parent;
		this.status = status;
	}
	
	
	
	
	
	
	
}
