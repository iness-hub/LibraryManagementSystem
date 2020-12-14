package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;

public interface ItemDao extends CrudDao<Item> {
	Item getIsbn(int isbn);
	List<Item> getItemByCategory(int categoryId);
	Item makeItemInActive(Item item);
}
