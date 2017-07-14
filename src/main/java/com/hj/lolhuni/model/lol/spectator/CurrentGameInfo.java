package com.hj.lolhuni.model.lol.spectator;

import java.util.List;

public class CurrentGameInfo {
	private long gameId;
	private long gameStartTime;
	private String platformId;
	private String gameMode;
	private long mapId;
	private String gameType;
	private List<BannedChampion> bannedChampions;
	private Observer observers;
	private List<CurrentGameParticipant> participants;
	private long gameLength;
	private long gameQueueConfigId;
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getGameStartTime() {
		return gameStartTime;
	}
	public void setGameStartTime(long gameStartTime) {
		this.gameStartTime = gameStartTime;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public long getMapId() {
		return mapId;
	}
	public void setMapId(long mapId) {
		this.mapId = mapId;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public List<BannedChampion> getBannedChampions() {
		return bannedChampions;
	}
	public void setBannedChampions(List<BannedChampion> bannedChampions) {
		this.bannedChampions = bannedChampions;
	}
	public Observer getObservers() {
		return observers;
	}
	public void setObservers(Observer observers) {
		this.observers = observers;
	}
	public List<CurrentGameParticipant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<CurrentGameParticipant> participants) {
		this.participants = participants;
	}
	public long getGameLength() {
		return gameLength;
	}
	public void setGameLength(long gameLength) {
		this.gameLength = gameLength;
	}
	public long getGameQueueConfigId() {
		return gameQueueConfigId;
	}
	public void setGameQueueConfigId(long gameQueueConfigId) {
		this.gameQueueConfigId = gameQueueConfigId;
	}
	
	@Override
	public String toString() {
		return "CurrentGameInfo [gameId=" + gameId + ", gameStartTime=" + gameStartTime + ", platformId=" + platformId
				+ ", gameMode=" + gameMode + ", mapId=" + mapId + ", gameType=" + gameType + ", bannedChampions="
				+ bannedChampions + ", observers=" + observers + ", participants=" + participants + ", gameLength="
				+ gameLength + ", gameQueueConfigId=" + gameQueueConfigId + "]";
	}
}
