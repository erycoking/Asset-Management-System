package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userManager {
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	private String sql;
	
	public boolean insert(String staff_id, String name, String username, String password, String department, int tel_no) throws SQLException{
		
		sql = "INSERT INTO `asset_management`.`users`(`staff_id`,`Name`,`username`,`password`,`department`,`telephone_no`)VALUES(?,?,?,?,?,?)";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st  = conn.prepareStatement(sql);
			st.setString(1, staff_id);
			st.setString(2, name);
			st.setString(3, username);
			st.setString(4, password);
			st.setString(5, department);
			st.setInt(6, tel_no);
			
			int affected = st.executeUpdate();
			if(affected == 1)
				return true;
			else
				return false;
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			if(st != null)
				st.close();
		}
	}
	
	public void display() throws SQLException{
		sql = "select * from users";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql, ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			rs = st.executeQuery();
			
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			if(st != null)
				st.close();
			if(rs != null)
				rs.close();
		}
	}
	
	public boolean update(String staff_id, String name, String username, String password, String department, int tel_no) throws SQLException{
		
		sql = "update users set name=?, username=?, password=?, department=?, telephone_no=? where staff_id=?";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st  = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, username);
			st.setString(3, password);
			st.setString(4, department);
			st.setInt(5, tel_no);
			st.setString(6, staff_id);
			
			int affected = st.executeUpdate();
			if(affected == 1)
				return true;
			else
				return false;
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			if(st != null)
				st.close();
		}
	}
	
	public boolean deleteItem(String staff_id) throws SQLException{
		
		sql = "delete from users where staff_id = ?";

		try{
			conn  = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, staff_id);
			
			int affected  = st.executeUpdate();
			if(affected == 1)
				return true;
			else
				return false;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			if(st != null)
				st.close();
		}
	}

}
