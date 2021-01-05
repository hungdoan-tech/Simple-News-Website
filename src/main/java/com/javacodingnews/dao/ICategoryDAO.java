package com.javacodingnews.dao;

import java.util.List;

import com.javacodingnews.model.CategoryModel;

public interface ICategoryDAO {

	List<CategoryModel> findAll();
}
