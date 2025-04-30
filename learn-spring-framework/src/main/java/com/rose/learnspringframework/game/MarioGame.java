package com.rose.learnspringframework.game;

import org.springframework.stereotype.Component;

/*Component es solo una clase administrada por spring framework*/
/**
 * demonstrates the use of the Gaming console interface.
 */
@Component
public class MarioGame implements GamingConsole{

	/**
	 * Action when pressing the up button
	 */
	public void up() { 
		System.out.println("Jump");
	}
	
	/**
	 * Action when pressing the down button
	 */
	public void down() { 
		System.out.println("Down into a hole");
	}
	
	/**
	 * Action when pressing the left button
	 */
	public void left() { 
		System.out.println("Stop");
	}
	
	/**
	 * Action when pressing the right button
	 */
	public void right() { 
		System.out.println("Accelerate");
	}
}
