package register;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.border.EmptyBorder;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class registerController implements Initializable{
	
	@FXML private TextField staff_id;
	@FXML private TextField name;
	@FXML private TextField pswd;
	@FXML private TextField cpswd;
	@FXML private TextField dep;
	@FXML private TextField phone_no;
	@FXML private Label err;
	
	int tel_no;
	String st_id, nm, passwd, confirm_passwd, department;
	
	@FXML
	private void onSubmit(){
		
		try {
			st_id = staff_id.getText().toString();
			nm = name.getText().toString();
			passwd = pswd.getText().toString();
			confirm_passwd = cpswd.getText().toString();
			department = dep.getText().toString();
			tel_no = Integer.parseInt((phone_no.getText().toString()));
			
			if(st_id != null && st_id.length() < 255 && st_id.matches("[a-zA-Z]*[0-9]*[-/.]")){
				
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
