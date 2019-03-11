package nimbusMart.InventoryManagement;

import java.sql.*;


public class Manager {
	
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/dummyDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		String userName = "<<insert_your_userName_here>>";
		String password = "<<insert_your_password_here>>";
		String selectQuery = "select * from inventory where itemCategory = 'Speakers'";
		String insertQuery = "insert into inventory values(13, 'Deck', 'Sol Republic', 'Speakers', 150)";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectQuery);
		
		System.out.println("Item ID" +  " " + "Item Name" + " " + "Item Company" + "  " + "Item Category" + " " + "Item Price");
		
		while (resultSet.next()) {

			int itemID = resultSet.getInt(1);
			String itemName = resultSet.getString(2);
			String itemCompany = resultSet.getString(3);
			String itemCategory = resultSet.getString(4);
			long itemPrice = resultSet.getLong(5);
			
			
			System.out.println(itemID +  " " + itemName + "    " + itemCompany + "    " + itemCategory + "     " + itemPrice);
		}
		
		
		int count = statement.executeUpdate(insertQuery);
		System.out.println(count + " row(s) affected");
		
		statement.close();
		connection.close();
	}

}
  