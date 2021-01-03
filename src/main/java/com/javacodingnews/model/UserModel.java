package com.javacodingnews.model;

public class UserModel {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserModel(String name) {
		super();
		this.name = name;
	}	
	
	public UserModel() {

	}
}
