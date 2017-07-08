package com.hj.lolhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.lolhuni.model.ApiKey;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Integer>{
	
	ApiKey findByKeyName(String keyName);
}
