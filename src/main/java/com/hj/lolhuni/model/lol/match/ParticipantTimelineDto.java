package com.hj.lolhuni.model.lol.match;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParticipantTimelineDto {

	private String lane;
	private int participantId;
	private Map<String,Double> csDiffPerMinDeltas;
	private Map<String,Double> goldPerMinDeltas;
	private Map<String,Double> xpDiffPerMinDeltas;
	private Map<String,Double> creepsPerMinDeltas;
	private Map<String,Double> xpPerMinDeltas;
	private String role;
	private Map<String,Double> damageTakenDiffPerMinDeltas;
	private Map<String,Double> damageTakenPerMinDeltas;

}
