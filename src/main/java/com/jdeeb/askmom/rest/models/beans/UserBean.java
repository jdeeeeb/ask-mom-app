package com.jdeeb.askmom.rest.models.beans;


import java.io.Serializable;

public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String email;
	private String fullName;
	private String profileImg;
	private long createdDate;
	private int userRole;
	/*********************************/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", email=" + email + ", fullName=" + fullName + ", profileImg=" + profileImg
				+ ", createdDate=" + createdDate + ", userRole=" + userRole + "]";
	}
	
}
