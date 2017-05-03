package register;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class register extends Application{
	public void start(Stage stage) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("register.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Register");
		stage.show();
				
	}
	public static void main(String[] args){
		launch(args);
	}
}
