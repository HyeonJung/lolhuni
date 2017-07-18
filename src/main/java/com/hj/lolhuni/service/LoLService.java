package com.hj.lolhuni.service;

import com.hj.lolhuni.model.lol.RecentGamesDto;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.model.lol.match.MatchDto;
import com.hj.lolhuni.model.lol.spectator.CurrentGameInfo;
import com.hj.lolhuni.model.lol.staticdata.ChampionListDto;

public interface LoLService {
	
	Summoner getSummonerInfo(String summonerName);
	
	CurrentGameInfo getGameInfo(long summonerId);
	
	void sendFbMessage(String message, String phoneNumber);
	
	RecentGamesDto recentGameInfo(long summonerId);
	
	MatchDto getMatchInfo(long matchId);

	ChampionListDto getChampionList();
	void sendFbMessageWithTemplate(String phoneNumber, String imageUrl, String title, String subTitle);
	void sendFbMessageWithTemplateButton(String phoneNumber, String imageUrl, String title, String subTitle);
}
