package com.hj.lolhuni.model.lol.match;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamStatsDto {
	
	private boolean firstDragon;
	private boolean firstInhibitor;
	private List<TeamBansDto> bans;
	private int baronKills;
	private boolean firstRiftHerald;
	private boolean firstBaron;
	private int riftHeraldKills;
	private boolean firstBlood;
	private int teamId;
	private boolean firstTower;
	private int vilemawKills;
	private int inhibitorKills;
	private int towerKills;
	private int dominionVictoryScore;
	private String win;
	private int dragonKills;
	
}
