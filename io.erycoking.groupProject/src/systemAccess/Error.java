/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemAccess;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
public class Error {
    public static void display(){
        
    Stage window=new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Error");
    window.setMinWidth(300);
    
    Label label=new Label();
        label.setText("Not a valid username or password");
        
   StackPane layout=new StackPane(label);
   Scene scene=new Scene(layout);
   
   window.setScene(scene);
   window.showAndWait();
    
    
    
}
}