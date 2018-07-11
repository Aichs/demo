package com.ssm.entity;
/**
 * 用户类型类
 * @author 73551
 *
 */
public class UserType {

	private Integer id;//自增列
	private String name;//类型
	//==============================================
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//==============================================
	@Override
	public String toString() {
		return "UserType [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
