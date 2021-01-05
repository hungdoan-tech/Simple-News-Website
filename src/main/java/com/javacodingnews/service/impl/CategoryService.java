package com.javacodingnews.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.javacodingnews.dao.ICategoryDAO;
import com.javacodingnews.model.CategoryModel;
import com.javacodingnews.service.ICategoryService;

@ManagedBean
public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
		
	}
	
}
