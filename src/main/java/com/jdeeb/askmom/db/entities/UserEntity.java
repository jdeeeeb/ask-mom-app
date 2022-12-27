package com.jdeeb.askmom.db.entities;

import java.io.Serializable;

import com.jdeeb.askmom.rest.models.beans.UserBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author JDeeb
 * @Date Jan 10, 2021
 * 
 * This Entity Class used to map Users Table in DB
 */

@Entity
@Table(name = "App_Users")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	private String email;
	private String password;
	private String fullName;
	private String profileImg;
	private long createdDate;
	private int userRole;
	
	public UserBean toBean() {
		UserBean user = new UserBean();
		
		user.setId(id);
		user.setEmail(email);
		user.setFullName(fullName);
		user.setProfileImg(profileImg);
		user.setCreatedDate(createdDate);
		user.setUserRole(userRole);
		
		return user;
	}
	/*****************************/
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
		return "UserEntity [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", profileImg=" + profileImg + ", createdDate=" + createdDate + ", userRole=" + userRole + "]";
	}
}
