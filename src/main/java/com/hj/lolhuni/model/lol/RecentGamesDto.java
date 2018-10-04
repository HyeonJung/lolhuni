package com.hj.lolhuni.model.lol;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecentGamesDto {

	private long summonerId;
	private Set<GameDto> games;
	
}
