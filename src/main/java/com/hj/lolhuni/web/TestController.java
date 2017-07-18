package com.hj.lolhuni.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.lolhuni.model.Champion;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.model.lol.spectator.CurrentGameInfo;
import com.hj.lolhuni.service.ChampionService;
import com.hj.lolhuni.service.GameService;
import com.hj.lolhuni.service.LoLService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "TestApi")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	LoLService lolService;
	
	@Autowired
	GameService gameService;
	
	@Autowired
	ChampionService championService;
	
	/**
	 * 현재 게임 정보
	 * @param summonerName
	 * @return
	 */
	@ApiOperation("소환사 정보")
	@RequestMapping(value = "/testSummoner/{summonerName}", method = RequestMethod.GET)
	@ResponseBody
	public CurrentGameInfo test(@PathVariable String summonerName) {
		Summoner summoner = lolService.getSummonerInfo(summonerName);
		return lolService.getGameInfo(summoner.getId());
	}
	
	/**
	 * verify
	 * @return
	 */
	@ApiOperation("라이엇 verify")
	@RequestMapping(value = "riot.txt", method = RequestMethod.GET)
	@ResponseBody
    public String riotVerify() {
    	return "6e513f73-f636-4e35-afbd-1131ceec58f2";
    }
	
	/**
	 * 페이스북 메시지 테스트
	 * @param message
	 * @return
	 */
	@ApiOperation("페이스북 메시지 테스트")
	@RequestMapping(value = "fbMessage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> sendFbMessage(@RequestBody String message) {
		
		lolService.sendFbMessage("[페이스북 메시지 테스트용]" + message, "+82(010)2517-1592");
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	/**
	 * 챔피언
	 */
	@ApiOperation("챔피언 등록")
	@RequestMapping(value = "champion", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> championRegist() {
		
		championService.registChampionList();
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	/**
	 * 챔피언
	 */
	@ApiOperation("챔피언 테스트")
	@RequestMapping(value = "champion/test", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> championTest() {
		
		Champion champion = championService.getChampionInfo(1);
		logger.debug("### champion = {}",champion);
		return new ResponseEntity<Champion>(champion,HttpStatus.OK);
		
	}
	
	
	

}
