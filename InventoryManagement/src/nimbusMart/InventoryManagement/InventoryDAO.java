package nimbusMart.InventoryManagement;

import java.util.List;

public interface InventoryDAO {
	
	Item getItemDetails(int id);
	void addNewItem(Item newItem);
	List<Item> getAllItems();
	
}
