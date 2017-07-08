package com.hj.lolhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.lolhuni.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

	User findByTel(String tel);
	User findByName(String name);
	
}
