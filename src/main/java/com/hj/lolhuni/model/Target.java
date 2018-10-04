package com.hj.lolhuni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@IdClass(TargetPk.class)
public class Target {

	@Id
	@Column
	private long summonerId;
	
	@Id
	@Column
	private int userNo;

}
