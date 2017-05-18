package UI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class login extends Application {
	
        //starting application
	public void start(Stage stage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		stage.setScene(scene);
                stage.setTitle("Active Inventory");
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
