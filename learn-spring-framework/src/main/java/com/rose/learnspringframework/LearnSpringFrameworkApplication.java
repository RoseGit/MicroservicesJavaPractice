package com.rose.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rose.learnspringframework.game.GameRunner;
import com.rose.learnspringframework.game.MarioGame;
import com.rose.learnspringframework.game.PacmanGame;
import com.rose.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		var game = new PacmanGame();
		GameRunner runner = new GameRunner(game);
		
		runner.run();
	}

}
