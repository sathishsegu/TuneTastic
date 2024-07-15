package com.ssktechhub.tunetastic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssktechhub.tunetastic.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByEmail(String email);

	public User findByUsername(String username);

}
