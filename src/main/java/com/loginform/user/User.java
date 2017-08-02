package com.loginform.user;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String Login;
	private Integer Password;
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public Integer getPassword() {
		return Password;
	}
	public void setPassword(Integer password) {
		Password = password;
	}
}
	