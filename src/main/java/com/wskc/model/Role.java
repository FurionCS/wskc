package com.wskc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_role_info")
public class Role {
	private int id;
	/**
	 * 角色名称
	 */
	private String name;
	
	/**
	 * 代号
	 */
	private String sn;
	
	/**
	 * 角色代号,枚举类型
	 */
	private RoleType roleType;
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
	@Enumerated(EnumType.STRING)
	@Column(name="role_type")
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Role(int id, String name, RoleType roleType,String sn) {
		super();
		this.id = id;
		this.name = name;
		this.roleType = roleType;
		this.sn=sn;
	}
	public Role() {
		super();
	}
	
}
