package com.hj.lolhuni.service;

import java.util.List;

import com.hj.lolhuni.model.User;

public interface UserService {

	/**
	 * 유저 등록
	 * @param name
	 * @param tel
	 * @param summonerName
	 * @return
	 */
	User registUser(String name, String tel, String summonerName);
	
	/**
	 * 유저목록
	 * @return
	 */
	List<User> getUsers();
	
	/**
	 * 유저
	 * @param name
	 * @return
	 */
	User getUser(String name);
	User getUser(int userNo);
	
	/**
	 * 유저 삭제
	 * @param name
	 */
	void removeUser(String name);
	
	
}
