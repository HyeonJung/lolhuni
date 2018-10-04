package com.hj.lolhuni.model.lol;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 삭제예정
 * @author hj
 *
 */
@Getter
@Setter
@ToString
public class GameDto {

	private String gameType;
	private long gameId;
	private RawStatsDto stats;
	private int level;
	private long createDate;
	private String gameMode;
	private int mapId;
	private boolean invalid;
	private String subType;
	private int teamId;
	private int ipEarned;
	private List<PlayerDto> fellowPlayers;
	private int championId;
	private int spell1;
	private int spell2;
	
}
