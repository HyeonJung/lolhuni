package com.hj.lolhuni.model.lol;

public class BannedChampion {

	private int pickTurn;
	private long championId;
	private long teamId;
	
	public int getPickTurn() {
		return pickTurn;
	}
	public void setPickTurn(int pickTurn) {
		this.pickTurn = pickTurn;
	}
	public long getChampionId() {
		return championId;
	}
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	
	@Override
	public String toString() {
		return "BannedChampion [pickTurn=" + pickTurn + ", championId=" + championId + ", teamId=" + teamId + "]";
	}
	
}
