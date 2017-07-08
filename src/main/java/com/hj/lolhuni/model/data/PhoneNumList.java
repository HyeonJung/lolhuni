package com.hj.lolhuni.model.data;

public enum PhoneNumList {

	마이스페이스("+82(010)2517-1592"),
	Tanghu("+82(010)4140-8702"),
	고릴라피시방("+82(010)3632-7381");
	
	private String tel;
	
	public String getTel() {
		return tel;
	}

	PhoneNumList(String tel) {
		this.tel = tel;
	}
}
