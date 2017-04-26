package beforeLogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class beforeLogin extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("beforeLogin.fxml"));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("beforeLogin.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Active Inventory");
		stage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
