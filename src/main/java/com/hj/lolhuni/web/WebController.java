package com.hj.lolhuni.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hj.lolhuni.model.lol.CurrentGameInfo;
import com.hj.lolhuni.model.lol.Summoner;
import com.hj.lolhuni.service.LoLService;

@Controller
public class WebController {
	
	@Autowired
	LoLService lolService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public CurrentGameInfo test() {
		Summoner summoner = lolService.getSummonerInfo("고릴라피시방");
		return lolService.getGameInfo(summoner.getId());
	}
	

}
