package com.hj.lolhuni.model.lol.spectator;

import java.util.List;

public class CurrentGameParticipant {
	private long profileIconId;
	private long championId;
	private String summonerName;
	private List<Rune> runes;
	private boolean bot;
	private List<Mastery> masteries;
	private long spell2Id;
	private long teamId;
	private long spell1Id;
	private long summonerId;
	
	public long getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(long profileIconId) {
		this.profileIconId = profileIconId;
	}
	public long getChampionId() {
		return championId;
	}
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public List<Rune> getRunes() {
		return runes;
	}
	public void setRunes(List<Rune> runes) {
		this.runes = runes;
	}
	public boolean isBot() {
		return bot;
	}
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	public List<Mastery> getMasteries() {
		return masteries;
	}
	public void setMasteries(List<Mastery> masteries) {
		this.masteries = masteries;
	}
	public long getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(long spell2Id) {
		this.spell2Id = spell2Id;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public long getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(long spell1Id) {
		this.spell1Id = spell1Id;
	}
	public long getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}
	
	@Override
	public String toString() {
		return "CurrentGameParticipant [profileIconId=" + profileIconId + ", championId=" + championId
				+ ", summonerName=" + summonerName + ", runes=" + runes + ", bot=" + bot + ", masteries=" + masteries
				+ ", spell2Id=" + spell2Id + ", teamId=" + teamId + ", spell1Id=" + spell1Id + ", summonerId="
				+ summonerId + "]";
	}
	
}
