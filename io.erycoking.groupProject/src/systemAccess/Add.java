/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemAccess;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static assetmanagement.connect.getConnection;

public class Add  {
   
 
 
 
 private PreparedStatement pst;
    private static ResultSet rs;
    private static Statement st;
    private static Connection c;
    TextField callId,name,quantity,cost; 
    public static void display() throws SQLException{
        
      Stage window=new Stage();
        window.setTitle("Add equipment");
        
        GridPane grid=new GridPane();
       grid.setPadding(new Insets(10,10,10,10));
       grid.setVgap(8);
       grid.setHgap(10);
       
        Label callId=new Label("CallID");
       GridPane.setConstraints(callId,0,0);
       
       TextField callInput=new TextField();
       GridPane.setConstraints(callInput,1,0);
               
       
        Label name=new Label("Name");
       GridPane.setConstraints(name,0,1);
       
       TextField nameInput=new TextField();
       GridPane.setConstraints(nameInput,1,1);
       
       
       Label cost=new Label("Quantity");
       GridPane.setConstraints(cost,0,2);
       
       TextField costInput=new TextField();
       GridPane.setConstraints(costInput,1,2);
       
       Label quantity=new Label("Cost");
       GridPane.setConstraints(quantity, 0,3);
       
       TextField quantityInput=new TextField();
       GridPane.setConstraints(quantityInput,1,3);
       
      
       
       Button button=new Button("Submit");
      // button.setOnAction(e -> submit());
       GridPane.setConstraints(button,1,5);
       
      
      // GridPane.setConstraints(button1,2,6);
      
       grid.getChildren().addAll(callId,callInput,name,nameInput,cost,costInput,quantity,quantityInput,button );
     //The table
       
       TableView<Equipment> table;
       table=new TableView<>();
      
      
       final ObservableList<Equipment> data=FXCollections.observableArrayList();
       //callId column
       TableColumn<Equipment,Integer>callColumn=new TableColumn<>("CallId");
       callColumn.setMinWidth(50);
       callColumn.setCellValueFactory(new PropertyValueFactory("callId"));
//name column
       TableColumn<Equipment,String>nameColumn=new TableColumn<>("Name");
       nameColumn.setMinWidth(100);
       nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
    
       //Cost column
       TableColumn<Equipment,Integer>costColumn=new TableColumn<>("Cost");
     costColumn.setMinWidth(50);
     costColumn.setCellValueFactory(new PropertyValueFactory("cost")); 
     //Equipment details
     TableColumn<Equipment,String>eqpDetails=new TableColumn<>("Equipment details");
     eqpDetails.setMinWidth(200);
     eqpDetails.setCellValueFactory(new PropertyValueFactory("eqpDetails"));
      //quantity column
     TableColumn<Equipment,Integer>quantityColumn=new TableColumn<>("Quantity");
     quantityColumn.setMinWidth(100);
     quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
      //Equipment details
     TableColumn<Equipment,String>eqpCategory=new TableColumn<>("Equipment Category");
     eqpDetails.setMinWidth(100);
     eqpDetails.setCellValueFactory(new PropertyValueFactory("eqpCategory"));
     
     //Setting data items
       table.setItems(getData());
       
       table.getColumns().addAll(callColumn,nameColumn,costColumn,eqpDetails,quantityColumn,eqpCategory);
       Button back=new Button("Back");
       
      back.setOnAction(e-> 
          
             Booking.display());
      
  
     HBox layout=new HBox();
     layout.setPadding(new Insets(10,10,10,10));
     layout.setSpacing(10);
     layout.getChildren().addAll(grid,table,back);
     
     
       Scene scene=new Scene(layout,1368,660);
        scene.getStylesheets().addAll(Add.class.getResource("style.css").toExternalForm());
       window.setScene(scene);
       window.show();
    } 
              
 public static ObservableList<Equipment> getData() throws SQLException{
     connect con=new connect();
    
       ObservableList<Equipment> data=FXCollections.observableArrayList();
       
      // try{
            String query="select eqpID,eqpname,eqpcost,eqpdetails,quantity,eqpcategory from equipments";
          st=connect.getConnection().createStatement();
            rs=st.executeQuery(query);
           System.out.println("Records from database");
            while(rs.next()){
              Integer callid=rs.getInt("eqpID");
                String n=rs.getString("eqpname");
                Integer cs=rs.getInt("eqpcost");
                String eqd=rs.getString("eqpDetails");
                Integer q=rs.getInt("quantity");
                String eqc=rs.getString("eqpCategory");
                
               data.add(new Equipment(callid,n,cs,eqd,q,eqc));
             
             // System.out.println("CallID: "+callid+"  "+"name: "+name+"  "+"quantity: "+quantity+ "  "+"cost: "+cost);
        //    }
       // }
       // catch(Exception e){
         //   System.out.println("Error");
        }
return data;
      
        }
} 
    

