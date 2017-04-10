package database.bean;

import java.util.Date;

public class Equipment {
	
	private String equip_id;
	private String name;
	private int quantity;
	private double current_value;
	private String description;
	private Date date_acquired;
	
	public String getEquip_id() {
		return equip_id;
	}
	public void setEquip_id(String equip_id) {
		this.equip_id = equip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCurrent_value() {
		return current_value;
	}
	public void setCurrent_value(double current_value) {
		this.current_value = current_value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_acquired() {
		return date_acquired;
	}
	public void setDate_acquired(Date date_acquired) {
		this.date_acquired = date_acquired;
	}
}
