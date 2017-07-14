package com.hj.lolhuni.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hj.lolhuni.model.Champion;
import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.Target;
import com.hj.lolhuni.model.User;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.model.lol.match.CustomTeamStats;
import com.hj.lolhuni.model.lol.match.MatchDto;
import com.hj.lolhuni.model.lol.match.ParticipantDto;
import com.hj.lolhuni.model.lol.match.ParticipantIdentityDto;
import com.hj.lolhuni.model.lol.match.ParticipantStatsDto;
import com.hj.lolhuni.model.lol.spectator.CurrentGameInfo;
import com.hj.lolhuni.model.lol.spectator.CurrentGameParticipant;
import com.hj.lolhuni.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	
	private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	LoLService lolService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ChampionService championService;
	
	@Value("${lolImgUrl}")
	String lolImgUrl;
	/**
	 * 게임 시작 알림 메시지 보낸 여부 확인
	 */
	@Override
	public Game SearchByGameIdAndSummonerAndPlayNotifiaction(long gameId, Summoner summoner, Notification notification) {
		
		Game game = null;
		
		try {
			game = gameRepository.findByGameIdAndSummonerAndPlayNotification(gameId,summoner, notification);
		} catch (Exception e) {
			
		}
		
		return game;
	}
	
	/**
	 * 게임 결과 알림 메시지 보낸 여부 확인
	 */
	@Override
	public List<Game> SearchBySummonerAndPlayNotifiactionAndResultNotification(Summoner summoner, Notification notification,Notification notification2) {
		List<Game> games = null;
		
		try {
			games = gameRepository.findBySummonerAndPlayNotificationAndResultNotification(summoner, notification,notification2);
		} catch (Exception e) {
			
		}
		
		return games;
	}
	
	/**
	 * 저장
	 */
	@Override
	public Game saveGame(long gameId,Summoner summoner) {
		Game game = new Game();
		game.setGameId(gameId);
		game.setPlayNotification(Notification.PUSH);
		game.setSummoner(summoner);
		game.setResultNotification(Notification.PEND);
		game.setRegDate(new Date());
		
		game = gameRepository.save(game);
		return game;
	}
	
	/**
	 * 저장
	 */
	@Override
	public void saveGame(Game game) {
		gameRepository.save(game);
	}
	
	/**
	 * 게임 결과 알림
	 */
	@Override
	public void sendGameResult(Summoner summoner, List<Target> targets) {
		List<Game> games = SearchBySummonerAndPlayNotifiactionAndResultNotification(summoner, Notification.PUSH, Notification.PEND);
		
		if (games != null && games.size() > 0) {
			
			for (Game game : games) {
				MatchDto match = lolService.getMatchInfo(game.getGameId());
				if (match != null) {
					getGameResult(match,summoner,targets,game);
				}
			}		
		}
		
		
	}
	
	/**
	 * 시작 알림
	 */
	@Override
	public void sendGameStart(CurrentGameInfo gameInfo, Summoner summoner, List<Target> targets) {
		String championName = "";
		String championImageUrl = "";
		
		for (CurrentGameParticipant participant : gameInfo.getParticipants()) {
			if (participant.getSummonerId() == summoner.getId()) {
				Champion champion = championService.getChampionInfo((int) participant.getChampionId());
				championName = champion.getName();
				championImageUrl = lolImgUrl + champion.getChampionKey() + "_0.jpg";
			}
		}
		
		logger.debug("### {}님은 현재 {}(으)로 게임 중입니다.",summoner.getName(),championName);
		String title = summoner.getName() + "님은 현재 " + championName + "(으)로 게임 중입니다.";
		for (Target target : targets) {
			User user = userService.getUser(target.getUserNo());
			if (user != null) {
				lolService.sendFbMessageWithTemplate(user.getTel(),championImageUrl,title,"");
			}
					
		}
		
		saveGame(gameInfo.getGameId(),summoner);
	}
	
	
	/**
	 * 결과
	 * @param match
	 * @param summoner
	 */
	public void getGameResult(MatchDto match,Summoner summoner,List<Target> targets,Game game) {
		
		CustomTeamStats team1 = new CustomTeamStats();
		CustomTeamStats team2 = new CustomTeamStats();
		ParticipantDto player = null;
		int participantId = 0;
		boolean send = false;
		String win = "";
		
		for (ParticipantIdentityDto participantIdentity : match.getParticipantIdentities()) {
			if (summoner.getId() == participantIdentity.getPlayer().getSummonerId()) {
				participantId = participantIdentity.getParticipantId();
			}
		}
		
		for (ParticipantDto participant : match.getParticipants()) {
			
			ParticipantStatsDto stats = participant.getStats();
			
			if (participant.getTeamId() == 100) {
				team1.addData(stats.getKills(), stats.getDeaths(), stats.getAssists(), stats.getTrueDamageDealtToChampions());
			} else {
				team2.addData(stats.getKills(), stats.getDeaths(), stats.getAssists(), stats.getTrueDamageDealtToChampions());
			}
			
			if (participant.getParticipantId() == participantId) {
				win = participant.getStats().isWin() ? "승리" : "패배";
				player = participant;
				
			}
			
		}
		
		for (Target target : targets) {
			
			User user = userService.getUser(target.getUserNo());
			
			String message = summoner.getName() + "님이 " + win  + "하셨습니다. (" + player.getStats().getKills() + "/" + player.getStats().getDeaths() + "/" + player.getStats().getAssists() + ")";
			
			if (user != null) {
				lolService.sendFbMessage(message, user.getTel());
				send = true;
			}
			
		}
		
		if (send) {
			game.setResultNotification(Notification.PUSH);
			saveGame(game);
		}
		
		
	}

}
