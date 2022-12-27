package com.jdeeb.askmom.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdeeb.askmom.config.jwt.JwtProvider;
import com.jdeeb.askmom.db.entities.UserEntity;
import com.jdeeb.askmom.rest.models.ResponseModel;
import com.jdeeb.askmom.rest.models.beans.LoginBean;
import com.jdeeb.askmom.rest.models.beans.TokenBean;
import com.jdeeb.askmom.rest.models.beans.UserBean;
import com.jdeeb.askmom.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/auth/")
public class AuthController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("register")
    public ResponseEntity<ResponseModel> registerUser(@RequestBody LoginBean loginBean) {
        System.out.println(loginBean);
        if(loginBean != null && loginBean.getEmail() != null) {
        	// Check if the email exist before
        	UserEntity entity = userService.findByEmail(loginBean.getEmail());
        	if(entity != null && entity.getId() > 0) {
        		return ResponseEntity.ok().body(prepareResponse(null, "Email Exist", "This Email Already Exist", 300));
        	}else {
        		UserBean userbean = userService.saveUser(loginBean);
                String token = jwtProvider.generateToken(userbean.getEmail());
                TokenBean bean = new TokenBean();
                bean.setToken(token);
                bean.setUserId(userbean.getId());
                
                return ResponseEntity.ok().body(prepareResponse(bean, null, null, 200));
        	}
        }else {
        	return ResponseEntity.ok().body(prepareResponse(null, "Wrong Data", "Wrong Data", 300));
        }
    }

    @PostMapping("login")
    public ResponseEntity<ResponseModel> auth(@RequestBody LoginBean loginBean) {
    	UserBean userbean = userService.findByLoginAndPassword(loginBean.getEmail(), loginBean.getPassword());
        String token = jwtProvider.generateToken(userbean.getEmail());
        
        TokenBean bean = new TokenBean();
        bean.setToken(token);
        bean.setUserId(userbean.getId());
        
        return ResponseEntity.ok().body(prepareResponse(bean, null, null, 200));
    }
    
    @PostMapping("validate")
    public ResponseEntity<ResponseModel> auth(@RequestBody TokenBean tokenBean) {
        String token = tokenBean.getToken();
        if(token != null && !token.isEmpty()) {
        	boolean status = jwtProvider.validateToken(token);
            if(status) {
            	UserBean bean = userService.getUserProfile(token);
//            	System.out.println(bean);
            	return ResponseEntity.ok().body(prepareResponse(bean, null, null, 200));
            }else {
            	return ResponseEntity.ok().body(prepareResponse(null, "Wrong Token", "Wrong Token", 400));
            }
        }else {
        	return ResponseEntity.ok().body(prepareResponse(null, "Wrong Token", "Wrong Token", 400));
        }
    	
    }
}