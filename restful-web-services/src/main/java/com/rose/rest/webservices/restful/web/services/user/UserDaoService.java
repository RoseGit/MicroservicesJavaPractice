package com.rose.rest.webservices.restful.web.services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

/**
 * User data access service.
 */
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 0;
	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
	};
	
	/**
	 * Returns all users.
	 * @return See {@link User}.
	 */
	public List<User> findAll(){
		return users;
	}
	
	/**
	 * Find a user by their ID.
	 * @param id The user ID.
	 * @return See {@link User}
	 */
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream()
				.filter(predicate).findFirst() //find the user
				.orElse(null); //devolver valor que nosotros definamos si no existe, que no arroje exception
	}
	
	/**
	 * Register a new user.
	 * @param user See {@link User}
	 * @return See {@link User}.
	 */
	public User saveUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	/**
	 * Delete a user by their ID.
	 * @param id The user ID.
	 */
	public void deleteById(int id ) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
