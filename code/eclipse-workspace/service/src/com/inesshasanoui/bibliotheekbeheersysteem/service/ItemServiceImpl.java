package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.ItemException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.ItemDao;


public class ItemServiceImpl implements ItemService {
	ItemDao itemDao;
	CopyItemService copyItemService;

	public ItemServiceImpl(ItemDao itemDao,CopyItemService copyItemService) {
		super();
		this.itemDao = itemDao;
		this.copyItemService= copyItemService;
	}

	/*@Override
	public Item insert(Item item) throws ItemException {
		try {
			 item= itemDao.insert(item);
		} catch (DaoException e) {
			throw new ItemException("problem met retrieving data");
		}
		return item;
	}*/
	@Override
	public Item insert(Item item)  {
	
		return itemDao.insert(item);
				
	}


	@Override
	public Item update(Item item) {
		return itemDao.update(item);
	}

	@Override
	public boolean delete(Item item) {
		return itemDao.delete(item);

	}

	@Override
	public Item get(long id)  {
		return itemDao.get(id);
	}

	@Override
	public List<Item> getAll() {
		
		return itemDao.getAll();
	}

	/*@Override
	public Item addItem(Item item) throws ItemException {
		 if (item.getIsbn()==0) throw new ItemException("no entered ISBN number");
		Item itemDubbel = itemDao.getIsbn(item.getIsbn());
		if (itemDubbel!= null) { 
			throw new ItemException("item exist already");
			}
		
		try {
			item =itemDao.insert(item);
		} catch (DaoException e) {
			throw new ItemException("problem met retrieving data");
		}
		
		
	return item;
		
		}*/
	@Override
	public Item addItem(Item item) throws ItemException{
		 if (item.getIsbn()==0) throw new ItemException("no entered ISBN number");
		Item itemDubbel = itemDao.getIsbn(item.getIsbn());
		if (itemDubbel!= null) { 
			throw new ItemException("item exist already");
			}
		
		item =itemDao.insert(item);
		return item;
		
		}
	

	@Override
	public Item getItemById(long id) throws ItemException {
		if (id == 0) {
			throw new ItemException("No entered id ,vul id in");
		} else {
			Item item = itemDao.get(id);
			if (item == null)
				throw new ItemException("item doensn't exist in data base");
			return item;
		}
	}

	@Override
	public List<Item> getItemByCategory(int categoryId) throws ItemException {
		if (categoryId == 0) {
			throw new ItemException("No entered category,vul category in");
		}else {
				List<Item> items = itemDao.getItemByCategory(categoryId);
			if (items == null)
				throw new ItemException("No result found for item");
			return items;
		}
	}

	@Override
	public boolean removeItem(Item item) throws ItemException {
		int itemId= item.getId();
		Boolean remove = true;
		List<CopyItem> copies= copyItemService.getAllCopyItemsOfItem(itemId);
		for(int i=0;i<copies.size();i++){
			if (copyItemService.isCopyLoaned(copies.get(i).getId())) {
				remove = false;
				throw new ItemException("delete failed, copie is loaned for this item");
			
			}
			if (copyItemService.isCopyReserved(copies.get(i).getId())) {
				remove = false;
				throw new ItemException("delete failed, copie is reserved for this item");
			
			}
		}
		if (remove) {
			for(int i=0;i<copies.size();i++){
			 copyItemService.makeCopyInActive(copies.get(i)); 
			 System.out.println("delete met success" );
			}
			 itemDao.makeItemInActive(item);
			 // item with id is successufully removed!
		}
		return remove;
		
	}
}
