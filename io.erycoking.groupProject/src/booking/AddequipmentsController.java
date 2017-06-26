/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import beforeLogin.login2.dbconnection;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 
 * @author Matthews
 */
public class AddequipmentsController implements Initializable {

    @FXML
    private JFXTextField eqpname;
    @FXML
    private JFXTextField eqpquantity;
    @FXML
    private JFXTextField eqpcategory;
    @FXML
    private JFXTextField eqpdetails;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
    
    } 
    /**
     * This method add equipment takes the specific users specified details and add that equipment into both Equipments  
     * and UnbookedEquipments.
     
     */
    @FXML
    private void addequipment(ActionEvent event) {
        try {
            //Create a connection to the database
            if(!eqpquantity.getText().equals("")){
            dbconnection dc;
            dc = new dbconnection();
            Connection conn = dbconnection.ConnectDB();
            PreparedStatement pst;
            String insert="INSERT INTO EQUIPMENTS (eqpname, eqpcost, eqpdetails, quantity,eqpcategory,date_created)VALUES('"+eqpname.getText()+"',  10000, '"+eqpdetails.getText()+"','"+eqpquantity.getText()+"','"+eqpcategory.getText()+"',SYSDATE())" ;
            pst = conn.prepareStatement(insert);   
            pst.execute();
            PreparedStatement pst2;
            String insert2="INSERT INTO UNBOOKEDEqPMNTS  (eqpname, eqpcost, eqpdetails, quantity,eqpcategory,date_created) VALUES('"+eqpname.getText()+"',  10000, '"+eqpdetails.getText()+"','"+eqpquantity.getText()+"','"+eqpcategory.getText()+"',SYSDATE())" ;
            pst2 = conn.prepareStatement(insert2); 
            pst2.execute();
            conn.close();
            }
            else{
                //test line
            System.out.println("you did not enter the quantity  field***at addequipmentscontroller line81");
            JOptionPane.showMessageDialog(null, "Unsuccessful Equipment adding", "Add Equipment Fsiled", JOptionPane.INFORMATION_MESSAGE);
                  }
            JOptionPane.showMessageDialog(null, "Successfully added '+eqpname.getText()+'The equipment", "Add Equipment", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddequipmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
//this method is called whenever we need the technicians add equipment side
    public void showstage(){
        try {
            //***********************************************************************************************************************
            //This is the admins add equipment layout file.
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Addequipments.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Administrator Only");
            stage2.setScene(new Scene(root2));
            stage2.show();
            //should be only visible to the administrator or technicians
            // PendingbookingsController pendings = new PendingbookingsController();
            // pendings.showpendingbookingslayout();
            //***********************************************************************************************************************
        } catch (IOException ex) {
            Logger.getLogger(AddequipmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
    
    
}
