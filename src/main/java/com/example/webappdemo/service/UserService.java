package com.example.webappdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.webappdemo.exception.UserNotFoundException;
import com.example.webappdemo.model1.User;

@Component
public class UserService {

	private List<User> users = new ArrayList<>();

	
	public User addUser(User user) {
		users.add(user);
		return user;
	}
	
	public User getUserByUsername(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst()
				.orElseThrow(() -> new UserNotFoundException(username));
	}

}
