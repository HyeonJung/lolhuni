package com.hj.lolhuni.model.lol.staticdata;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpellVarsDto {
	private String ranksWith; 
	private String dyn;
	private String link;
	private List<Double> coeff;
	private String key;
}
