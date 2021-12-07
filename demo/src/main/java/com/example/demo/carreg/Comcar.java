package com.example.demo.carreg;

import org.springframework.stereotype.Component;

@Component(value = "com")
public class Comcar implements car {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("comcar class");
	}

}
