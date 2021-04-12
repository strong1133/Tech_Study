package com.sj_study.jwt.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
	private String username;
	private String password;
}
