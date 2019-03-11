package nimbusMart.InventoryManagement;

public class Manager {
	
	public static void main(String[] args) throws Exception {

		Item item = InventoryDAO.getItemDetails(5);
		
		System.out.println("Item ID: " + item.getItemID());
		System.out.println("Item Name: " + item.getItemCategory());
		System.out.println("Item Company: " + item.getItemCompany());
		System.out.println("Item Category: " + item.getItemCategory());
		System.out.println("Item Price: " + item.getItemPrice());
	}

}
  