package com.hj.lolhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.lolhuni.model.Game;
import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.Summoner;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	Game findByGameIdAndSummonerAndPlayNotification(long gameId, Summoner summoner, Notification notification);
	List<Game> findBySummonerAndPlayNotificationAndResultNotification(Summoner summoner, Notification notification, Notification resultNotification);
}
