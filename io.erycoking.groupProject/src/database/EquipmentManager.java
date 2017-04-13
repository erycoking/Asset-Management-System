package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import database.bean.Equipment;

public class EquipmentManager {
	
	Equipment eq;
	PreparedStatement st = null;
	
	private String sql;
	
	public boolean insertItems(Equipment eq) throws SQLException, ClassNotFoundException{
		
		sql = "insert into equipments (equipement_id, " +
				"name, quantity, current_value, description, data_acquired) " +
				"values (?,?,?,?,?,?)";
		
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			
			Timestamp time = new Timestamp(eq.getDate_acquired().getTime());
			
			st.setString(1, eq.getEquip_id());
			st.setString(2, eq.getName());
			st.setInt(3, eq.getQuantity());
			st.setDouble(4, eq.getCurrent_value());
			st.setString(5, eq.getDescription());
			st.setTimestamp(6, time);
			
			int affected  = st.executeUpdate();
			if(affected == 1){
				return true;
			}else{
				return false;
			}
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return false;
		}finally{
			if(st != null)
				st.close();
		}
	}
	
	public Equipment[] displayInfo() throws SQLException, ClassNotFoundException{
		sql = "select * from equipments";
		ResultSet rs = null;
				
		try{
			Connection conn  = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery();
			
			rs.last();
			int nRows = rs.getRow();
			if(nRows == 0){
				System.out.println("No rows were found");
				return null;
			}else{
				
				Equipment eq[] = new Equipment[nRows];	
				rs.first();
				
				int i=1;
				
				while(rs.next()){
					eq[i].setEquip_id(rs.getString("equipment_id"));
					eq[i].setName(rs.getString("Name"));
					eq[i].setQuantity(rs.getInt("quantity"));
					eq[i].setCurrent_value(rs.getDouble("current_value"));
					eq[i].setDescription(rs.getString("description"));
					eq[i].setDate_acquired(rs.getDate("date_acquired"));
					
					i++;
				}
				
				return eq;
			}
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return null;
		}finally{
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
		}
	}
	
	public Equipment getRow(Equipment eq) throws SQLException, ClassNotFoundException{
		
		sql = "select * from equipments where 	equipment_id =  ?";
		ResultSet rs = null;
		
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, eq.getEquip_id());
			rs = st.executeQuery();
			if(rs.next()){			
				
				eq.setEquip_id(eq.getEquip_id());
				eq.setName(rs.getString("name"));
				eq.setQuantity(rs.getInt("quantity"));
				eq.setCurrent_value(rs.getInt("current_value"));
				eq.setDescription(rs.getString("description"));
				eq.setDate_acquired(rs.getDate("date_acquired"));
				
				return eq;
			}else{
				System.err.println("No rows were found");
				return null;
			}
			
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
	public boolean update(Equipment eq) throws SQLException, ClassNotFoundException{
		final String sql = "update equipments set equipment_id=?, name=?, quantity=?, current_value=?, description=?, data_acquired = ?";
		int affected = 0;
		
		Timestamp time = new Timestamp(eq.getDate_acquired().getTime());
	
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, eq.getEquip_id());
			st.setString(2, eq.getName());
			st.setInt(3, eq.getQuantity());
			st.setDouble(4, eq.getCurrent_value());
			st.setString(5, eq.getDescription());
			st.setTimestamp(6, time);
			
			affected  = st.executeUpdate();
			if(affected == 1){
				return true;
			}else{
				return false;
			}
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return false;
		}finally{
			if(st != null)
				st.close();
		}
	}
	public boolean delete(Equipment eq) throws SQLException, ClassNotFoundException{
		int affected = 0;
		sql = "delete from equipments where equipment_id = ? ";
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st.setString(1, eq.getEquip_id());
			st = conn.prepareStatement(sql);
			affected = st.executeUpdate();
			
			if(affected == 1)
				return true;
			else
				return false;
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return false;
		}finally{
			if(st != null)
				st.close();
		}
	}
}
