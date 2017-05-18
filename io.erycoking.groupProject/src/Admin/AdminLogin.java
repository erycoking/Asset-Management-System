/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import systemAccess.Booking;

/**
 *
 * @author Waithera
 */
public class AdminLogin extends Application {
  Stage window;  
   
  
    public static void main(String[] args) {
        launch(args);
    }
     @Override
    public void start(Stage primaryStage) {
     window=primaryStage;
      window.setTitle("Admin log in");
        
      BorderPane border=new BorderPane();
     
      Button add=new Button("Add Tech");
      
      Button delete=new Button("Delete tech");
      
      Button view=new Button("View Button");
      
      Button update=new Button("Update");
      
      
      VBox layout=new VBox(10);
      layout.getChildren().addAll(add,delete,view,update);
      layout.setAlignment(Pos.CENTER);
    
      Button back=new Button("Back");
     Button logout=new Button("Logout");
     
     HBox hbox=new HBox(10);
     hbox.getChildren().addAll(back,logout);
     hbox.setAlignment(Pos.BOTTOM_RIGHT);
     
     border.setCenter(layout);
     border.setBottom(hbox);
      
   
      Scene scene=new Scene(border,400,300);
      scene.getStylesheets().addAll(Booking.class.getResource("style.css").toExternalForm());
      
      window.setScene(scene);
     window.show(); 
      
    }

    
}
