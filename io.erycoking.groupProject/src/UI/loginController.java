package UI;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController implements Initializable {
	@FXML
	private TextField name;
	@FXML
	private TextField passwd;
	
	@FXML
	private void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
		user usr = new user();
		user returned_usr = new user();
		usr.setName(name.getText());
		usr.setPassword(passwd.getText());
		
		userManager usrMan = new userManager();
		returned_usr = usrMan.getCurrentUser(usr);
		
		if(name.getText() == returned_usr.getName() && passwd.getText() == returned_usr.getPassword()){
			((Node)event.getSource()).getScene().getWindow().hide();
			
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			
			Parent root = loader.load(getClass().getResource("/afterLogin/afterLogin.fxml").openStream());
			afterLoginController aft = (afterLoginController)loader.getController();
			aft.getUser(returned_usr);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/afterLogin/afterLogin.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Active inventory");
			stage.show();
			
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
