package register;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.border.EmptyBorder;

import database.userManager;
import database.bean.user;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import validate.validateUserInput;

public class registerController implements Initializable{
	
	@FXML private TextField staff_id;
	@FXML private TextField name;
	@FXML private TextField pswd;
	@FXML private TextField cpswd;
	@FXML private TextField dep;
	@FXML private TextField phone_no;
	@FXML private Label err;
	
	String st_id, nm, passwd, confirm_passwd, department, tel_no;
	validateUserInput val = new validateUserInput();
	user usr = new user();
	userManager usrManager = new userManager();
	
	@FXML
	private void onSubmit(){
		
		try {
			st_id = staff_id.getText().toString();
			nm = name.getText().toString();
			passwd = pswd.getText().toString();
			confirm_passwd = cpswd.getText().toString();
			department = dep.getText().toString();
			tel_no = phone_no.getText().toString();
			
			if(val.validateId(st_id)){
				usr.setStaff_id(st_id);
				if(val.validateUsername(nm)){
					usr.setName(nm);
					if(passwd.equals(confirm_passwd)){
						if(val.validatePassword(passwd) && val.validatePassword(confirm_passwd)){
							usr.setPassword(passwd);
							if(val.validateDepartment(department)){
								usr.setDepartment(department);
								if(val.validatePhonenum(tel_no)){
									usr.setTel_no(Integer.parseInt(tel_no));									
									if(usrManager.insert(usr)){
										
									}else{
										err.setText("An error occurred while trying to register you.");
									}								
								}
							}else{
								err.setText("departments should have only characters and white spaces");
							}
						}else{
							err.setText("password should be longer than 8 characters");
						}
					}else{
						err.setText("passwords do not match. Try again.");
					}
				}else{
					err.setText("Name show contain only letters and white spaces, Try again.");
				}
			}else{
				err.setText("staff id should countain only letters , hypen, forward slash or period.Try again.");
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			err.setText("Enter the values in correct format");
		} catch (Exception e) {
			e.printStackTrace();
			err.setText(e.getMessage());			
		}
		
	}
;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
