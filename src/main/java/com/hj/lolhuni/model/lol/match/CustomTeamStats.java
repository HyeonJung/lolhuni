package com.hj.lolhuni.model.lol.match;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomTeamStats {

	private int totalKill;
	private int totalDeath;
	private int totalAssists;
	private long totalDamage;
	
	public void addData(int kills, int deaths, int assists, long damages) {
		this.totalKill += kills;
		this.totalDeath += deaths;
		this.totalAssists += assists;
		this.totalDamage += damages;
	}

}
