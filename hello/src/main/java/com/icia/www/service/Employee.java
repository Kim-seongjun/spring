package com.icia.www.service;

import org.springframework.stereotype.Component;
@Component
public class Employee extends Person {
	
	
	public String sleep() {
		return "사람은 6시간잡니까?";
	}
}
