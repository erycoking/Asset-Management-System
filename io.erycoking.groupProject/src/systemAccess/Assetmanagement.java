 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemAccess;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author USERf
 */
public class Assetmanagement extends Application {
    
  Stage window;
  Button button,button2,button3,button4;
  Scene scene1,scene2;
    public static void main(String[] args) {
        launch(args);
    }
      @Override
    public void start(Stage primaryStage) {
      window=primaryStage;
      window.setTitle("Asset management system");
      
       GridPane grid=new GridPane();
       grid.setPadding(new Insets(10,10,10,10));
       grid.setVgap(8);
       grid.setHgap(10);
       
      //name label
      Label username=new Label("Username");
      username.getStyleClass().add("label");
      GridPane.setConstraints(username,0,0);
      
      //name input
      TextField nameInput=new TextField("Grace");
      GridPane.setConstraints(nameInput,1,0);
    
      //password label
      Label password=new Label("Password");
      GridPane.setConstraints(password,0,1);
      
      //password input
      TextField passInput=new TextField();
      GridPane.setConstraints(passInput,1,1);
      
      //Button log in
      button=new Button("Log in");
      GridPane.setConstraints(button,1,2);
    
      button.setOnAction(e->{
          String name=nameInput.getText();
      String passw=passInput.getText();
      
      //function login should be here then...
      if(name.equals("labtech")&& passw.equals("lab1234")){
       Booking.display();
      }
      else{ 
              Error.display();
      }
      });
      button2=new Button("Sign in");
      GridPane.setConstraints(button2,1,3);
      
      grid.getChildren().addAll(username,nameInput,password,passInput,button,button2);
      grid.setAlignment(Pos.CENTER);
      
   
      
       scene1=new Scene(grid,400,300);
     // scene1.getStylesheets().add("style.css");
       scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
      window.setScene(scene1);
      window.show();
    
    
}
}
