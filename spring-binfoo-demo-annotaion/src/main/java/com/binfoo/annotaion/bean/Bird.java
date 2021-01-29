package com.binfoo.annotaion.bean;

public class Bird {

	private Integer gender;
	private String  name;

	public Bird(String name, Integer gender) {
		this.gender = gender;
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
