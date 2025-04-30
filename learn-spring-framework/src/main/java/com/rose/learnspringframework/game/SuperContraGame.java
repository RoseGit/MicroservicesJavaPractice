package com.rose.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/**
 * Demonstrates the use of the Gaming console interface.
 */
@Component
/*Cuando se tienen varias clases para cubrir una dependencia se puede utilizar 
 * esta anotacion para indicar que si hay varias tome por defautl esta */
@Primary
public class SuperContraGame implements GamingConsole{

	/**
	 * Action when pressing the up button
	 */
	public void up() { 
		System.out.println("Super contra game up");
	}
	
	/**
	 * Action when pressing the down button
	 */
	public void down() { 
		System.out.println("Super contra game down");
	}
	
	/**
	 * Action when pressing the left button
	 */
	public void left() { 
		System.out.println("Super contra game left");
	}
	
	/**
	 * Action when pressing the right button
	 */
	public void right() { 
		System.out.println("Super contra game right");
	}
}
