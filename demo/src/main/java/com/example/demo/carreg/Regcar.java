package com.example.demo.carreg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "reg")
public class Regcar implements car {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("regcar class");
	}

}
