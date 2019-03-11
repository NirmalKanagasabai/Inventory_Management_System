package nimbusMart.InventoryManagement;

import java.sql.*;


public class Manager {
	
	public static void main(String[] args) throws Exception {
		
		// The Time compliance needs to be added as ETC isn't recognized as a valid time zone
		String url = "jdbc:mysql://localhost:3306/dummyDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		String userName = "<<insert_your_userName_here>>";
		String password = "<<insert_your_password_here>>";
		
		// Simple select and insert queries [static]
		String selectQuery = "select * from inventory where itemCategory = 'Speakers'";
		String insertQuery = "insert into inventory values(13, 'Deck', 'Sol Republic', 'Speakers', 150)";
		
		// For registering the driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// Establishing the connection
		// The Connection interface is implemented using the getConnection() method of the DriverManager class
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		// Simple statement
		Statement statement = connection.createStatement();
		
		// Executing the statement
		ResultSet resultSet = statement.executeQuery(selectQuery);
		
		System.out.println("Item ID" +  " " + "Item Name" + " " + "Item Company" + "  " + "Item Category" + " " + "Item Price");
		
		// Iterating over the result set and printing all the rows 
		while (resultSet.next()) {

			int itemID = resultSet.getInt(1); // The number in the brace corresponds to the column number that is to be retrieved
			String itemName = resultSet.getString(2);
			String itemCompany = resultSet.getString(3);
			String itemCategory = resultSet.getString(4);
			long itemPrice = resultSet.getLong(5);
			
			System.out.println(itemID +  " " + itemName + "    " + itemCompany + "    " + itemCategory + "     " + itemPrice);
		}
		
		// Executing a simple insert query 
		// Note the usage of statement.executeUpdate() method instead of statement.executeQuery() method
		// The executeUpdate() method, unlike executeQuery() returns only the count of number of rows that are affected by executing the query. 
		int count = statement.executeUpdate(insertQuery);
		System.out.println(count + " row(s) affected");
		
		// Dynamically inserting values into the query [Not so elegant way]
		int newItemID = 14;
		String newItemName = "Surface Pro";
		String newItemCompany = "Microsoft";
		String newItemCategory = "Laptops";
		long newItemPrice = 2000;
		
		// Though achievable, it is very hard to ensure that all the brackets, commas and double quotes are properly created.
		String newInsertQuery = "insert into inventory values(" + newItemID + ", '" + newItemName + "', '" + newItemCompany + "', '" + newItemCategory + "', " + newItemPrice + ");";
		
		int count2 = statement.executeUpdate(newInsertQuery);	
		System.out.println(count2 + " row(s) affected");
		
		int newItemID2 = 15;
		String newItemName2 = "JIB Wireless";
		String newItemCompany2 = "SkullCandy";
		String newItemCategory2 = "Earphones";
		long newItemPrice2 = 200;
		
		String dynamicInsertQuery = "insert into inventory values(?, ?, ?, ?, ?)";
		
		// Elegant solution: Use Prepared Statements
		PreparedStatement preparedStatement = connection.prepareStatement(dynamicInsertQuery);
		preparedStatement.setInt(1, newItemID2);
		preparedStatement.setString(2, newItemName2);
		preparedStatement.setString(3, newItemCompany2);
		preparedStatement.setString(4, newItemCategory2);
		preparedStatement.setLong(5, newItemPrice2);

		int count3 = preparedStatement.executeUpdate();
		System.out.println(count3 + " row(s) affected");

		// Very important to terminate both the statement and the DB connection requests
		statement.close();
		connection.close();
	}

}
  