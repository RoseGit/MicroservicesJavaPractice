package com.rose.rest.webservices.restful.web.services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rose.rest.webservices.restful.web.services.jpa.PostRepository;
import com.rose.rest.webservices.restful.web.services.jpa.UserRepository;

import jakarta.validation.Valid;

/**
 * Controller to manage user information using JPA.
 */
@RestController
public class UserResourceJpa {

	private UserDaoService service;
	private UserRepository repository;
	private PostRepository postRepository;
	
	/**
	 * Default constructor 
	 * @param repository See {@link UserRepository} and {@link PostRepository}
	 * @param postRepository
	 */
	public UserResourceJpa(UserRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	/**
	 * Recover all users
	 * @return See {@link User}
	 */
	@GetMapping(path="/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves a user by its id.
	 * @param id The user ID.
	 * @return See {@link EntityModel} and {@link User}
	 */
	@GetMapping(path="/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) { 
			throw new UserNotFoundException("id:"+id);
		}
		
		//Agregamos el enlace por medio del metodo por si cambia la URL 
		EntityModel entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel; 
		
	}
	
	/**
	 * Allows you to create a new user.
	 * @param user See {@link User}
	 * @return See {@link ResponseEntity} and {@link User}
	 */
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Validated @RequestBody  User user) {
		var userSaved = repository.save(user);
		
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
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	/**
	 * Retrieves the posts that a user has
	 * @param id The userID
	 * @return See {@link Post}
	 */
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) { 
			throw new UserNotFoundException("id:"+id);
		}
		
		return user.get().getPosts();
	}
	
	/**
	 * Allows you to register a new user post.
	 * @param id The user ID.
	 * @param post See {@link Post}
	 * @return See {@link ResponseEntity}
	 */
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) { 
			throw new UserNotFoundException("id:"+id);
		}
		
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
}
