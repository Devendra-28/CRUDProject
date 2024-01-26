package com.example.webappdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.webappdemo.exception.UserNotFoundException;
import com.example.webappdemo.model1.User;
import com.example.webappdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	  @Autowired
	    private UserService userService;
	  
	  @PostMapping
	    public ResponseEntity<User> addUser(@RequestBody User user) {
	        userService.addUser(user);
	        return new ResponseEntity<>(user, HttpStatus.CREATED);
	    }
	  @GetMapping("/{username}")
	    public ResponseEntity<User> getUser(@PathVariable String username) {
	        User user = userService.getUserByUsername(username);
	        return new ResponseEntity<>(user, HttpStatus.OK);
}
	// Exception handling
	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
}