package com.hj.lolhuni.model.data;

public enum CheckList {

	고릴라피시방(1343521L),
	Tanghu(4380218L);
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	CheckList(Long id) {
		this.id = id;
	}
}
