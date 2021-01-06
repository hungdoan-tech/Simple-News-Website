package com.javacodingnews.service.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.javacodingnews.dao.IUserDAO;
import com.javacodingnews.dao.impl.UserDAO;
import com.javacodingnews.model.UserModel;
import com.javacodingnews.service.IUserService;

@ManagedBean
public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
