package com.rose.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.rose.learnspringframework.enterprise.example.web.*;
import com.rose.learnspringframework.game.GameRunner;
import com.rose.learnspringframework.game.MarioGame;
import com.rose.learnspringframework.game.PacmanGame;
import com.rose.learnspringframework.game.SuperContraGame;

/*Esta anotacion por default tiene la anotacion @ComponentScan y escanea el directorio actual 
 * y sus sub directorios para buscar anotaciones tipo @Component y administrar las clases */
@SpringBootApplication

/*sobreescribe la ruta por default de los paquetes*/
//@ComponentScan("com.rose.learnspringframework.1")
/*Tambien se pueden definir varios paquetes pasando un array de paquetes de esta forma */
//@ComponentScan({"com.rose.learnspringframework.1", "com.rose.learnspringframework.2", "com.rose.learnspringframework.3"} )
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
		
		var controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
