package com.icia.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //IoC 컨테이너에서 관리
public class Student {
	
	@Autowired //의존주입
	private Person man;
	public String sleep() {
		return man.sleep();
	}
}