package com.rose.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rose.learnspringframework.game.GameRunner;
import com.rose.learnspringframework.game.MarioGame;
import com.rose.learnspringframework.game.PacmanGame;
import com.rose.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
		/*Iteration 3*/
		//Utilizando el contexto de spring, administrad todos los beans 
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		//Todos los componentes que spring utiliza son llamados beans, para obtener un bean en particular 
		var runner = context.getBean(GameRunner.class);
		runner.run();
		
		
		/* Iteration 2
		//Sin contexto de spring
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		//var game = new PacmanGame();
		//GameRunner runner = new GameRunner(game);
		//runner.run();
		 */
	}

}
