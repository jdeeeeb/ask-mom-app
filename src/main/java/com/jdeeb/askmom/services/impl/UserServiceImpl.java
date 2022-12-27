package com.jdeeb.askmom.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdeeb.askmom.config.jwt.JwtProvider;
import com.jdeeb.askmom.db.entities.UserEntity;
import com.jdeeb.askmom.db.repository.UserRepository;
import com.jdeeb.askmom.rest.models.beans.LoginBean;
import com.jdeeb.askmom.rest.models.beans.UserBean;
import com.jdeeb.askmom.services.UserService;
import com.jdeeb.askmom.utils.AppConstants;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserBean saveUser(LoginBean bean) {
		UserEntity user = new UserEntity();
		user.setEmail(bean.getEmail());
		user.setFullName(bean.getFullName());
		user.setUserRole(AppConstants.USER_ROLE_USER);
		user.setPassword(passwordEncoder.encode(bean.getPassword()));
		user.setCreatedDate(System.currentTimeMillis());
		user =  userRepository.save(user);
		return  user != null ? user.toBean() : null;
	}

	@Override
	public UserBean findByLoginAndPassword(String email, String password) {
		UserEntity userEntity = findByEmail(email);
		if (userEntity != null) {
			if (passwordEncoder.matches(password, userEntity.getPassword())) {
				return userEntity.toBean();
			}
		}
		return null;
	}
	
	@Override
	public UserBean getUserProfile(String token) {
		String email = jwtProvider.getLoginFromToken(token);
		UserEntity entity = this.findByEmail(email);
		return entity != null ? entity.toBean() : null;
	}

	@Override
	public UserBean getUserByID(long id) {
		UserEntity entity = userRepository.findUserById(id).orElse(null);
		return entity != null ? entity.toBean() : null;
	}

	@Override
	public UserBean editUserImage(UserBean bean) {
		UserEntity entity = userRepository.findById(bean.getId()).orElse(null);
		if(entity != null) {
			entity.setProfileImg(bean.getProfileImg());
			entity = userRepository.save(entity);
			return entity.toBean();
		}else
			return null;
	}

	@Override
	public List<UserBean> getAllUsers() {
		List<UserEntity> entities = userRepository.findAll();
		if(entities != null && entities.size() > 0) {
			List<UserBean> users = new ArrayList<>();
			entities.forEach(entity -> {
				users.add(entity.toBean());
			});
			return users;
		}
		return null;
	}

}
