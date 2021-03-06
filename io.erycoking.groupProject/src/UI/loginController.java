package UI;

import beforeLogin.login2.Functions1;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.bean.user;
import database.userManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import validate.validateUserInput;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    private JFXTextField id;
    @FXML
    private JFXPasswordField passwd;
    @FXML
    private Label err;
    
    validateUserInput v = new validateUserInput();
	
	@FXML
	private void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException, Exception{
                String inputId = id.getText();
                String inputPwd = passwd.getText();
                if(!(inputId.isEmpty())){
                    if(!(inputPwd.isEmpty())){
                        if(v.validateId(inputId)){
                            if(v.validatePassword(inputPwd)){                                
                                //we should have worked with userId incase they have the same Name??
                                userManager usrMan = new userManager();
                                user returned_usr = usrMan.getCurrentUser(inputId, inputPwd);
                                if(returned_usr != null){

                                    ((Node)event.getSource()).getScene().getWindow().hide();

                                    Functions1 fun = new Functions1();
                                    fun.logingIn(returned_usr);

                                }else{err.setText("user doesn't exist");}
                            }else{err.setText("invalid password");}
                        }else{ err.setText("invalid staff ID");}                     
                    }else{err.setText("password cannot be empty");}
                }else{err.setText("username cannot be empty");}
	}
        
        @FXML
        private void register(ActionEvent event) throws IOException{
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
