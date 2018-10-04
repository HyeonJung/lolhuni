package com.hj.lolhuni.model.lol.staticdata;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlockDto {

	private List<BlockItemDto> items;
	private boolean recMath;
	private String type;
	
}
