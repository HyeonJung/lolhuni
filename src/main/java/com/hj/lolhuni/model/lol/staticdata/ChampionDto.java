package com.hj.lolhuni.model.lol.staticdata;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChampionDto {

	private InfoDto info;
	private List<String> enemytips;
	private StatsDto stats;
	private String name;
	private String title;
	private ImageDto image;
	private List<String> tags;
	private String partype;
	private List<SkinDto> skins;
	private PassiveDto passvie;
	private List<RecommendedDto> recommended;
	private List<String> allytips;
	private String key;
	private String lore;
	private int id;
	private String blurb;
	private List<ChampionSpellDto> spells;

}
