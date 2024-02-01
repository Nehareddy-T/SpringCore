package com.in28munites.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
private GamingConsole game;
public GameRunner(@Qualifier("contra") GamingConsole game) {
	this.game = game;
	
}
public void run() {
	// TODO Auto-generated method stub
	System.out.println("running...."+game);
	game.up();
	game.down();
	game.left();
	game.right();
	
}

}
