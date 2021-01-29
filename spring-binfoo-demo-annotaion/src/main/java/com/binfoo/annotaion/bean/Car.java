package com.binfoo.annotaion.bean;

import org.springframework.beans.factory.annotation.Value;

public class Car {

	private String carName;
	@Value("12")
	private String carAge;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarAge() {
		return carAge;
	}

	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}
}
