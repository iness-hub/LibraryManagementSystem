package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Category;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CategoryItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;


public class CategoryDaoDB implements CategoryDao{
	private ConnectDB connectDB;
	
	public CategoryDaoDB (ConnectDB connectDB) {
		this.connectDB = connectDB;
	}
	@Override
	public Category insert(Category obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category get(long id) {
		String query = "SELECT * FROM category WHERE id ='" + id + "' ";
		ResultSet rs = connectDB.selectQuery(query);
		Category category = null;
		category = extractCategoryFromResultSet(rs);
		return category;
	}

	@Override
	public List<Category> getAll() {
		String query = "SELECT * FROM category";
		ResultSet rs = connectDB.selectQuery(query);
		List<Category> list = new ArrayList<>();
		try {
			list = extractListCategoryFromResultSet(rs);
			System.out.println(list.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	
	private List<Category> extractListCategoryFromResultSet(ResultSet rs) throws SQLException {
		List<Category> list = new ArrayList<>();
		int id;
		CategoryItem name;
		Category category = null;
		
		try {
			while (rs.next()) {
				id = rs.getInt("id");
				name =CategoryItem.valueOf(rs.getString("name"));
				category = new Category(id, name);
				list.add(category);

			}
			return list;
		} catch (SQLException ex) {
			return null;
		}

	}
	private Category extractCategoryFromResultSet(ResultSet rs)  {
		Category category = null;
		int id;
		CategoryItem name;
		
		
		try {
			if (rs.next()) {
				id = rs.getInt("id");
				name = CategoryItem.valueOf(rs.getString("name"));
				category = new Category(id, name);
				

			}
			return category;
		} catch (SQLException ex) {
			return null;
		}

	}
	@Override
	public Category get(CategoryItem name) {
		
		String query = "SELECT * FROM category WHERE name ='" + name + "' ";
		ResultSet rs = connectDB.selectQuery(query);
		Category category = null;
		category = extractCategoryFromResultSet(rs);
		return category;
		
	}

}
