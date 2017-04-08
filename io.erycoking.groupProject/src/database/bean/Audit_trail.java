package database.bean;

import java.util.Date;

public class Audit_trail {
	
	private int staff_id;
	private Date time_in;
	private Date time_out;
	private int equipment_id;
	private int quantity;
	
	public Audit_trail(int staff_id, Date time_in, Date time_out, int equipment_id, int quantity) {
		super();
		this.staff_id = staff_id;
		this.time_in = time_in;
		this.time_out = time_out;
		this.equipment_id = equipment_id;
		this.quantity = quantity;
	}
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public Date getTime_in() {
		return time_in;
	}
	public void setTime_in(Date time_in) {
		this.time_in = time_in;
	}
	public Date getTime_out() {
		return time_out;
	}
	public void setTime_out(Date time_out) {
		this.time_out = time_out;
	}
	public int getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
