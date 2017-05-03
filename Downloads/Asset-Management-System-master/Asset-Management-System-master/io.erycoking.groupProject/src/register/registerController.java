package register;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import afterLogin.afterLoginController;
import database.userManager;
import database.bean.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import validate.validateUserInput;

public class registerController implements Initializable {

	@FXML
	private TextField staff_id;
	@FXML
	private TextField name;
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
	private Label err;

	String st_id, nm, passwd, confirm_passwd, fac, department, tel_no;
	
	validateUserInput val = new validateUserInput();
	user usr = new user();
	userManager usrManager = new userManager();
	
	

	@FXML
	private void onSubmit(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
		err.setText("Errors");
		st_id = staff_id.getText();
		nm = name.getText();
		passwd = pswd.getText();
		confirm_passwd = cpswd.getText();
		fac = faculty.getText();
		department = dep.getText();
		tel_no = phone_no.getText();
		
		if (st_id.isEmpty() || nm.isEmpty() || passwd.isEmpty() || fac.isEmpty() || department.isEmpty() || tel_no.isEmpty()) {
			err.setText("All values must be filled");
		}else{
			if (val.validateId(st_id)) {
				usr.setStaff_id(st_id);
				if (val.validateUsername(nm)) {
					usr.setName(nm);
					if (passwd.equals(confirm_passwd)) {
						if (val.validatePassword(passwd) && val.validatePassword(confirm_passwd)) {
							usr.setPassword(passwd);
							if (val.validateFaculty(fac)) {
								usr.setFaculty(fac);
								if (val.validateDepartment(department)) {
									usr.setDepartment(department);
									if (val.validatePhonenum(tel_no)) {
										usr.setTel_no(Integer.parseInt(tel_no));
										if (usrManager.insert(usr)) {

											((Node) event.getSource()).getScene().getWindow().hide();

											Stage stage = new Stage();
											FXMLLoader loader = new FXMLLoader();
											//loader.setLocation(getClass().getResource("afterLogin/afterLogin.fxml"));
											Pane root = loader.load(getClass().getResource("/afterLogin/afterLogin.fxml").openStream());

											afterLoginController aft = (afterLoginController) loader.getController();
											aft.getUser(usr);

											Scene scene = new Scene(root);
											scene.getStylesheets().add(getClass().getResource("afterLogin.css").toExternalForm());
											stage.setScene(scene);
											stage.setTitle("Active inventory");
											stage.show();

										} else {
											err.setText("An error occurred while trying to register you.");
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
