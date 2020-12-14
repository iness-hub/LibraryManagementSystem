package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Category;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CategoryItem;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.CategoryDao;



public class CategoryServiceImpl implements CategoryService {
private CategoryDao categoryDao;

	public CategoryServiceImpl(CategoryDao categoryDao) {
	super();
	this.categoryDao = categoryDao;
}

	@Override
	public Category insert(Category category) {
		return categoryDao.insert(category);
		
	}

	@Override
	public Category update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public boolean delete(Category category) {
		return categoryDao.delete(category);
	}

	@Override
	public Category get(long id) {
		return categoryDao.get(id);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public Category get(CategoryItem name) {
		return categoryDao.get(name);
		
	}

}
