package com.javacodingnews.dao.impl;

import java.util.List;

import javax.annotation.ManagedBean;

import com.javacodingnews.dao.ICategoryDAO;
import com.javacodingnews.mapper.CategoryMapper;
import com.javacodingnews.model.CategoryModel;

@ManagedBean
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	@Override
	public List<CategoryModel> findAll() {		
		String sql = "Select * from category";
		CategoryMapper categoryMapper = new CategoryMapper();
		List<CategoryModel> categoryList = this.query(sql, categoryMapper);
		return categoryList;
	}
}
