package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	private final static String URL ="jdbc:mysql://localhost:3306/online_shopping_db";
	private final static String USER ="exampleU";
	private final static String PASSWORD="exampleP";
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
}