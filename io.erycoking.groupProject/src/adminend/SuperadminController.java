/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminend;

import beforeLogin.login2.dbconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matthews
 */
public class SuperadminController implements Initializable {

    @FXML
    private TableView<Auditadminbean> tableaudits;
    @FXML
    private TableColumn<Auditadminbean, String> ColumnName;
    @FXML
    private TableColumn<Auditadminbean, String> ColumnUserId;
    @FXML
    private TableColumn<Auditadminbean, String> ColumnDate;
    @FXML
    private TableColumn<Auditadminbean, String> ColumnActivity;
    private ObservableList<Auditadminbean> data;
    @FXML
    private JFXTextField tfstaffname;
    @FXML
    private JFXTextField tfstaffid;
    @FXML
    private JFXTextField tfstaffdepartment;
    @FXML
    private JFXTextField tfstaffrole;
    @FXML
    private JFXButton addbutton;
    @FXML
    private JFXButton updatebutton;
    @FXML
    private Button deletebutton;
    @FXML
    private JFXTextField tfusername;
    @FXML
    private JFXTextField tfpassword;
    @FXML
    private JFXTextField tfcontacts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void showstagetable(String useridentity){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("superadmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:images/matthews.jpg"));
            stage.setTitle("These Are the Available Equipments and this is Your Identity Number If not please contact admin: "+useridentity);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
//Method called when the User Clicks the Table
    @FXML
    private void tableClick(MouseEvent event) {
        //Auditadminbean available= new Auditadminbean();
        Auditadminbean available=tableaudits.getSelectionModel().getSelectedItem();
        tfstaffname.setText(available.getName());
        tfstaffid.setText(available.getId());
        tfstaffdepartment.setText(available.getActivity());
        tfstaffrole.setText(available.getRole());
            }
//Calledwhen the user/admin wants to view the audits
    @FXML
    private void retrieveAudits(ActionEvent event) {
        try {
            dbconnection dc=new dbconnection();
            Connection conn= dc.ConnectDB();
            PreparedStatement ps;
            String query="SELECT * FROM audittrail";
            ResultSet rs=conn.createStatement().executeQuery("SELECT * FROM audittrail");
            
            data=FXCollections.observableArrayList();
            while(rs.next()){
              //  data.add(new Auditadminbean())
              ResultSet rs2=conn.createStatement().executeQuery("SELECT * FROM users WHERE staff_id='"+rs.getString(2)+"'");
              if(rs2.next()){
               data.add(new Auditadminbean(rs2.getString(2),rs2.getString(1),rs.getString(4),rs.getString(3)));
            }
            }
            ColumnName.setText("UserIdentity");
            ColumnUserId.setText("Staff Id");
            ColumnDate.setText("Date");
            ColumnActivity.setText("Activity");
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
       ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("Id"));
       ColumnActivity.setCellValueFactory(new PropertyValueFactory<>("activity"));
       ColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       tableaudits.setItems(data);
       rs.close();
       conn.close();
       
        } catch (SQLException ex) {
            Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void retrieveUsers(ActionEvent event) {
        try{
            dbconnection dc=new dbconnection();
            Connection conn= dc.ConnectDB();
        ResultSet rs=conn.createStatement().executeQuery("SELECT* FROM users");
        data=FXCollections.observableArrayList();
        while(rs.next()){
        data.add(new Auditadminbean(rs.getString(2),rs.getString(6),rs.getString(1),rs.getString(9)));
       
        }
        ColumnName.setText("Staff Name");
        ColumnUserId.setText("Staff ID");
        ColumnActivity.setText("Department");
        ColumnDate.setText("Staff Role");
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("activity"));
        ColumnActivity.setCellValueFactory(new PropertyValueFactory<>("department"));
       ColumnDate.setCellValueFactory(new PropertyValueFactory<>("role"));
        tableaudits.setItems(data);
        }
        catch(SQLException ex){
        Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adduser(ActionEvent event) {
       String staffname= tfstaffname.getText();
        String staffID=tfstaffid.getText();
        String staffdepartment=tfstaffdepartment.getText();
        String staffrole=tfstaffrole.getText();
        String username=tfusername.getText();
        String password=tfpassword.getText();
        String contacts=tfcontacts.getText();
        //adminfunctions add= new adminfunctions();
        adminfunctions.adduser(staffname,staffID,staffdepartment,staffrole,username,password,contacts);
    }

    @FXML
    private void updateuser(ActionEvent event) {
    }

    @FXML
    private void deleteuser(ActionEvent event) {
    }
    
}
