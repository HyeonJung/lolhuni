package com.hj.lolhuni.model.lol.spectator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BannedChampion {

	private int pickTurn;
	private long championId;
	private long teamId;
}