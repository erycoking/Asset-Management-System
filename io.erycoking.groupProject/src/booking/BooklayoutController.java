/*
*This is the booking controller class
 *This class displays the available equipments in a table form and helps in booking
 */
package booking;

//import Technicians.*;
import beforeLogin.login2.Functions1;
import beforeLogin.login2.dbconnection;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//import lams.Functions1;
//port lams.dbconnection;

/**
 *
 *
 * @author Matthews
 */
public class BooklayoutController implements Initializable {

    private ObservableList<Availabledetails> data;
    @FXML
    private TableView<Availabledetails> tableitems;
    @FXML
    private TableColumn<Availabledetails, String> columnEquipments;
    @FXML
    private TableColumn<Availabledetails, String> columnType;
    @FXML
    private TableColumn<Availabledetails, String> columnquantity;
    @FXML
    private TableColumn<Availabledetails, String> columnavailable;
    @FXML
    private TextField txfdequipment;
    @FXML
    private TextField txfdcategory;
    @FXML
    private TextField txfdquantity;
    @FXML
    private Button view;
    @FXML
    private Button bookeqpmnt;
    @FXML
    private Button chooseimage;
    @FXML
    private ImageView image;
    @FXML
    private Button allocated;
    @FXML
    private Button clearedbutton;
    //declare the user identity as static to be able to access it anywhere in this class' code
    private static String useridentity;
    Functions1 fnctns = new Functions1();
    @FXML
    private DatePicker todatepicker;
    @FXML
    private DatePicker Fromdatepicker;
    @FXML
    private TableView<Availabledetails> tableallocated;
    @FXML
    private TableColumn<Availabledetails, String> columnallocated;
    @FXML
    private TableColumn<Availabledetails, String> columnquantityallocated;
    @FXML
    private TableColumn<Availabledetails, String> columnby;
    @FXML
    private TableColumn<Availabledetails, String> columnFrom;
    @FXML
    private TableColumn<Availabledetails, String> columnTo;
    private ObservableList<Availabledetails> data2;
    @FXML
    private Button btnbooked;
    @FXML
    private Button btnunbook;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    //dbconnection dc= new dbconnection();
       //     Connection conn = dc.ConnectDB();
       //     PreparedStatement ps;

    /* This method is called from the home controller to set or call the bookinglayout interface*/
    public void showstagetable(String UserID, String usersname) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booklayout.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:images/matthews.jpg"));
            stage.setTitle("These Are the Available Equipments and this is Your Identity Number If not please contact admin:" + UserID + usersname.toUpperCase());
          stage.setScene(new Scene(root1));
//          String css = BooklayoutController.class.getResource("/booklayout.css").toExternalForm();
                 root1.getStylesheets().clear();
              // root1.getStylesheets().add(css);
            
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Functions1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*This method  loads unbooked data into the table view from the database*/
    @FXML
    public void loaddatafromdatabase() throws SQLException, IOException {
        dbconnection dc= new dbconnection();
            Connection conn=dc.ConnectDB();
            PreparedStatement ps;
                data = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM unbookedeqpmnts");
        while (rs.next()) {
            if (rs.getInt(5) >= 1) {
                data.add(new Availabledetails(rs.getString(2), rs.getString(6), rs.getInt(5), rs.getString(7),rs.getString(4),rs.getInt(1),rs.getInt(3)));
            }
        }
    
//columnEquipments;
        columnEquipments.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        columnquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnavailable.setCellValueFactory(new PropertyValueFactory<>("Available"));
        tableitems.setItems(null);
        tableitems.setItems(data);

    }

    /**
     * This method sets the text field to the value of the related item clicked
     * in the table view for easy booking
     */
    @FXML
    private void loadvalues(MouseEvent event) throws FileNotFoundException {
        Availabledetails eqp = tableitems.getSelectionModel().getSelectedItem();

//testing line       
// System.out.println(tableitems.getItems());
        String eqpment = eqp.getEquipment();
        txfdequipment.setText(eqpment);
        txfdcategory.setText(eqp.getType());
        System.out.println("the id clicked is" + eqp.getId());
        Integer identity = eqp.getId();
        // person.
        // String add = String.parseString(txfdquantity.getText());
        txfdquantity.setText(eqp.getQuantity().toString());
        //txfdavailable.setText( person.getId());
    }

    //alternative way of getting the clicked values as an object
    public Availabledetails availableequipment(Availabledetails equipment) {

        return equipment;
    }

    //this method sets the static variable of the user ID to the one logged in
    public String useridentity(String Userid) {
        BooklayoutController.useridentity = Userid;
        System.out.println("The user id inside identity method is " + useridentity);
        return Userid;
    }

    //this  method sets the static global variable useridentity to the value of the logged in user
    public String loggedinuserId() {
        return useridentity;
    }

    /**
     * This is the method that books the selected item/equipments does the
     * calculations for the equipments quantity and time
     *
     * @param
     * @return
     */

