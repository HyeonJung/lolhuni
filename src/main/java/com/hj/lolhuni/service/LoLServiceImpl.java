package com.hj.lolhuni.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hj.lolhuni.model.lol.CurrentGameInfo;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.util.HttpConnectionUtil;
import com.hj.lolhuni.util.JsonConvertUtil;

@Service
public class LoLServiceImpl implements LoLService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoLServiceImpl.class); 
	
	@Value("${baseUrl}")
	String baseUrl;
	
	@Value("${lolApiKey}")
	String lolApiKey;
	
	@Value("${fbUrl}")
	String fbUrl;
	
	@Value("${fbAccessToken}")
	String fbAccessToken;
	
	/**
	 * 소환사 정보 
	 */
	@Override
	public Summoner getSummonerInfo(String summonerName) {
		Summoner summoner = null;
		String url = baseUrl + "/lol/summoner/v3/summoners/by-name/" + summonerName + "?api_key=" + lolApiKey;
		try {
			String result = HttpConnectionUtil.connectGetJson(url);
			logger.debug("### result = {}",result);
			
			if (result != null && result.length() > 0) {
				summoner = (Summoner) JsonConvertUtil.jsonConvertToObject(result, Summoner.class);
			}
			
		} catch (Exception e) {
			logger.error("### error",e);
		}
		
		return summoner;
	}
	
	
	/**
	 * 게임 정보
	 */
	@Override
	public CurrentGameInfo getGameInfo(long summonerId) {
		CurrentGameInfo gameInfo = null;
		String url = baseUrl + "/observer-mode/rest/consumer/getSpectatorGameInfo/KR/" + summonerId + "?api_key=" + lolApiKey;
		
		try {
			String result = HttpConnectionUtil.connectGetJsonForCurrentGameInfo(url);
			
			if (result != null && result.length() > 0) {
				gameInfo = (CurrentGameInfo) JsonConvertUtil.jsonConvertToObject(result, CurrentGameInfo.class);
				logger.debug("### result = {}",result);
			}
			
		} catch (Exception e) {
			logger.debug("### 게임 중이 아닙니다.");
		}
		
		return gameInfo;
	}
	
	/**
	 * 메시지 보내기
	 */
	@Override
	public void sendFbMessage(String result, String phoneNumber) {
		
		String url = fbUrl + "me/messages?access_token=" + fbAccessToken;
		logger.debug("### url = {}",url);
		HttpConnectionUtil.connectPostJsonForFbMessageSend(url, phoneNumber, result);
	}

	
}
