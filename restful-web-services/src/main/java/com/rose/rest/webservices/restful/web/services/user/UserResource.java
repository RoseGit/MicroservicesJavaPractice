package com.rose.rest.webservices.restful.web.services.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Controller to manage user information in memory.
 */
@RestController
public class UserResource {

	private UserDaoService service;
	
	/**
	 * Default constuctor.
	 * @param service See {@link UserDaoService}
	 */
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	/**
	 * Recover all users
	 * @return See {@link User}
	 */
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	/**
	 * Retrieves a user by its id.
	 * @param id The user ID.
	 * @return See {@link EntityModel}
	 */
	@GetMapping(path="/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		User user = service.findOne(id);
		if(user == null) { 
			throw new UserNotFoundException("id:"+id);
		}
		
		//Agregamos el enlace por medio del metodo por si cambia la URL 
		EntityModel entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel; 
		
	}
	
	/**
	 * Allows you to create a new user.
	 * @param user See {@link User}
	 * @return See {@link ResponseEntity} and {@link User}
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Validated @RequestBody  User user) {
		var userSaved = service.saveUser(user);
		
		//devolvemos el location del recurso creado en los headers de la respuesta 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userSaved.getId())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	/**
	 * Allows you to delete a user.
	 * @param id The user id.
	 */
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
}
