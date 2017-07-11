package com.hj.lolhuni.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.repository.GameRepository;

public class GameServiceImpl implements GameService {

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
	public Game saveGame(long gameId,Summoner summoner) {
		Game game = new Game();
		game.setGameId(gameId);
		game.setPlayNotification(Notification.PUSH);
		game.setSummoner(summoner);
		game.setResultNotification(Notification.PEND);
		
		game = gameRepository.save(game);
		return game;
	}
}
