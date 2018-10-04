package com.hj.lolhuni.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.hj.lolhuni.model.data.Notification;
import com.hj.lolhuni.model.lol.Summoner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "games")
public class Game {
	
	@Id
	@TableGenerator(name = "GEN_GAME_NO", allocationSize = 1)
	@GeneratedValue(generator = "GEN_GAME_NO", strategy = GenerationType.TABLE)
	private long gameNo;
	
	@Column
	private long gameId;
	
	@ManyToOne
	@JoinColumn(name = "SUMMONER_ID")
	private Summoner summoner;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Notification playNotification;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Notification resultNotification;
	
	@Column
	private Date regDate;
	
	@Column
	private long teamId;
	
}
