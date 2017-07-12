package com.hj.lolhuni.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.RawStatsDto;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	
	private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);
	
	@Autowired
	GameRepository gameRepository;
	
	@Override
	public Game SearchByGameIdAndSummonerAndPlayNotifiaction(long gameId, Summoner summoner, Notification notification) {
		
		Game game = null;
		
		try {
			game = gameRepository.findByGameIdAndSummonerAndPlayNotification(gameId,summoner, notification);
		} catch (Exception e) {
			
		}
		
		return game;
	}
	
	@Override
	public List<Game> SearchBySummonerAndPlayNotifiactionAndResultNotification(Summoner summoner, Notification notification,Notification notification2) {
		List<Game> games = null;
		
		try {
			games = gameRepository.findBySummonerAndPlayNotificationAndResultNotification(summoner, notification,notification2);
		} catch (Exception e) {
			
		}
		
		return games;
	}
	
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
	
	@Override
	public void saveGame(Game game) {
		gameRepository.save(game);
	}
	
	/**
	 * stats
	 */
	@Override
	public void getGameStats(RawStatsDto stats) {
		int kill = stats.getChampionsKilled();
		int death = stats.getNumDeaths();
		int assists = stats.getAssists();
		boolean perfect = true;
		double calDeath = death;
		if (calDeath < 1) {
			calDeath = 1;
			perfect = false;
		}
		double average = Double.parseDouble(String.format("%.2f",((double) kill + (double) assists) / calDeath));
		
		logger.debug("### stats [ 킬 = {}, 데스 = {}, 어시 = {}, 평점 = {} ]",kill,death,assists,average);
	}

}
