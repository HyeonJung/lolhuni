package com.hj.lolhuni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Champion {

	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String enName;
	
	@Column
	private String championKey;
	
}
