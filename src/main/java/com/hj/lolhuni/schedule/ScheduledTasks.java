package com.hj.lolhuni.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hj.lolhuni.model.CurrentGameInfo;
import com.hj.lolhuni.model.Summoner;
import com.hj.lolhuni.service.LoLService;

@Component
public class ScheduledTasks {
	
	 private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	 
	 @Autowired
	 LoLService lolService;
	 
	 /**
	  * 5초마다 실행
	  */
	 @Scheduled(fixedRate = 5000)
	 public void checkCurrentGame() {
		 Summoner summoner = lolService.getSummonerInfo("고릴라피시방");
		 CurrentGameInfo gameInfo = null;
		 
		 if (summoner != null) {
			 gameInfo = lolService.getGameInfo(summoner.getId());
		 }
		 
		 
		 if (summoner == null || gameInfo == null) {
			 logger.debug("### {}님은 현재 게임 중이 아닙니다.",summoner.getName());
		 } else {
			 logger.debug("### {}님은 현재 게임 중입니다.",summoner.getName());
		 }
	 }
}
