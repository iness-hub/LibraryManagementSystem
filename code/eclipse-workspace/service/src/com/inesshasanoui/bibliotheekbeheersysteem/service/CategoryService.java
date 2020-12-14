package com.inesshasanoui.bibliotheekbeheersysteem.service;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Category;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CategoryItem;

public interface CategoryService extends Service<Category> {
	Category get(CategoryItem name);
}
