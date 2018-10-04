package com.hj.lolhuni.model.lol.match;

import com.hj.lolhuni.model.lol.PlayerDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParticipantIdentityDto {

	private PlayerDto player;
	private int participantId;
	
}
