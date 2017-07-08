package com.hj.lolhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.lolhuni.model.lol.Summoner;

public interface SummonerRepository extends JpaRepository<Summoner, Long> {
	
	Summoner findByName(String Name);
}
