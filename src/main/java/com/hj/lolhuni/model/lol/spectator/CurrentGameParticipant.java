package com.hj.lolhuni.model.lol.spectator;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
	
}
