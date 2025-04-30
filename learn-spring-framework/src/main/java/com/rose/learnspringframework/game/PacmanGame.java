package com.rose.learnspringframework.game;

import org.springframework.stereotype.Component;

/**
 * Demonstrates the use of the Gaming console interface.
 */
@Component
public class PacmanGame implements GamingConsole{

	/**
	 * Action when pressing the up button
	 */
	public void up() { 
		System.out.println("PacmanGame up");
	}
	
	/**
	 * Action when pressing the down button
	 */
	public void down() { 
		System.out.println("PacmanGame down");
	}
	
	/**
	 * Action when pressing the left button
	 */
	public void left() { 
		System.out.println("PacmanGame left");
	}
	
	/**
	 * Action when pressing the right button
	 */
	public void right() { 
		System.out.println("PacmanGame right");
	}
}
