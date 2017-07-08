package com.hj.lolhuni.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hj.lolhuni.model.data.ChampionInfo;
import com.hj.lolhuni.model.data.CheckList;
import com.hj.lolhuni.model.data.PhoneNumList;
import com.hj.lolhuni.model.lol.CurrentGameInfo;
import com.hj.lolhuni.model.lol.CurrentGameParticipant;
import com.hj.lolhuni.service.LoLService;

@Component
public class ScheduledTasks {
	
	 private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	 
	 @Autowired
	 LoLService lolService;
	 
	 /**
	  * 5분마다 게임 체크
	  */
//	 @Scheduled(fixedRate = 60000)
//	 public void checkCurrentGame() {
//		 Summoner summoner = lolService.getSummonerInfo("고릴라피시방");
//		 CurrentGameInfo gameInfo = null;
//		 
//		 if (summoner != null) {
//			 gameInfo = lolService.getGameInfo(summoner.getId());
//		 }
//		 
//		 if (summoner == null || gameInfo == null) {
//			 logger.debug("### {}님은 현재 게임 중이 아닙니다.",summoner.getName());
//			 
//		 } else {
//			 logger.debug("### {}님은 현재 게임 중입니다.",summoner.getName());
//			 
//			 if (gameInfo.getGameLength() > 0 && gameInfo.getGameLength() < 60) {
//				 lolService.sendFbMessage("고릴라피시방님은 현재 게임 중입니다.", "+82(010)2517-1592");
//				 lolService.sendFbMessage("고릴라피시방님은 현재 게임 중입니다.", "+82(010)4140-8702");
//				 lolService.sendFbMessage("와 유동훈 혼자 겜 쳐하네;;", "+82(010)3632-7381");
//			 }
//		 }
//	 }
	 
	 /**
	  * 1분마다 게임 체크
	  */
	 @Scheduled(fixedRate = 60000)
	 public void checkCurrentGameMinute() {
		
		 CurrentGameInfo gameInfo = null;
		 
		for (CheckList list : CheckList.values()) {
			 gameInfo = lolService.getGameInfo(list.getId());
			 if (gameInfo == null) {
				 logger.debug("### {}님은 현재 게임 중이 아닙니다.", list.name());
			 } else {
				 logger.debug("### {}님은 현재 게임 중입니다.",list.name());
				 
				 if (gameInfo.getGameLength() > 0 && gameInfo.getGameLength() < 60) {
					 
					 String championName = "";
					 
					 for (CurrentGameParticipant participant : gameInfo.getParticipants()) {
						 if (participant.getSummonerId() == list.getId()) {
							 String champId = "champ" + list.getId();
							 ChampionInfo championInfo = new ChampionInfo(champId);
						 }
					 }
					 
					 for (PhoneNumList numList : PhoneNumList.values()) {
						 
						 if (!(numList.name().equals(list.name()))) {
							 lolService.sendFbMessage(list.name() + "님은 현재 게임 중입니다.", numList.getTel());
						 }
					 }
				 }
		     }
		}
		
		logger.debug("==============================================");
	 }
}
