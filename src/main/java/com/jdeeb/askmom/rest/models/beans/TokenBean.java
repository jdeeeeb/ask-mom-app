package com.jdeeb.askmom.rest.models.beans;

public class TokenBean {
	private String token;
	private long userId;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
