package beforeLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import  beforeLogin.login2;
import beforeLogin.login2.*;
public class beforeLoginController implements Initializable{
	
	@FXML
	private void onLogin(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
                Functions1 fnctns =new Functions1();
		
		Parent root = loader.load(getClass().getResource("/beforeLogin/login2/Index.fxml").openStream());
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/UI/login.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Active Inventory");
		stage.show();
		
	}
	
	@FXML
	private void onRegister(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		Parent root = loader.load(getClass().getResource("/register/register.fxml").openStream());		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/register/register.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Active Inventory");
		stage.show();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
