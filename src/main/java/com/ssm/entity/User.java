package com.ssm.entity;

/**
 * �û���
 * @author 73551
 *
 */
public class User {

	 private Integer id;//�û�id������
	  private String name;//�û���
	  private String password;//�û�����
	  private String email;//�û�����
	  private String code;//�û���ʶ
	  private Integer status;//�˺�״̬
	  private Integer typeid;//�˺�����
	  
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
