package com.in28munites.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contra")
public class SuperContra implements GamingConsole{
public void up() {
		
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("back");
	}
	
	public void right() {
		System.out.println("front");
	}
}
