package com.hj.lolhuni.model.lol;

public class PlayerDto {
	private int teamId;
	private int championId;
	private long summonerId;
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public long getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}
	
	@Override
	public String toString() {
		return "PlayerDto [teamId=" + teamId + ", championId=" + championId + ", summonerId=" + summonerId + "]";
	}
	
	
}
