package register;

import beforeLogin.login2.Functions1;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class register extends Application{
    
	public void start(Stage stage2) throws IOException{
		Parent root2 = FXMLLoader.load(getClass().getResource("register.fxml"));
		Scene scene2 = new Scene(root2);
		scene2.getStylesheets().add(getClass().getResource("register.css").toExternalForm());
		stage2.setScene(scene2);
		stage2.setTitle("Register");
		stage2.show();
                Functions1 fnctns=new Functions1();
                fnctns.showimagesavailabe();
				
	}
	public static void main(String[] args){
		launch(args);
	}
}
