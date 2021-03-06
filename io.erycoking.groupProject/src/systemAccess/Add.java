/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemAccess;
import database.connectionManager;
import groups.UIgroup;
import java.io.IOException;
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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

public class Add  {
   
 
 
 
 private PreparedStatement pst;
    private static ResultSet rs;
    private static Statement st;
    private static Connection c;
   public static TextField nameInput,costInput,detInput,quantityInput,catInput,date,dateInput; 
   public static TableView<Equipment>table;
    
    public static void display() throws SQLException, ClassNotFoundException{
        
      Stage window=new Stage();
        window.setTitle("Add equipment");
        
        GridPane grid=new GridPane();
       grid.setPadding(new Insets(10,10,10,10));
       grid.setVgap(8);
       grid.setHgap(10);
       
        
       
        Label name=new Label("Name");
       GridPane.setConstraints(name,0,1);
       
       nameInput=new TextField();
       GridPane.setConstraints(nameInput,1,1);
       
       Label cost=new Label("Cost");
       GridPane.setConstraints(cost,0,2);
       
      costInput=new TextField();
       GridPane.setConstraints(costInput,1,2);
       
       Label equipmentDet=new Label("Equipment details");
       GridPane.setConstraints(equipmentDet,0,3);
       
       detInput=new TextField();
       GridPane.setConstraints(detInput,1,3);
       
       Label quantity=new Label("Quantity");
       GridPane.setConstraints(quantity,0,4);
       
       quantityInput=new TextField();
       GridPane.setConstraints(quantityInput,1,4);
       
       
       Label equipmentCat=new Label("Equipment Category");
       GridPane.setConstraints(equipmentCat,0,5);
       
       catInput=new TextField();
       GridPane.setConstraints(catInput,1,5);
       
       Label dateL=new Label("Date");
       GridPane.setConstraints(dateL,0,6);
       
       dateInput=new TextField();
       GridPane.setConstraints(dateInput,1,6);
       
       Button button=new Button("Submit");
       button.setOnAction(e -> {
           Add add=new Add();
          try {
              add.submitClicked();
          } catch (SQLException ex){
              Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              table.setItems(getData());
          } catch (SQLException ex) {
              Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
          }
   
  
      });
       GridPane.setConstraints(button,1,10);
       
      
      // GridPane.setConstraints(button1,2,6);
      Button back=new Button("Back");
      GridPane.setConstraints(back,1,11);
      
       grid.getChildren().addAll(name,nameInput,cost,costInput,equipmentDet,detInput,quantity,quantityInput,equipmentCat,catInput,dateL,dateInput,button,back);
     //The table
       
      // TableView<Equipment> table;
       
       
       
       
       
       table=new TableView<>();
      
      
       final ObservableList<Equipment> data=FXCollections.observableArrayList();
       //callId column
       TableColumn<Equipment,Integer>callColumn=new TableColumn<>("CallId");
       callColumn.setMinWidth(50);
       callColumn.setCellValueFactory(new PropertyValueFactory("callId"));
//name column
       TableColumn<Equipment,String>nameColumn=new TableColumn<>("Name");
       nameColumn.setMinWidth(200);
       nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
    
       //Cost column
       TableColumn<Equipment,Integer>costColumn=new TableColumn<>("Cost");
     costColumn.setMinWidth(100);
     costColumn.setCellValueFactory(new PropertyValueFactory("cost")); 
     //Equipment details
     TableColumn<Equipment,String>eqpDetails=new TableColumn<>("Equipment details");
     eqpDetails.setMinWidth(300);
     eqpDetails.setCellValueFactory(new PropertyValueFactory("eqpDetails"));
      //quantity column
     TableColumn<Equipment,Integer>quantityColumn=new TableColumn<>("Quantity");
     quantityColumn.setMinWidth(100);
     quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
      //Equipment details
     TableColumn<Equipment,String>eqpCategory=new TableColumn<>("Equipment Category");
     eqpCategory.setMinWidth(200);
     eqpCategory.setCellValueFactory(new PropertyValueFactory("eqpCategory"));
     //Date Created
  TableColumn<Equipment,String>dateCreated=new TableColumn<>("Date");
  dateCreated.setMaxWidth(100);
  dateCreated.setCellValueFactory(new PropertyValueFactory("dateCreated"));
   
     //Setting data items
   //table.minWidth(1000);
       table.setItems(getData());
       
       table.getColumns().addAll(callColumn,nameColumn,costColumn,eqpDetails,quantityColumn,eqpCategory,dateCreated);
      // Button back=new Button("Back");
       
      back.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Stage stage = new Stage();
               ((Node)event.getSource()).getScene().getWindow().hide();
               FXMLLoader loader = new FXMLLoader();
               Parent root;
               try {
                    root = loader.load(getClass().getResource("/technicians/Pendingbookings.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("/technicians/pendingbookings.css").toExternalForm());
                    stage.setScene(scene);
                   // stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/equipment2.jpg")));
                    stage.setTitle("Active Inventory");
                    stage.show();
               } catch (IOException ex) {
                   Logger.getLogger(UIgroup.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
      
  
     HBox layout=new HBox();
     layout.setPadding(new Insets(10,10,10,10));
     layout.setSpacing(10);
     layout.getChildren().addAll(grid,table);
     
     
       Scene scene=new Scene(layout,1300,650);
        scene.getStylesheets().addAll(Add.class.getResource("style.css").toExternalForm());
       window.setScene(scene);
       window.show();
    } 
    
    //Add button method
    
    public void submitClicked() throws SQLException, ClassNotFoundException{
       /* Equipment equipment=new Equipment();
        equipment.setName(nameInput.getText());
        equipment.setCost(Integer.parseInt(costInput.getText()));
        equipment.setEqpDetails(detInput.getText());
    equipment.setQuantity(Integer.parseInt(quantityInput.getText()));
    equipment.setEqpCategory(catInput.getText());
     equipment.setDateCreated(dateInput.getText());
    
     table.getItems().add(equipment);*/
//     String query="INSERT INTO equipments(eqpname,eqpcost,eqpdetails,quantity,eqpcategory,date_created)"
//        + "VALUES('"+nameInput.getText()+"','"+costInput.getText()+"','"+detInput.getText()+"','"+quantityInput.getText()+"','"+catInput.getText()+"','"+dateInput.getText()+"');";
 
    String query="INSERT INTO equipments(eqpname,eqpcost,eqpdetails,quantity,eqpcategory,date_created) Values(?,?,?,?,?,?);";
            Connection conn = connectionManager.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nameInput.getText());
            stmt.setString(2, costInput.getText());
            stmt.setString(3, detInput.getText());
            stmt.setString(4, quantityInput.getText());
            stmt.setString(5, catInput.getText());
            stmt.setString(6, dateInput.getText());
            
            int i = stmt.executeUpdate();
            if(i == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Trancastion failed");
                alert.initModality(Modality.APPLICATION_MODAL);
            }else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Added Successfully");
                alert.initModality(Modality.APPLICATION_MODAL);
            }
//   st=connect.getConnection().createStatement();
   //rs=st.executeQuery(query);
   
   
    nameInput.clear();
    costInput.clear();
    quantityInput.clear();
    detInput.clear();
    quantityInput.clear();
    catInput.clear();
     dateInput.clear();


    }
  
              
 public static ObservableList<Equipment> getData() throws SQLException, ClassNotFoundException{
    // Connection con=connectionManager.getInstance().getConnection();
    
       ObservableList<Equipment> data=FXCollections.observableArrayList();
       
      // try{
            String query="select eqpID,eqpname,eqpcost,eqpdetails,quantity,eqpcategory,date_created from equipments";
          st=connect.getConnection().createStatement();
            rs=st.executeQuery(query);
           System.out.println("Records from database");
            while(rs.next()){
              Integer callid=rs.getInt("eqpID");
                String n=rs.getString("eqpname");
                Integer cs=rs.getInt("eqpcost");
                String eqd=rs.getString("eqpdetails");
                Integer q=rs.getInt("quantity");
                String eqc=rs.getString("eqpcategory");
                String dc=rs.getString("date_created");
                
               data.add(new Equipment(callid,n,cs,eqd,q,eqc,dc));
             
           
        }
return data;
      
        }
} 
    
//
//    PreparedStatement st = null;
//    ResultSet rs = null;
//    
//    TextField callId, name, quantity, cost;
//
//    public void display() throws SQLException, ClassNotFoundException {
//
//        Stage window = new Stage();
//        window.setTitle("Add equipment");
//
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(8);
//        grid.setHgap(10);
//
//        Label callId = new Label("CallID");
//        GridPane.setConstraints(callId, 0, 0);
//
//        TextField callInput = new TextField();
//        GridPane.setConstraints(callInput, 1, 0);
//
//        Label name = new Label("Name");
//        GridPane.setConstraints(name, 0, 1);
//
//        TextField nameInput = new TextField();
//        GridPane.setConstraints(nameInput, 1, 1);
//
//        Label cost = new Label("Quantity");
//        GridPane.setConstraints(cost, 0, 2);
//
//        TextField costInput = new TextField();
//        GridPane.setConstraints(costInput, 1, 2);
//
//        Label quantity = new Label("Cost");
//        GridPane.setConstraints(quantity, 0, 3);
//
//        TextField quantityInput = new TextField();
//        GridPane.setConstraints(quantityInput, 1, 3);
//
//        Button button = new Button("Submit");
//        // button.setOnAction(e -> submit());
//        GridPane.setConstraints(button, 1, 5);
//
//        // GridPane.setConstraints(button1,2,6);
//        grid.getChildren().addAll(callId, callInput, name, nameInput, cost, costInput, quantity, quantityInput, button);
//        //The table
//
//        TableView<Equipment> table;
//        table = new TableView<>();
//
//        final ObservableList<Equipment> data = FXCollections.observableArrayList();
//        //callId column
//        TableColumn<Equipment, Integer> callColumn = new TableColumn<>("CallId");
//        callColumn.setMinWidth(200);
//        callColumn.setCellValueFactory(new PropertyValueFactory("callId"));
////name column
//        TableColumn<Equipment, String> nameColumn = new TableColumn<>("Name");
//        nameColumn.setMinWidth(200);
//        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
//        //quantity column
//        TableColumn<Equipment, Integer> quantityColumn = new TableColumn<>("Quantity");
//        quantityColumn.setMinWidth(200);
//        quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
//        //Cost column
//        TableColumn<Equipment, Integer> costColumn = new TableColumn<>("Cost");
//        costColumn.setMinWidth(200);
//        costColumn.setCellValueFactory(new PropertyValueFactory("cost"));
//
//        table.setItems(getData());
//
//        table.getColumns().addAll(callColumn, nameColumn, quantityColumn, costColumn);
//        Button back = new Button("Back");
//
//        back.setOnAction(e
//                -> Booking.display());
//
//        HBox layout = new HBox();
//        layout.setPadding(new Insets(10, 10, 10, 10));
//        layout.setSpacing(10);
//        layout.getChildren().addAll(grid, table, back);
//
//        Scene scene = new Scene(layout, 1368, 660);
//        scene.getStylesheets().addAll(Add.class.getResource("style.css").toExternalForm());
//        window.setScene(scene);
//        window.show();
//    }
//
//    public  ObservableList<Equipment> getData() throws SQLException, ClassNotFoundException {
//
//        ObservableList<Equipment> data = FXCollections.observableArrayList();
//
//        try {
//            String query = "select * from equipment_table";
//            Connection conn = connectionManager.getInstance().getConnection();
//            st = conn.prepareStatement(query);
//            rs = st.executeQuery(query);
//            System.out.println("Records from database");
//            while (rs.next()) {
//                Integer callid = rs.getInt("CallID");
//                String n = rs.getString("name");
//                Integer q = rs.getInt("quantity");
//                Integer cs = rs.getInt("cost");
//
//                data.add(new Equipment(callid, n, q, cs));
//
//                //System.out.println("CallID: "+callid+"  "+"name: "+name+"  "+"quantity: "+quantity+ "  "+"cost: "+cost);
//            }
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        return data;
//
//    }
//}
