package com.hj.lolhuni.model.lol;

import java.util.Date;

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
public class Summoner {

	@Id
	@Column
	private long id;
	@Column
	private long accountId;
	@Column
	private String name;
	@Column
	private int profileIconId;
	@Column
	private Date revisionDate;
	@Column
	private long summonerLevel;
	
}
