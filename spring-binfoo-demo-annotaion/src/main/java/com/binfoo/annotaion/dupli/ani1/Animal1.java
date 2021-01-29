package com.binfoo.annotaion.dupli.ani1;

import org.springframework.stereotype.Component;

@Component("animal0")
public class Animal1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
