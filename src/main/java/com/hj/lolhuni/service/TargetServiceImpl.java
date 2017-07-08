package com.hj.lolhuni.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.lolhuni.model.Target;
import com.hj.lolhuni.model.TargetPk;
import com.hj.lolhuni.model.User;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.repository.TargetRepository;

@Service
public class TargetServiceImpl implements TargetService{

	private static final Logger logger = LoggerFactory.getLogger(TargetServiceImpl.class);
	
	@Autowired
	SummonerService summonerSerivce;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TargetRepository targetRepository;
	
	@Override
	@Transactional
	public Target registTarget(String name, String summonerName) {
		
		User user = userService.getUser(name);
		Summoner summoner = summonerSerivce.summonerInfo(summonerName);
		
		logger.debug("### user = {}",user);
		logger.debug("### summoner = {}",summoner);
		
		Target target = new Target();
		target.setSummonerId(summoner.getId());
		target.setUserNo(user.getUserNo());
	
		target = targetRepository.save(target);
		
		return target;
	}
	
	@Override
	public List<Target> getTargets() {
		return targetRepository.findAll();
	}
	
	@Override
	public void removeTarget(long summonerId,int userNo) {
		try {
			TargetPk targetPk = new TargetPk();
			targetPk.setSummonerId(summonerId);
			targetPk.setUserNo(userNo);
			targetRepository.delete(targetPk);
		} catch (Exception e) {
			
		}
		
	}
	
	@Override
	public List<Target> getTargetsBySummonerId(long summonerId) {
		List<Target> targets = targetRepository.findBySummonerId(summonerId);
		
		return targets;
	}
}
