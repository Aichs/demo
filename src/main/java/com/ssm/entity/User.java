package com.ssm.entity;

/**
 * 用户类
 * @author 73551
 *
 */
public class User {

	 private Integer id;//用户id自增列
	  private String name;//用户名
	  private String password;//用户密码
	  private String email;//用户邮箱
	  private String code;//用户标识
	  private Integer status;//账号状态
	  private Integer typeid;//账号类型
	  
	  //====================================================
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	
	//====================================================
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", code=" + code
				+ ", status=" + status + ", typeid=" + typeid + "]";
	}
	  
	  
}
