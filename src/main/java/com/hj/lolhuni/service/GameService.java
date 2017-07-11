package com.hj.lolhuni.service;

import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.Summoner;

public interface GameService {

	Game SearchByGameIdAndSummonerAndPlayNotifiaction(long gameId, Summoner summoner, Notification notification);
	Game SearchBySummonerAndPlayNotifiactionAndResultNotification(Summoner summoner, Notification notification,Notification notification2);
	Game saveGame(long gameId,Summoner summoner);
	void saveGame(Game game);
}
