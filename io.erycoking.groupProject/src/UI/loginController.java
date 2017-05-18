package UI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import systemAccess.Booking;

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
		//we should have worked with userId incase they have the same Name??
		userManager usrMan = new userManager();
		returned_usr = usrMan.getCurrentUser(usr);
		
		if(name.getText() == returned_usr.getName() && passwd.getText() == returned_usr.getPassword()){
                    if(returned_usr.getRole().equals("member")){
			((Node)event.getSource()).getScene().getWindow().hide();
                        
                        Booking.display();
                        
                    }else if(returned_usr.getRole().equals("labtech")){
                        
                        ((Node)event.getSource()).getScene().getWindow().hide();
			
                    }else if(returned_usr.getRole().equals("admin")){
                        
                        ((Node)event.getSource()).getScene().getWindow().hide();
                    }
		}
	}
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
