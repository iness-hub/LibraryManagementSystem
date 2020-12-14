package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.ItemException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoException;

public interface ItemService extends Service<Item> {
	Item addItem(Item item) throws ItemException;
	Item getItemById(long id)throws ItemException;
	List<Item> getItemByCategory(int categoryId)throws ItemException;
	boolean removeItem(Item item) throws ItemException;
	// updateItem
}
