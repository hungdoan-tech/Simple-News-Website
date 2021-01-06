package com.javacodingnews.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javacodingnews.model.RoleModel;
import com.javacodingnews.model.UserModel;

public class UserMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		} catch (SQLException e) {
			return null;
		}	
	}
}
