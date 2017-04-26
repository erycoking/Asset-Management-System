package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.bean.user;

public class userManager {
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	private String sql;
	
	public boolean insert(user usr) throws SQLException, ClassNotFoundException{
		
		sql = "INSERT INTO `asset_management`.`users`(`staff_id`,`Name`,`password`,`faculty`,`department`,`telephone_no`)VALUES(?,?,?,?,?,?)";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st  = conn.prepareStatement(sql);
			st.setString(1, usr.getStaff_id());
			st.setString(2, usr.getName());
			st.setString(3, usr.getPassword());
			st.setString(4, usr.getFaculty());
			st.setString(5, usr.getDepartment());
			st.setInt(6, usr.getTel_no());
			
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
	
	public user[] display() throws SQLException, ClassNotFoundException{
		sql = "select * from users";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql, ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			rs = st.executeQuery();
			rs.last();
			
			user usr[]  = new user[rs.getRow()];
			rs.first();
						
			int i = 1;
			
			while(rs.next()){
				usr[i].setStaff_id(rs.getString("staff_id"));
				usr[i].setName(rs.getString("Name"));
				usr[i].setPassword(rs.getString("password"));
				usr[i].setFaculty(rs.getString("faculty"));
				usr[i].setDepartment(rs.getString("department"));
				usr[i].setTel_no(rs.getInt("telephone_no"));
				i++;
			}
			
			return usr;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			if(st != null)
				st.close();
			if(rs != null)
				rs.close();
		}
	}
	
	public user getCurrentUser(user usr) throws SQLException, ClassNotFoundException{
		sql = "select * from users where name=?";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, usr.getName());
			rs = st.executeQuery();
			
			while(rs.next()){
				usr.setStaff_id(rs.getString("staff_id"));
				usr.setName(rs.getString("Name"));
				usr.setPassword(rs.getString("password"));
				usr.setFaculty(rs.getString("faculty"));
				usr.setDepartment(rs.getString("department"));
				usr.setTel_no(rs.getInt("telephone_no"));
			}
			
			return usr;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}finally{
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
		}
	}
	
	public boolean update(user usr) throws SQLException, ClassNotFoundException{
		
		sql = "update users set name=?, password=?, faculty=?, department=?, telephone_no=? where staff_id=?";
		
		try{
			conn = connectionManager.getInstance().getConnection();
			st  = conn.prepareStatement(sql);
			st.setString(1, usr.getName());
			st.setString(2, usr.getPassword());
			st.setString(3, usr.getFaculty());
			st.setString(4, usr.getDepartment());
			st.setInt(5, usr.getTel_no());
			st.setString(6, usr.getStaff_id());
			
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
	
	public boolean deleteItem(user usr) throws SQLException, ClassNotFoundException{
		
		sql = "delete from users where staff_id = ?";

		try{
			conn  = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, usr.getStaff_id());
			
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
