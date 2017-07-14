package com.hj.lolhuni.service;

import com.hj.lolhuni.model.lol.RecentGamesDto;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.model.lol.match.MatchDto;
import com.hj.lolhuni.model.lol.spectator.CurrentGameInfo;

public interface LoLService {
	
	Summoner getSummonerInfo(String summonerName);
	
	CurrentGameInfo getGameInfo(long summonerId);
	
	public void sendFbMessage(String message, String phoneNumber);
	
	RecentGamesDto recentGameInfo(long summonerId);
	
	MatchDto getMatchInfo(long matchId);

}
