package com.in28munites.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Mario implements GamingConsole {

	public void up() {
		
		System.out.println("jump");
	}
	
	public void down() {
		System.out.println("duck");
	}
	
	public void left() {
		System.out.println("go back");
	}
	
	public void right() {
		System.out.println("accelerate");
	}
	
}
