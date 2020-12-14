package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.ItemException;

public interface CopyItemService extends Service<CopyItem> {

	CopyItem addCopyItem(CopyItem copyItem) throws ItemException;
	Boolean isCopyAvailable(int copyId);
	Boolean isCopyReserved(int copyId);
	Boolean isCopyLoaned(int copyId);
	CopyItem getCopyById(long id) throws ItemException;
	CopyItem getCopyByBarcode(int barcode);
	List<CopyItem> getAllCopyItemsOfItem(int itemId);
	CopyItem makeCopyInActive(CopyItem copyItem);
	boolean removeCopy(CopyItem copyItem) throws ItemException;
	
}
