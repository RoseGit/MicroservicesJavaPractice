package com.rose.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Demonstrates the use of the GamingConsole interface
 */
@Component
public class GameRunner {

	@Autowired
	private GamingConsole game;
	
	/**
	 * Defautl constructor.
	 * @param game
	 */
	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	
	/**
	 * Shows the use of the methods declared in the interface.
	 */
	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}	
}
