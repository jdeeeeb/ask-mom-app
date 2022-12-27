package com.jdeeb.askmom.rest.models.beans;

/**
 * @author JDeeb
 * @Date Jan 31, 2021
 */
public class LoginBean {

	private String fullName;
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "LoginBean [fullName=" + fullName + ", email=" + email + ", password=" + password + "]";
	}
}