    @FXML
    private void bookitem(ActionEvent event) {
        try {
           if(!(tableitems.getSelectionModel().getSelectedItem()==null)){
            Availabledetails available = tableitems.getSelectionModel().getSelectedItem();
            System.out.println(available.toString()+"this is the available object");
            Integer EqpId = available.getId();
            String quantity = txfdquantity.getText();
            String useridentification = useridentity;
            Integer quantityordered = Integer.parseInt(quantity);
            LocalDate fromtime = Fromdatepicker.getValue();
            LocalDate Todate = todatepicker.getValue();
            System.out.println("The user EQPid is " + EqpId);
            System.out.println("The user id is " + useridentity);
            //reduces the equipment quantity by the number of  equipments ordered
            Integer remaining = fnctns.bookitem(EqpId, quantityordered, useridentification, fromtime, Todate);
            //Note we can also pass the clicked equipment as an object in the parameter field of the booking method
            //and do the necessary booking in the method where it is by retrieving the objects values
            available.setQuantity(remaining);
           }
           else{
               JOptionPane.showMessageDialog(null, "Please select an equipment from the table ", "Null equipment Selection", JOptionPane.INFORMATION_MESSAGE);
                 }
            
        } catch (SQLException ex) {
            Logger.getLogger(BooklayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void selectimage(ActionEvent event) {
        //the file chooser below should be used in adding an equipmentso that we save the image path to the db
    }
//******************************************************************************************************************************
// this function loads a specific users details of allocated equipments after they had previously booked them to the tableview
//********************************************************************************************************************************

    @FXML
    private void Viewallocated(ActionEvent event) {
        try {
            columnby.setText("Allocated by");
        columnFrom.setText("Booked From");
        btnunbook.setVisible(false);
            dbconnection dc= new dbconnection();
            Connection conn = dbconnection.ConnectDB();
            PreparedStatement ps;
            data = FXCollections.observableArrayList();
            //select from allocated table and get the allocator id, eqpmentId, Quantity, from and to dates
            //query equipments for eqpmntname ,from login for allocator.
             ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM allocatedeqpmnts where Userid='" + this.loggedinuserId() + "'");
            while (rs.next()) {
                ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM equipments where eqpID='" + rs.getInt(1) + "'");
                ResultSet rs3 = conn.createStatement().executeQuery("SELECT * FROM users where staff_id='" + rs.getString(6) + "'");
                if (rs2.next()) {
                    if (rs3.next()) {
                        data.add(new Availabledetails(rs2.getString(2), rs3.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(1),rs.getInt("BookID")));
                    } else {
                        //columnallocated.setText("No items allocated yet");
                        JOptionPane.showMessageDialog(null,"No allocated Equipments Yet for: "+useridentity,"No allocation Made recently",JOptionPane.INFORMATION_MESSAGE);
                        tableallocated.setItems(null);
                    }
                }
            }

            columnallocated.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
            columnby.setCellValueFactory(new PropertyValueFactory<>("Type"));
            columnquantityallocated.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            columnFrom.setCellValueFactory(new PropertyValueFactory<>("Available"));
            columnTo.setCellValueFactory(new PropertyValueFactory<>("Available"));
            tableallocated.setItems(null);
            tableallocated.setItems(data);
            btnunbook.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(BooklayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewcleared(ActionEvent event) {
        columnby.setText("Cleared by");
        columnFrom.setText("Booked From");
        btnunbook.setVisible(false);
    }

    @FXML
    public void viewbooked() {
        try {
            columnby.setText("Boooked by");
            columnFrom.setText("Booked From");
            btnunbook.setVisible(true);
           dbconnection dc= new dbconnection();
            Connection conn = dbconnection.ConnectDB();
            PreparedStatement ps;
            data = FXCollections.observableArrayList();
            //select from allocated table and get the allocator id, eqpmentId, Quantity, from and to dates
            //query equipments for eqpmntname ,from login for allocator.
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM bookedeqpmnts where Userid='" + this.loggedinuserId() + "'");
            System.out.println("This is the loggedin user Id"+ this.loggedinuserId());
            while (rs.next()) {
                ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM equipments where eqpID='" + rs.getInt(3) + "'");
                ResultSet rs3 = conn.createStatement().executeQuery("SELECT * FROM users where staff_id='" + rs.getString(2) + "'");
                if (rs2.next()) {
                    if (rs3.next()) {
                        data.add(new Availabledetails(rs2.getString(2), rs3.getString(2), rs.getInt(4), rs.getString(5), rs.getInt("eqpID"),rs.getInt("bookId")));
                      
                    } else {
                        columnallocated.setText("No items Booked yet");
                    }
                }
            }

            columnallocated.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
            columnby.setCellValueFactory(new PropertyValueFactory<>("Type"));
            columnquantityallocated.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            columnFrom.setCellValueFactory(new PropertyValueFactory<>("Available"));
            columnTo.setCellValueFactory(new PropertyValueFactory<>("Available"));
            tableallocated.setItems(null);
            tableallocated.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(BooklayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void unbookequipment() {
        try {
            if(!(this.onthetableclick()==null)){
            Availabledetails available= this.onthetableclick();
            Integer EqpId = available.getId();
            available.getBookID();
            dbconnection dc= new dbconnection();
            Connection conn = dbconnection.ConnectDB();
            PreparedStatement ps;
            //Test lines works properly
            System.out.println("Booklayoutcontroller314// The bookId is " + available.getBookID());
            System.out.println("The equipment id is " + EqpId);
            Integer BookId= available.getBookID();
            String Delete = "DELETE FROM bookedeqpmnts WHERE bookId='"+BookId+"'";
             ps = conn.prepareStatement(Delete);
            ps.execute();
           /* String Update = "UPDATE unbookedeqpmnts SET quantity='" + remaining + "' Where eqpID='" + EqpId + "'";
                ps = conn.prepareStatement(Update);
                ps.execute();*/
           this.viewbooked();
            fnctns.auditunbooking(this.loggedinuserId(),available.getEquipment(),available.getBookID(),available.getType());
             JOptionPane.showMessageDialog(null, "Successfully unbooked the equipment", "Unbooking Successful", JOptionPane.INFORMATION_MESSAGE);
           
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select a Booking from the table", "Null Booking selection ", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooklayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public Availabledetails onthetableclick(){
    Availabledetails available = tableallocated.getSelectionModel().getSelectedItem();
    
    return available;
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
