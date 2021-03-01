package com.bakerynara.dto;

//VO : 특정한 비지니스 값을 담는 객체. read only.
//DTO : 레이어간의 통신 용도로 오고가는 객체
public class Member {
		
	//필드 정의
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
	
	//getter와 setter 메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", email=" + email + ", phone=" + phone
				+ ", admin=" + admin + "]";
	}

	


}
