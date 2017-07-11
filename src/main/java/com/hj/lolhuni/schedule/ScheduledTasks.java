package com.hj.lolhuni.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.Target;
import com.hj.lolhuni.model.User;
import com.hj.lolhuni.model.data.ChampionInfo;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.CurrentGameInfo;
import com.hj.lolhuni.model.lol.CurrentGameParticipant;
import com.hj.lolhuni.model.lol.GameDto;
import com.hj.lolhuni.model.lol.RecentGamesDto;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.service.ApiKeyService;
import com.hj.lolhuni.service.GameService;
import com.hj.lolhuni.service.LoLService;
import com.hj.lolhuni.service.SummonerService;
import com.hj.lolhuni.service.TargetService;
import com.hj.lolhuni.service.UserService;

@Component
public class ScheduledTasks {
	
	 private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	 
	 @Autowired
	 LoLService lolService;
	 
	 @Autowired
	 ApiKeyService apiKeyService;
	 
	 @Autowired
	 SummonerService summonerService;
	 
	 @Autowired
	 TargetService targetService;
	 
	 @Autowired
	 UserService userService;
	 
	 @Autowired
	 GameService gameService;
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
	 
//	 /**
//	  * 5분마다 게임 체크 (No DB)
//	  */
//	 @Scheduled(fixedRate = 300000)
//	 public void checkCurrentGameMinute() {
//		
//		CurrentGameInfo gameInfo = null;
//		for (CheckList list : CheckList.values()) {
//			 gameInfo = lolService.getGameInfo(list.getId());
//			 if (gameInfo == null) {
//				 logger.debug("### {}님은 현재 게임 중이 아닙니다.", list.name());
//			 } else {
//				
//				 String championName = "";
//				 
//				 for (CurrentGameParticipant participant : gameInfo.getParticipants()) {
//					 if (participant.getSummonerId() == list.getId()) {
//						 String champId = "champ" + participant.getChampionId();
//						 logger.debug("### champId = {}",champId);
//						 ChampionInfo championInfo = ChampionInfo.valueOf(champId);
//						 championName = championInfo.getChampionName();
//					 }
//				 }
//				 logger.debug("### {}님은 현재 {}(으)로 게임 중입니다.",list.name(),championName);
//				 
//				 if (gameInfo.getGameLength() > 0 && gameInfo.getGameLength() < 300) {
//					 for (PhoneNumList numList : PhoneNumList.values()) {
//						 
//						 if (!(numList.name().equals(list.name()))) {
//							 //lolService.sendFbMessage(list.name() + "님은 현재 " + championName + "(으)로 게임 중입니다.", numList.getTel());
//						 }
//					 }
//				 }
//		     }
//		}
//		
//		logger.debug("==============================================");
//	 }
	 
	 /**
	  * 5분마다 게임 체크 (db)
	  */
	 @Scheduled(fixedRate = 60000)
	 public void checkCurrentGame() {
		
		CurrentGameInfo gameInfo = null;
		List<Summoner> summoners = summonerService.summonerList();
		for (Summoner summoner : summoners) {
			
			List<Target> targets = targetService.getTargetsBySummonerId(summoner.getId());
			
			if (targets == null || targets.size() < 1) {
				return;
			}
			
			gameInfo = lolService.getGameInfo(summoner.getId());
			if (gameInfo == null) {
				logger.debug("### {}님은 현재 게임 중이 아닙니다.", summoner.getName());
				
				Game game = gameService.SearchBySummonerAndPlayNotifiactionAndResultNotification(summoner, Notification.PUSH, Notification.PEND);
				
				if (game != null) {
					RecentGamesDto recentGame = lolService.recentGameInfo(summoner.getId());
					
					for (GameDto gameDto : recentGame.getGames()) {
						if (gameDto.getGameId() == game.getGameId()) {
							for (Target target : targets) {
								User user = userService.getUser(target.getUserNo());
								String win = gameDto.getStats().isWin() ? "승리" : "패배";
								if (user != null) {
									lolService.sendFbMessage(summoner.getName() + "님이 " + win + "하셨습니다.", user.getTel());
								}
							}
						}
					}
					game.setResultNotification(Notification.PUSH);
					gameService.saveGame(game);
				}
				
			} else {
				
				Game game = gameService.SearchByGameIdAndSummonerAndPlayNotifiaction(gameInfo.getGameId(),summoner, Notification.PUSH);
				
				if (game == null) {
					String championName = "";
					 
					for (CurrentGameParticipant participant : gameInfo.getParticipants()) {
						if (participant.getSummonerId() == summoner.getId()) {
							String champId = "champ" + participant.getChampionId();
							ChampionInfo championInfo = ChampionInfo.valueOf(champId);
							championName = championInfo.getChampionName();
						}
					}
					 
					logger.debug("### {}님은 현재 {}(으)로 게임 중입니다.",summoner.getName(),championName);
					 
				
					for (Target target : targets) {
						User user = userService.getUser(target.getUserNo());
						if (user != null) {
							lolService.sendFbMessage(summoner.getName() + "님은 현재 " + championName + "(으)로 게임 중입니다.", user.getTel());
						}
								
					}
					
					gameService.saveGame(gameInfo.getGameId(),summoner);
					
				}
			}
		}
		
		logger.debug("==============================================");
	 }
}
