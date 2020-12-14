package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;

public interface CopyItemDao extends CrudDao<CopyItem>  {
	 //CopyItem extractCopyItemFromResultSet(ResultSet rs) throws SQLException;
	List<CopyItem> getAllCopyItemsForItem(int itemId);
	List<CopyItem> getAllAvailableCopyItemsForItem(int itemId);
	CopyItem makeCopyInActive(CopyItem copyItem);
	CopyItem getCopyByBarcode(int barcode);
}
