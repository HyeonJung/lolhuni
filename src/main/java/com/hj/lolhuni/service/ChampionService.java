package com.hj.lolhuni.service;

import com.hj.lolhuni.model.Champion;

public interface ChampionService {

	void registChampionList();
	Champion getChampionInfo(int championId);
}
