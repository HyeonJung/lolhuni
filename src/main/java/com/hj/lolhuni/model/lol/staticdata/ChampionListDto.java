package com.hj.lolhuni.model.lol.staticdata;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChampionListDto {

	private Map<String,String> keys;
	private Map<String,ChampionDto> data;
	private String version;
	private String type;
	private String format;
	
}
