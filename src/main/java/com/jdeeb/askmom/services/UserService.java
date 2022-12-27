package com.jdeeb.askmom.services;

import java.util.List;

import com.jdeeb.askmom.db.entities.UserEntity;
import com.jdeeb.askmom.rest.models.beans.LoginBean;
import com.jdeeb.askmom.rest.models.beans.UserBean;

public interface UserService {

//	UserEntity getUserById(long id);
	UserEntity findByEmail(String email);
	UserBean saveUser(LoginBean bean);
	UserBean findByLoginAndPassword(String email, String password);
	
	UserBean getUserProfile(String token);
	UserBean getUserByID(long id);
	
	UserBean editUserImage(UserBean bean);
	List<UserBean> getAllUsers();
}
