package register;

import beforeLogin.login2.Functions1;
import database.bean.user;
import database.userManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import validate.validateUserInput;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class registerController implements Initializable {

    //variable to match the UI
	@FXML
	private TextField staff_id;
	@FXML
	private TextField name;
	@FXML
	private TextField usrname;
	@FXML
	private TextField pswd;
	@FXML
	private TextField cpswd;
	@FXML
	private TextField faculty;
	@FXML
	private TextField dep;
	@FXML
	private TextField phone_no;
	@FXML
	private TextField email;
	@FXML
	private Label err;

	String st_id, nm, username, passwd, confirm_passwd, fac, department, tel_no, mail;
	
	validateUserInput val = new validateUserInput();
	user usr = new user();
	userManager usrManager = new userManager();
	
	

	@FXML
	private void onSubmit(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
		err.setText("Errors");
		st_id = staff_id.getText();
		nm = name.getText();
		username = usrname.getText();
		passwd = pswd.getText();
		confirm_passwd = cpswd.getText();
		fac = faculty.getText();
		department = dep.getText();
		tel_no = phone_no.getText();
		mail = email.getText();

		if (st_id.isEmpty() || nm.isEmpty() || passwd.isEmpty() || fac.isEmpty() || department.isEmpty() || tel_no.isEmpty()) {
			err.setText("All values must be filled");
		}else{
			if (val.validateId(st_id)) {
				usr.setStaff_id(st_id);
				if (val.validateName(nm)) {
					usr.setName(nm);
					if(val.validateUsername(username)){
						usr.setUsername(username);
						if (passwd.equals(confirm_passwd)) {
							if (val.validatePassword(passwd) && val.validatePassword(confirm_passwd)) {
								usr.setPassword(passwd);
								if (val.validateFaculty(fac)) {
									usr.setFaculty(fac);
									if (val.validateDepartment(department)) {
										usr.setDepartment(department);
										if (val.validatePhonenum(tel_no)) {
											usr.setTel_no(Integer.parseInt(tel_no));
											if (val.validateEmail(mail)){
												usr.setEmail(mail);
                                                                                                usr.setRole("member");
												if (usrManager.insert(usr)) {
													Functions1 fun = new Functions1();
													fun.logingIn(usr);
												} else {
													err.setText("An error occurred while trying to register you.");
												}
											}else{
												err.setText("Invalid Email");
											}
										} else {
											err.setText("Phone number should contain only digits");
										}
									} else {
										err.setText("departments should have only characters and white spaces");
									}
								} else {
									err.setText("Faculty should contain only characters and spaces");
								}
							} else {
								err.setText("password should be longer than 8 characters");
							}
						} else {
							err.setText("passwords do not match. Try again.");
						}
					}else{
						err.setText("Invalid Username.\nUsername should contain only characters");
					}
				} else {
					err.setText("Name show contain only letters and white spaces, Try again.");
				}
			} else {
				err.setText("staff id should countain only letters , hypen, forward slash or period.Try again.");
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
