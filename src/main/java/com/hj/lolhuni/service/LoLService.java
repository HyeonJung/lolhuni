package com.hj.lolhuni.service;

import com.hj.lolhuni.model.CurrentGameInfo;
import com.hj.lolhuni.model.Summoner;

public interface LoLService {
	
	Summoner getSummonerInfo(String summonerName);
	
	CurrentGameInfo getGameInfo(long summonerId);
}
