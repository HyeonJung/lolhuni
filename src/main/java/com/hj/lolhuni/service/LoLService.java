package com.hj.lolhuni.service;

import com.hj.lolhuni.model.lol.CurrentGameInfo;
import com.hj.lolhuni.model.lol.RawStatsDto;
import com.hj.lolhuni.model.lol.RecentGamesDto;
import com.hj.lolhuni.model.lol.Summoner;

public interface LoLService {
	
	Summoner getSummonerInfo(String summonerName);
	
	CurrentGameInfo getGameInfo(long summonerId);
	
	public void sendFbMessage(String result, String phoneNumber);
	
	RecentGamesDto recentGameInfo(long summonerId);
	void getGameStats(RawStatsDto stats);
}
