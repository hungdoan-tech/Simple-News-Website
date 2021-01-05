package com.javacodingnews.service;

import java.util.List;

import com.javacodingnews.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
