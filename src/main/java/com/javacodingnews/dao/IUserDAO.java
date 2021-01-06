package com.javacodingnews.dao;

import com.javacodingnews.model.UserModel;

public interface IUserDAO {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
