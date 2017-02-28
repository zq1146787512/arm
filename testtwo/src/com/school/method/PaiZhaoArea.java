package com.school.method;

import java.util.HashMap;

public class PaiZhaoArea {
	private HashMap<String, String> hashMap;

	public PaiZhaoArea() {
		this.hashMap = new HashMap<String, String>();
		hashMap.put("沪", "H");
	}

	public String getValue(String s) {
		return hashMap.get(s);
	}

}
