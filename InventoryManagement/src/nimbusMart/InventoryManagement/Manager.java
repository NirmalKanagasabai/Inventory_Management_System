package nimbusMart.InventoryManagement;

import java.util.List;

public class Manager {
	
	public static void main(String[] args) throws Exception {
		
		InventoryDAO inventoryDAO = new InventoryDAOImpl();
//
//		Item item = inventoryDAO.getItemDetails(5);
//		
//		System.out.println("Item ID: " + item.getItemID());
//		System.out.println("Item Name: " + item.getItemCategory());
//		System.out.println("Item Company: " + item.getItemCompany());
//		System.out.println("Item Category: " + item.getItemCategory());
//		System.out.println("Item Price: " + item.getItemPrice());
		
//		Item newItem = new Item();
//		newItem.setItemID(20);
//		newItem.setItemName("Home Hub");
//		newItem.setItemCompany("Bell");
//		newItem.setItemCategory("Modems & Routers");
//		newItem.setItemPrice(90);
//		
//		
//		inventoryDAO.addNewItem(newItem);
		
		List<Item> items = inventoryDAO.getAllItems();
		
		for (Item i : items) {
			System.out.println("--------------------------------");
			System.out.println("Item ID: " + i.getItemID());
			System.out.println("Item Name: " + i.getItemCategory());
			System.out.println("Item Company: " + i.getItemCompany());
			System.out.println("Item Category: " + i.getItemCategory());
			System.out.println("Item Price: " + i.getItemPrice());
			System.out.println("--------------------------------");
		}
		
	}

}
  