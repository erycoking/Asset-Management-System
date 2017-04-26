package afterLogin;

import java.net.URL;
import java.util.ResourceBundle;

import database.bean.user;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class afterLoginController implements Initializable{
	@FXML
	Label usrLabel = new Label();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void getUser(user usr){
		usrLabel.setText(usr.getName());
	}
}
