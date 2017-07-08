package com.hj.lolhuni.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.repository.SummonerRepository;

@Service
public class SummonerServiceImpl implements SummonerService{
	
	@Autowired
	SummonerRepository summonerRepository;
	
	@Autowired
	LoLService lolService;
	
	@Override
	@Transactional
	public Summoner registSummoner(String summonerName) {
		Summoner summoner = null;
		
		if (checkExistsSummoner(summonerName)) {
			
		} else {
			summoner = lolService.getSummonerInfo(summonerName);
			if (summoner != null)
				summonerRepository.save(summoner);
		}
		
		return summoner;
	}
	
	@Override
	public boolean checkExistsSummoner(String summonerName) {
		
		try {
			Summoner summoner = summonerRepository.findByName(summonerName);
			if (summoner != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	@Override
	public List<Summoner> summonerList() {
		
		return summonerRepository.findAll();
	}
	
	@Override
	public Summoner summonerInfo(String summonerName) {
		
		return summonerRepository.findByName(summonerName);
	}
	
	@Override
	@Transactional
	public void removeSummoner(String summonerName) {
		
		try {
			Summoner summoner = summonerRepository.findByName(summonerName);
			summonerRepository.delete(summoner);
		} catch (Exception e) {
		}
	}
}
