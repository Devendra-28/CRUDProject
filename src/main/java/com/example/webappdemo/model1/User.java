package com.example.webappdemo.model1;

public class User {
private String username;
private int age;

public User(String userName, int age) {
	super();
	this.username = username;
	this.age = age;
}

public User() {
	
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

}
