package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.bean.Equipment;

public class EquipmentManager {
	
	Equipment eq;
	PreparedStatement st = null;
	
	private String sql;
	
	public boolean insertItems(String y, String name, int q, int cv, String des, Date dta) throws SQLException{
		
		sql = "insert into equipments (equipement_id, " +
				"name, quantity, current_value, description, data_acquired) " +
				"values (?,?,?,?,?,?)";
		
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			
			st.setString(1, y);
			st.setString(2, name);
			st.setInt(3, q);
			st.setInt(4, cv);
			st.setString(5, des);
			st.setDate(6, dta);
			
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
	
	public void displayInfo() throws SQLException{
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
			}else{
				rs.first();
				System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %s\n", "assetManufactureYear",
						"assetDepartmentNo", "itemDescription", "status", "unit", "vendorDatePurchase", "initialCost",
						"currentValue", "depriciation", "lastCalibrationDate", "RepairAndMaintainanceCost");
				while(rs.next()){
					System.out.printf("%20d, %20d, %20s, %20s, %20d, %20s, %18.2f, %18.2f, %18.2f, %20s, %18.2f", rs.getInt("assetManufactureYear"),
							rs.getInt("assetDepartmentNo"),rs.getString("itemDescription"), rs.getString("status"), rs.getInt("unit"), rs.getDate("vendorDatePurchase"),
							rs.getDouble("initialCost"),rs.getDouble("currentValue"),rs.getDouble("depriciation"), rs.getDate("lastCalibrationDate"),
							rs.getDouble("RepairAndMaintainanceCost"));
					System.out.println();
				}
			}
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}finally{
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
		}
	}
	
	public void getRow(String equip_id) throws SQLException{
		
		sql = "select * from equipments where 	equipment_id =  ?";
		ResultSet rs = null;
		
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, equip_id);
			rs = st.executeQuery();
			if(rs.next()){			
				eq.setEquip_id(equip_id);
				eq.setName(rs.getString("name"));
				eq.setQuantity(rs.getInt("quantity"));
				eq.setCurrent_value(rs.getInt("current_value"));
				eq.setDescription(rs.getString("description"));
				eq.setDate_acquired(rs.getDate("date_acquired"));
				
				System.out.println(eq);
			}else{
				System.err.println("No rows were found");
			}
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally{
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
		}
	}
	public boolean update(String y, String name, int q, int cv, String des, Date dta) throws SQLException{
		final String sql = "update equipments set equipment_id=?, name=?, quantity=?, current_value=?, description=?, data_acquired = ?";
		int affected = 0;
	
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, y);
			st.setString(2, name);
			st.setInt(3, q);
			st.setInt(4, cv);
			st.setString(5, des);
			st.setDate(6, dta);
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
	public boolean delete(String value) throws SQLException{
		int affected = 0;
		sql = "delete from equipments where equipment_id = ? ";
		try{
			Connection conn = connectionManager.getInstance().getConnection();
			st.setString(1, value);
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
