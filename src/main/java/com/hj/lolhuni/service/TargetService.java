package com.hj.lolhuni.service;

import java.util.List;

import com.hj.lolhuni.model.Target;

public interface TargetService {

	Target registTarget(String name, String summonerName);
	List<Target> getTargets();
	void removeTarget(long summonerId,int userNo);
	List<Target> getTargetsBySummonerId(long summonerId);
}
