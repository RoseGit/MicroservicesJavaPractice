package com.rose.learnspringframework.game;

import org.springframework.stereotype.Component;

/*Component es solo una clase administrada por spring framework*/
@Component
public class MarioGame implements GamingConsole{

	public void up() { 
		System.out.println("Jump");
	}
	
	public void down() { 
		System.out.println("Down into a hole");
	}
	
	public void left() { 
		System.out.println("Stop");
	}
	
	public void right() { 
		System.out.println("Accelerate");
	}
}
