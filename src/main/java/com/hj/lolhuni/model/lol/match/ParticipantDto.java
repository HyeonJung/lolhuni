package com.hj.lolhuni.model.lol.match;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParticipantDto {

	private ParticipantStatsDto stats;
	private int participantId;
	private List<RuneDto> runes;
	private ParticipantTimelineDto timeline;
	private int teamId;
	private int spell2Id;
	private List<MasteryDto> masteries;
	private String highestAchievedSeasonTier;
	private int spell1Id;
	private int championId;	
	
}
