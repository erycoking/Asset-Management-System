/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import beforeLogin.login2.dbconnection;
import com.jfoenix.controls.JFXTextField;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
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
    private Button addequipmentbtn;
    @FXML
    private Button loadeqmnts;
    @FXML
    private TableView<Availabledetails> tableallequipments;
    @FXML
    private TableColumn<Availabledetails, String> columnequipmentname;
    @FXML
    private TableColumn<Availabledetails, String> columnquantity;
    @FXML
    private TableColumn<Availabledetails, String> columncategory;
    @FXML
    private TableColumn<Availabledetails, String>columndatebrought;
    @FXML
    private TableColumn<Availabledetails, String>columncost;
    private ObservableList<Availabledetails> data;
    @FXML
    private JFXTextField tfeqpname;
    @FXML
    private JFXTextField tftotalquantity;
    @FXML
    private JFXTextField tfcategory;
    @FXML
    private JFXTextField tfcost;
    @FXML
    private TextArea tAdetails;
    @FXML
    private Button buttonUpdated;
    @FXML
    private Button buttondelete;
    @FXML
    private JFXTextField eqpcost;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    } 
    dbconnection dc= new dbconnection();
            Connection conn = dc.ConnectDB();
            PreparedStatement ps;
    /**
     * This method add equipment takes the specific users specified details and add that equipment into both Equipments  
     * and UnbookedEquipments.
     
     */
    @FXML
    private void addequipment(ActionEvent event) {
        try {
            //Create a connection to the database
            if(eqpname.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Equipment Name", "Error adding an Equipment", JOptionPane.ERROR_MESSAGE);
                conn.close();
            }
            else if(eqpcost.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Equipment Cost", "Error adding an Equipment", JOptionPane.ERROR_MESSAGE);
                conn.close();
            }
            else if(eqpquantity.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Quantity", "Error adding an Equipment", JOptionPane.ERROR_MESSAGE);
                conn.close();
            }
            else if(eqpcategory.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Equipment Category/type", "Error adding an Equipment", JOptionPane.ERROR_MESSAGE);
                conn.close();
            }
            else{
                dbconnection dc;
            dc = new dbconnection();
            Connection conn = dc.ConnectDB();
            PreparedStatement pst;
            String insert="INSERT INTO EQUIPMENTS (eqpname, eqpcost, eqpdetails, quantity,eqpcategory,date_created)VALUES('"+eqpname.getText()+"','"+eqpcost.getText()+"', '"+eqpdetails.getText()+"','"+eqpquantity.getText()+"','"+eqpcategory.getText()+"',SYSDATE())" ;
            pst = conn.prepareStatement(insert); 
            PreparedStatement pst2;
            String insert2="INSERT INTO UNBOOKEDEqPMNTS  (eqpname, eqpcost, eqpdetails, quantity,eqpcategory,date_created) VALUES('"+eqpname.getText()+"','"+eqpcost.getText()+"', '"+eqpdetails.getText()+"','"+eqpquantity.getText()+"','"+eqpcategory.getText()+"',SYSDATE())" ;
            pst2 = conn.prepareStatement(insert2); 
             pst.execute();
             pst2.execute();                   
             conn.close();
            JOptionPane.showMessageDialog(null, "You Successfully added '"+eqpname.getText()+"'", "Administrator added an Equipment", JOptionPane.INFORMATION_MESSAGE);
            }
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
            stage2.setFullScreen(true);
            stage2.show();
            //should be only visible to the administrator or technicians
            // PendingbookingsController pendings = new PendingbookingsController();
            // pendings.showpendingbookingslayout();
            //***********************************************************************************************************************
        } catch (IOException ex) {
            Logger.getLogger(AddequipmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    //***********************************************************************************************************
    //This method loads all the available equipments to the administrators table of all equipments in the laboratory
    //************************************************************************************************************

    @FXML
    private void showallequipments(ActionEvent event) {
        try {
            
            dbconnection.ConnectDB();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM equipments");
            while (rs.next()) {
                if (rs.getInt(5) >= 1) {
                    //rs.getint(3) is a way for accessing the equipment cost since it is of integer type still 
                   
                  //  data.add(new Availabledetails(rs.getString(2), rs.getString(6), rs.getInt(5), rs.getString(7), rs.getInt(1),rs.getInt(3)));
               
                data.add(new Availabledetails(rs.getString(2), rs.getString(6),rs.getString(4),rs.getInt(5), rs.getString(7), rs.getInt(1),rs.getString(3)));
                }
            }
            
            columnequipmentname.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
            columncategory.setCellValueFactory(new PropertyValueFactory<>("Type"));
            columnquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            columndatebrought.setCellValueFactory(new PropertyValueFactory<>("Available"));
            columncost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
           // columndetails.setCellValueFactory(new PropertyValueFactory<>("Details"));
            tableallequipments.setItems(null);
           tableallequipments.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AddequipmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void retrieveclickedeqpmnt(MouseEvent event) {
        Availabledetails equipment=tableallequipments.getSelectionModel().getSelectedItem();
        
        //note this is for the cost of the equipment initially but it null know  due 
        //equipment.getBookID();
        tfcategory.setText(equipment.getType());
        tfcost.setText(equipment.getCost());
        tftotalquantity.setText(equipment.getQuantity().toString());
        tfeqpname.setText(equipment.getEquipment());
        tAdetails.setText(equipment.getDetails());
        //you can alsochange the coumns using setText()
        // columncategory.setText(equipment.getType());
    }

    }
