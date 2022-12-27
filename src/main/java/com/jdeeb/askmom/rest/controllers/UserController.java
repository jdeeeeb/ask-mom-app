package com.jdeeb.askmom.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdeeb.askmom.rest.models.ResponseModel;
import com.jdeeb.askmom.rest.models.beans.TokenBean;
import com.jdeeb.askmom.rest.models.beans.UserBean;
import com.jdeeb.askmom.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/user/")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@PostMapping("profile")
	public ResponseEntity<ResponseModel> getUserProfile(@RequestBody TokenBean tokenBean) {
		String token = tokenBean.getToken();
		UserBean bean = userService.getUserProfile(token);
//		System.out.println(bean);
		if(bean == null) 
			return ResponseEntity.ok().body(prepareResponse(bean, "User Not Found ", "Can't find your User ", 404));
		else
			return ResponseEntity.ok().body(prepareResponse(bean, null, null, 200));
	}
	
	@GetMapping("get")
	public String getUser() {
		return "hi Admin";
	}
	
	@PostMapping("updateImg")
	public ResponseEntity<ResponseModel> editUserImage(@RequestBody UserBean bean){
		if(bean != null && bean.getId() > 0 && bean.getProfileImg() != null && !bean.getProfileImg().isEmpty()) {
			bean = userService.editUserImage(bean);
			if(bean != null)
				return ResponseEntity.ok().body(prepareResponse(bean, null, null, 200));
			else
				return ResponseEntity.ok().body(prepareResponse(bean, "Error in Saving", "Somthing wrong happened", 400));
		} else
			return ResponseEntity.ok().body(prepareResponse(bean, "User Not Found ", "Can't find your User ", 404));
	}
	@GetMapping("all")
	public ResponseEntity<ResponseModel> getAllUsers(){
		List<UserBean> users = userService.getAllUsers();
		if(users == null) 
			return ResponseEntity.ok().body(prepareResponse(null, "No Data", "No Users Found", 404));
		else
			return ResponseEntity.ok().body(prepareResponse(users, null, null, 200));
	}
	
	@PostMapping("{id}")
	public ResponseEntity<ResponseModel> getUserById(@PathVariable("id") Long id) {
		UserBean user = userService.getUserByID(id);
		if(user != null && user.getId() > 0)
			return ResponseEntity.ok().body(prepareResponse(user, null, null, 200));
		else
			return ResponseEntity.ok().body(prepareResponse(null, "No Data", "No Users Found", 404));
	}
	
}
