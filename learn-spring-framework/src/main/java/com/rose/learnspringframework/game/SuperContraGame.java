package com.rose.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
/*Cuando se tienen varias clases para cubrir una dependencia se puede utilizar 
 * esta anotacion para indicar que si hay varias tome por defautl esta */
@Primary
public class SuperContraGame implements GamingConsole{

	public void up() { 
		System.out.println("Super contra game up");
	}
	
	public void down() { 
		System.out.println("Super contra game down");
	}
	
	public void left() { 
		System.out.println("Super contra game left");
	}
	
	public void right() { 
		System.out.println("Super contra game right");
	}
}
