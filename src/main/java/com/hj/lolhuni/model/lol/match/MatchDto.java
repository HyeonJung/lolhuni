package com.hj.lolhuni.model.lol.match;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MatchDto {

	private int seasonId;
	private int queueId;
	private long gameId;
	private List<ParticipantIdentityDto> participantIdentities;
	private String gameVersion;
	private String platformId;
	private String gameMode;
	private int mapId;
	private String gameType;
	private List<TeamStatsDto> teams;
	private List<ParticipantDto> participants;
	private long gameDuration;
	private long gameCreation;
}
