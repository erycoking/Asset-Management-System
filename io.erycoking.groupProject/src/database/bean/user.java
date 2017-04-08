package database.bean;

public class user {
	
	private int staff_id;
	private String name;
	private String username;
	private String password;
	private String department;
	private int tel_no;
	
	public user(int staff_id, String name, String username, String password, String department, int tel_no) {
		super();
		this.staff_id = staff_id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.department = department;
		this.tel_no = tel_no;
	}
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getTel_no() {
		return tel_no;
	}
	public void setTel_no(int tel_no) {
		this.tel_no = tel_no;
	}
}
