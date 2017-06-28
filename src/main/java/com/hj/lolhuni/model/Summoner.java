package com.hj.lolhuni.model;

import java.util.Date;

public class Summoner {

	private long id;
	private long accountId;
	private String name;
	private int profileIconId;
	private Date revisionDate;
	private long summonerLevel;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getAccountId() {
		return accountId;
	}


	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getProfileIconId() {
		return profileIconId;
	}


	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}


	public Date getRevisionDate() {
		return revisionDate;
	}


	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}


	public long getSummonerLevel() {
		return summonerLevel;
	}


	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	@Override
	public String toString() {
		return "Summoner [id=" + id + ", accountId=" + accountId + ", name=" + name + ", profileIconId=" + profileIconId
				+ ", revisionDate=" + revisionDate + ", summonerLevel=" + summonerLevel + "]";
	}
	
	
	
}