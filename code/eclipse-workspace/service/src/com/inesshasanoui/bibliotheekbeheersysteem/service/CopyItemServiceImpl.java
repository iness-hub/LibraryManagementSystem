package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyState;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.ItemException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.CopyItemDao;



public class CopyItemServiceImpl implements CopyItemService {
	CopyItemDao copyItemDao;
	
	
	public CopyItemServiceImpl(CopyItemDao copyItemDao) {
		this.copyItemDao = copyItemDao;
	}

	@Override
	public CopyItem insert(CopyItem copyItem) {
		return copyItemDao.insert(copyItem);
	}

	@Override
	public CopyItem update(CopyItem copyItem) {
		return copyItemDao.update(copyItem);

	}

	@Override
	public boolean delete(CopyItem copyItem) {
		return copyItemDao.delete(copyItem);

	}

	@Override
	public CopyItem get(long id) {
		return copyItemDao.get(id);
		
	}
	@Override
	public CopyItem getCopyById(long id) throws ItemException {
		if(id==0) throw new  ItemException("no entered Id number");
		return copyItemDao.get(id);
		
	}

	@Override
	public List<CopyItem> getAll() {
		
		return copyItemDao.getAll();
	}

	@Override
	public CopyItem addCopyItem(CopyItem copyItem) throws ItemException {
		if (getCopyByBarcode(copyItem.getBarcode())!=null) {
			throw new ItemException("barcode exist already");
		}
		copyItem.setState(CopyState.available.toString());
		copyItemDao.insert(copyItem);
		return null;
	}
	
	@Override
	public CopyItem makeCopyInActive(CopyItem copyItem) {
		
		return copyItemDao.makeCopyInActive(copyItem);
	}
	
	@Override
	public boolean removeCopy(CopyItem copyItem) throws ItemException {
		if (copyItem.getId()==0) { throw new ItemException("No copy to delete");}
		
		return !copyItemDao.makeCopyInActive(copyItem).getActive();
	}
	@Override
	public Boolean isCopyAvailable(int copyId) {
			String state = copyItemDao.get(copyId).getState().toString();
			return state.equals(CopyState.available.toString());
	}

	@Override
	public Boolean isCopyReserved(int copyId) {
		String state = copyItemDao.get(copyId).getState().toString();
		return state.equals(CopyState.reserved.toString());
	}
	@Override
	public Boolean isCopyLoaned(int copyId) {
		String state = copyItemDao.get(copyId).getState().toString();
		return state.equals(CopyState.loaned.toString());
	}


	@Override
	public List<CopyItem> getAllCopyItemsOfItem(int itemId) {
		
		return copyItemDao.getAllCopyItemsForItem(itemId);
	}

	@Override
	public CopyItem getCopyByBarcode(int barcode) {
		return copyItemDao.getCopyByBarcode(barcode);
	}

	


}
