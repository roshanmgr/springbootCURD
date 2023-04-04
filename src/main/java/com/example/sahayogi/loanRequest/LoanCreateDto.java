package com.example.sahayogi.loanRequest;

public class LoanCreateDto {
	public static final long serailVersionUID= 1L;
	private String user_id;
	private String email;
	private String esewa_username;
	private String esewa_id;
	private String request_amount;
	private String status;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEsewa_username() {
		return esewa_username;
	}
	public void setEsewa_username(String esewa_username) {
		this.esewa_username = esewa_username;
	}
	public String getEsewa_id() {
		return esewa_id;
	}
	public void setEsewa_id(String esewa_id) {
		this.esewa_id = esewa_id;
	}
	public String getRequest_amount() {
		return request_amount;
	}
	public void setRequest_amount(String request_amount) {
		this.request_amount = request_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerailversionuid() {
		return serailVersionUID;
	}

}
