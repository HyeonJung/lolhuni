package com.hj.lolhuni.model.lol.staticdata;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecommendedDto {

	private String map;
	private List<BlockDto> blocks;
	private String champion;
	private String title;
	private boolean priority;
	private String mode;
	private String type;
	
}
