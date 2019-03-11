# Inventory Management System

This repository contains a simple inventory management system. It has the following functionalities:

- Adding a new item to the inventory
- Get the details of a specific item
- Get the details of all the items in the inventory

```java
Item getItemDetails (int id);

void addNewItem (Item newItem);

List<Item> getAllItems ();
```

## Implementation Details

- Programming Language: Java
- API: Java DataBase Connectivity (JDBC)
- Back-end (Relational Database): MySQL
- Design Pattern: Data Access Object (DAO)

-----------

## 7 Steps Involved in JDBC

**1) Importing Java package**

```java
import java.sql.*;
```
**2) Load and Register the Driver**

```java
Class.forName("com.mysql.jdbc.Driver");
```
**3) Establishing the connection to the database**

```java
connection = DriverManager.getConnection(url, userName, password);
```

**4) Preparing a Statement (or Prepared Statement or Callable Statement)**

```java
// Statement
String staticQuery = "select * from inventory";
Statement statement = connection.createStatement(); 

// Prepared Statement
String dynamicQuery = "select * from inventory where itemID = ?";
PreparedStatement preparedStatement = connection.prepareStatemnt(dynamicQuery);
preparedStatement.setInt(1, id);
```
**5. Executing the Statement**
```java
// Statement
ResultSet rs = statement.executeQuery(selectAllQuery);

// PreparedStatement
ResultSet resultSet = preparedStatement.executeQuery();
```
**6. Processing the Result**
```java
while (resultSet.next()) {
	item.setItemID(resultSet.getInt(1));
	item.setItemName(resultSet.getString(2));
	item.setItemCompany(resultSet.getString(3));
	item.setItemCategory(resultSet.getString(4));
	item.setItemPrice(resultSet.getLong(5));
}
```
**7. Terminating the Statement & Connection**
```java
statement.close();
preparedStatement.close();

connection.close();

// Note: Use try-catch block to capture the exceptions
```

## References
- [JDBC](https://www.oracle.com/technetwork/java/overview-141217.html)
- [MySQL](https://www.mysql.com)
- [DAO Design Pattern](https://www.oracle.com/technetwork/java/dataaccessobject-138824.html)
