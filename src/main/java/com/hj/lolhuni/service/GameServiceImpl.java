package com.hj.lolhuni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.repository.GameRepository;

@Service
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
		
		game = gameRepository.save(game);
		return game;
	}
	
	@Override
	public void saveGame(Game game) {
		gameRepository.save(game);
	}
}
