package com.hj.lolhuni.model.lol.staticdata;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PassiveDto {

	private ImageDto image;
	private String sanitizedDescription;
	private String name;
	private String description;

}
