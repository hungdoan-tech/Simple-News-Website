package com.javacodingnews.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javacodingnews.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel category = new CategoryModel();
		try {
			category.setId(resultSet.getLong("id"));
			category.setName(resultSet.getString("name"));
			category.setCode(resultSet.getString("code"));
			return category;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
