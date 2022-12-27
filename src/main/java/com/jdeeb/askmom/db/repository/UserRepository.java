package com.jdeeb.askmom.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jdeeb.askmom.db.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	public UserEntity findByEmail(@Param(value = "email") String email);
	
	Optional<UserEntity> findUserById(long id);
}
