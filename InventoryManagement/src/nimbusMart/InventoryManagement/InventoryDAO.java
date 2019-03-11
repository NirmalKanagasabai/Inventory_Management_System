package nimbusMart.InventoryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDAO {
	
	static String userName = null;
	static String password = null;
	static String url = null;
	static Connection connection = null;
	
	static {
		try {
			
			// The Time compliance needs to be added as ETC isn't recognized as a valid time zone
			url = "jdbc:mysql://localhost:3306/dummyDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			String userName = "<<insert_your_userName_here>>";
			String password = "<<insert_your_password_here>>";
			
			// For registering the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establishing the connection
			// The Connection interface is implemented using the getConnection() method of the DriverManager class
			connection = DriverManager.getConnection(url, userName, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Item getItemDetails(int id) {
		Item item = new Item();
		
		String selectQuery = "select * from inventory where itemID = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(selectQuery);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				item.setItemID(resultSet.getInt(1));
				item.setItemName(resultSet.getString(2));
				item.setItemCompany(resultSet.getString(3));
				item.setItemCategory(resultSet.getString(4));
				item.setItemPrice(resultSet.getLong(5));
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return item;
	}

	public static void addNewItem(Item newItem) {
		
		String insertQuery = "insert into inventory values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
			insertStatement.setInt(1, newItem.getItemID());
			insertStatement.setString(2,  newItem.getItemName());
			insertStatement.setString(3,  newItem.getItemCompany());
			insertStatement.setString(4,  newItem.getItemCategory());
			insertStatement.setLong(5,  newItem.getItemPrice());
			
			int count = insertStatement.executeUpdate();
			System.out.println(count + " no. of row(s) updated");
			
			insertStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
