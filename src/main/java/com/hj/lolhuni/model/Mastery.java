package com.hj.lolhuni.model;

public class Mastery {
	private long masteryId;
	private int rank;
	
	public long getMasteryId() {
		return masteryId;
	}
	public void setMasteryId(long masteryId) {
		this.masteryId = masteryId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Mastery [masteryId=" + masteryId + ", rank=" + rank + "]";
	}
}
