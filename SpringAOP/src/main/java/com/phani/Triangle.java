package com.phani;

import com.phani.aspect.Loggable;

public class Triangle {
	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setter triangle");
		//throw(new RuntimeException());
	}
	
	public String setNameandReturn(String name) {
		this.name = name;
		System.out.println("return "+name);
		return name+" kanth";
		//throw(new RuntimeException());
	}
	public void retEx(String name) {
		System.out.println("Exception method");
		throw(new RuntimeException());
	}
}
