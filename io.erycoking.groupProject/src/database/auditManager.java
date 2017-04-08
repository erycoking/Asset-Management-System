package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class auditManager {
	
	private Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	private String sql;
	private int affected;
	
public boolean insert(String staff_id, String action, Timestamp timestamp, String equip_id, int quantity) throws SQLException{
		
		sql  = "insert into audit_trail(staff_id, Action, timestamp, equipment_id, quantity) values(?,?,?,?,?)";
		int affected = 0;
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, staff_id);
			st.setString(2, action);
			st.setTimestamp(3, timestamp);
			st.setString(4, equip_id);
			st.setInt(5, quantity);
			
			affected = st.executeUpdate();
			if(affected == 1)
				return true;
			else
				return false;
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			if (st != null)
				st.close();
		}
		
	}
	public boolean update(String staff_id, String action, Timestamp timestamp, String equip_id, int quantity) throws SQLException{
		
		sql = "update audit_trail set staff_id=?, action=?, timestamp=?, equipment_id=?, quantity=? where staff_id=?";
		int affected = 0;
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, staff_id);
			st.setString(2, action);
			st.setTimestamp(3, timestamp);
			st.setString(4, equip_id);
			st.setInt(5, quantity);
			st.setString(6, staff_id);
			
			affected = st.executeUpdate();
			if(affected == 1)
				return true;
			else
				return false;
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			if (st != null)
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
	
	public boolean deleteOldRecords() throws SQLException{
		
		sql = "delete from audit_trail where DATE_SUB(CURDATE(), INTERVAL, 1, YEAR) <= timestamp";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			affected = st.executeUpdate();
			
			if(affected > 0)
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
