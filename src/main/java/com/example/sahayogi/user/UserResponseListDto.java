package com.example.sahayogi.user;

import java.util.List;


public class UserResponseListDto {
	private List<UserResponseDto>users;
	private long total;
	public List<UserResponseDto> getUsers() {
		return users;
	}
	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

}
