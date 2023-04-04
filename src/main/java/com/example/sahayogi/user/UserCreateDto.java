package com.example.sahayogi.user;

public class UserCreateDto {
	public static final long serailVersionUID= 1L;
	private String name;
	private String mobile_no;
	private String address;
//	private String esewa_id;
	private String password;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public String getEsewa_id() {
//		return esewa_id;
//	}
//	public void setEsewa_id(String esewa_id) {
//		this.esewa_id = esewa_id;
//	}
	public static long getSerailversionuid() {
		return serailVersionUID;
	}

}
