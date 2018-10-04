package com.hj.lolhuni.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import com.hj.lolhuni.model.lol.Summoner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "users")
@Getter
@Setter
@ToString
public class User {
	
	@Id
	@TableGenerator(name = "GEN_USER_NO", allocationSize = 1)
	@GeneratedValue(generator = "GEN_USER_NO", strategy = GenerationType.TABLE)
	private int userNo;
	
	@Column
	private String name;
	
	@Column
	private String tel;
	
	@Column
	private Date regDate;
	
	@OneToOne
	@JoinColumn(name = "SUMMONER_ID")
	private Summoner summoner;
	
}
