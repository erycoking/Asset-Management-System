/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminend;

import beforeLogin.login2.dbconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

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
    @FXML
    private Button auditrecords;
    @FXML
    private Button auditusers;
    @FXML
    private Label departmentlabel;

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
            stage.setTitle("This is the administators  page: "+useridentity);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
//Method called when the User Clicks the Table
    @FXML
    private Auditadminbean  tableClick() {
        //Auditadminbean available= new Auditadminbean();
        Auditadminbean available=null;
      available=tableaudits.getSelectionModel().getSelectedItem();
        
       // System.out.println("The email is"+available.getEmail());
        if(available.getEmail().equals("")){
            //System.out.println("The email is inside the if"+available.getEmail());
      tfstaffname.setText(available.getName());
        tfstaffid.setText(available.getId());
        tfstaffdepartment.setText(available.getActivity());
        departmentlabel.setText("Details");
        }
        else{
        tfstaffname.setText(available.getName());
        tfstaffid.setText(available.getId());
        tfstaffdepartment.setText(available.getActivity());
        tfstaffrole.setText(available.getRole());
        tfusername.setText(available.getDate());
        tfcontacts.setText(available.getBookID());//this is for telephone number 
        //using the same model for different constructors
        }
        
        
        return available;
        
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
       
        }    catch (SQLException ex) {
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
        //data.add(new Auditadminbean(rs.getString(2),rs.getString(6),rs.getString(1),rs.getString(9)));
       data.add( new Auditadminbean(rs.getString(2), rs.getString(1),rs.getString("faculty"), rs.getString(3),rs.getString("email"),rs.getString(9),rs.getString(7),rs.getString("department")));
               
       
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
        if(staffname.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Name of the user", "Null name input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(staffID.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Staff Id of the user", "Null Identity number input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(staffdepartment.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Department of the user", "Null Department input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(staffrole.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Role of the user", "Null Role input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(contacts.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Contacts of the user", "Null contact input",JOptionPane.INFORMATION_MESSAGE);
                }
        else if(username.equals("")){
        JOptionPane.showMessageDialog(null, "Username of the user required", "Null username input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(password.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the password of the user should login with ", "Null password input",JOptionPane.INFORMATION_MESSAGE);
        
        }        
        else{
        adminfunctions add= new adminfunctions();
        add.adduser(staffname,staffID,staffdepartment,staffrole,username,password,contacts);
        }
    }

    @FXML
    private void updateuser(ActionEvent event) {
        tableClick().getId();
        System.out.println("The update user is here:"+tableClick().getName()+" "+tableClick().getId());
        String staffname= tfstaffname.getText();
        String staffID=tfstaffid.getText();
        String staffdepartment=tfstaffdepartment.getText();
        String staffrole=tfstaffrole.getText();
        String username=tfusername.getText();
        String password=tfpassword.getText();
        String contacts=tfcontacts.getText();
        if(staffname.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Name of the user", "Null name input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(staffID.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Staff Id of the user", "Null Identity number input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(staffdepartment.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Department of the user", "Null Department input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(staffrole.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Role of the user", "Null Role input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(contacts.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the Contacts of the user", "Null contact input",JOptionPane.INFORMATION_MESSAGE);
                }
        else if(username.equals("")){
        JOptionPane.showMessageDialog(null, "Username of the user required", "Null username input",JOptionPane.INFORMATION_MESSAGE);
        
        }
        else if(password.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the password of the user should login with ", "Null password input",JOptionPane.INFORMATION_MESSAGE);
        
        }        
        else{
            try {
                //adminfunctions add= new adminfunctions();
                //add.updateuser(staffname,staffID,staffdepartment,staffrole,username,password,tableClick().getEmail(),contacts);
                dbconnection dc = new dbconnection();
                PreparedStatement ps;
                Connection conn = dc.ConnectDB();
                String update="update users set Name='"+staffname+"', staff_id='"+staffID+"', username='"+username+"', password='"+password+"',department='"+staffdepartment+"', telephone_no='"+contacts+"', role='"+staffrole+"' where staff_id='"+ tableClick().getId()+"'";
                ps=conn.prepareStatement(update);
                ps.execute();
                JOptionPane.showMessageDialog(null,"USer updated successfully","Update successful",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteuser(ActionEvent event) {
        try {
            dbconnection dc = new dbconnection();
            PreparedStatement ps;
            Connection conn = dc.ConnectDB();
            String update="Delete FROM users where staff_id='"+tableClick().getId()+"'";
            ps=conn.prepareStatement(update);
            ps.execute();
            JOptionPane.showMessageDialog(null,"User Deleted successfully","Delete successful",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @FXML
    public void logout(Event event) throws IOException {
        Stage stage = new Stage();
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/UI/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/UI/login.css").toExternalForm());
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/equipment2.jpg")));
        stage.setTitle("Active Inventory");
        stage.show();
    }


    
    }
