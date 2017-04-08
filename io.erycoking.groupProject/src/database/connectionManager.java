package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionManager {
	
	private static connectionManager instance = null;
	
	private final String db = "jdbc:mysql://localhost/asset_management";
	private final String username = "root";
	private final String password = "king";
	
	private static Connection conn  = null;
	
	private connectionManager(){
		
	}
	
	public static connectionManager getInstance(){
		if(instance == null){
			instance = new connectionManager();
		}
		return instance;
	}
	private boolean openConnection() throws SQLException{
		try {
			conn = DriverManager.getConnection(db, username, password);
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public Connection getConnection() throws SQLException{
		if(conn == null){
			if(openConnection()){
				return conn;
			}else{
				return null;
			}
		}
		return conn;
	}
	
	public void closeConnection() throws SQLException{
		
		if(conn != null) {
			conn.close();
			conn = null;
		}
	}
}
