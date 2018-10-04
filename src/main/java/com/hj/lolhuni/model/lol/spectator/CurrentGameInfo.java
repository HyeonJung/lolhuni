package com.hj.lolhuni.model.lol.spectator;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
	
}
