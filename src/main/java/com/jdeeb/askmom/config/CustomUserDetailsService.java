package com.jdeeb.askmom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jdeeb.askmom.db.entities.UserEntity;
import com.jdeeb.askmom.services.UserService;


@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmail(username);
//        System.out.println(userEntity);
        if(userEntity != null && userEntity.getEmail() != null)
        	return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
        else
        	return null;
    }
}
