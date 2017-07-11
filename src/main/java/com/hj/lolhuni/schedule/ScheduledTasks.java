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
	  * 1분마다 게임 체크 (db)
	  */
	 @Scheduled(fixedRate = 60000)
	 public void checkCurrentGame() {
		
		CurrentGameInfo gameInfo = null;
		List<Summoner> summoners = summonerService.summonerList();
		for (Summoner summoner : summoners) {
			
			List<Target> targets = targetService.getTargetsBySummonerId(summoner.getId());
			
			if (targets == null || targets.size() < 1) {
				continue;
			}
			
			gameInfo = lolService.getGameInfo(summoner.getId());
			if (gameInfo == null) {
				logger.debug("### {}님은 현재 게임 중이 아닙니다.", summoner.getName());
				
				List<Game> games = gameService.SearchBySummonerAndPlayNotifiactionAndResultNotification(summoner, Notification.PUSH, Notification.PEND);
				
				if (games != null && games.size() > 0) {
					RecentGamesDto recentGame = lolService.recentGameInfo(summoner.getId());
					for (Game game : games) {
						boolean send = false;
						for (GameDto gameDto : recentGame.getGames()) {
							if (gameDto.getGameId() == game.getGameId()) {
								for (Target target : targets) {
									User user = userService.getUser(target.getUserNo());
									String win = gameDto.getStats().isWin() ? "승리" : "패배";
									String message = summoner.getName() + "님이 " + win + "하셨습니다. ";
									message += "킬 : " + gameDto.getStats().getChampionsKilled()
											+ " 데스 : " + gameDto.getStats().getNumDeaths()
											+ " 어시스트 : " + gameDto.getStats().getAssists();
 									
									if (user != null) {
										
										lolService.sendFbMessage(message, user.getTel());
										send = true;
									}
								}
							}
						}
						if (send) {
							game.setResultNotification(Notification.PUSH);
							gameService.saveGame(game);
						}
					}		
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
	 }
}
