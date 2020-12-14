package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Category;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CategoryItem;

public interface CategoryDao extends CrudDao<Category> {
	 Category get(CategoryItem name);

}
