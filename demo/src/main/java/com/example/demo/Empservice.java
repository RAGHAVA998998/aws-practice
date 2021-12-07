package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.carreg.car;

@Service
public class Empservice {
	@Autowired
	car car1;
	public void display() {
		car1.display();
	}
}
