package com.example.sahayogi.user;

import lombok.Data;

@Data

public class LogoutRequestDto {
 private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
