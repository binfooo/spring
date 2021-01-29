package com.binfoo.demo;

import org.springframework.stereotype.Service;

@Service
public class BinfooSerivce {

	public void sayHello(String str) {
		System.out.println("Hello, " + str);
	}
}
