package com.in28munites.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class Pacman implements GamingConsole{
	
	public void up() {
		System.out.println("go up");
	}
	public void down() {
		System.out.println("go down");
	}
	public void left() {
		System.out.println("go back");
	}
	public void right() {
		System.out.println("go straight");
	}

}
