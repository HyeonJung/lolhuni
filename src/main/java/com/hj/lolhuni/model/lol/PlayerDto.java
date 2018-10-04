package com.hj.lolhuni.model.lol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerDto {
	
	private String currentPlatformId;
	private String summonerName;
	private String matchHistoryUri;
	private String platformId;
	private long currentAccountId;
	private int profileIcon;
	private long summonerId;
	private long accountId;
	
}
