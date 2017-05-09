/*
*This is the booking controller class
 *This class displays the available equipments in a table form and helps in booking
 */
package booking;

//import Technicians.*;
import beforeLogin.login2.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    private TextField txfdavailable;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   

    /* This method is called from the home controller to set or call the bookinglayout interface*/
    public void showstagetable(String UserID) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booklayout.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:images/matthews.jpg"));
            stage.setTitle("These Are the Available Equipments and this is Your Identity Number If not please contact admin:" + UserID);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Functions1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*This method  loads data into the table view from the database*/
    @FXML
    public void loaddatafromdatabase() throws SQLException, IOException {
        dbconnection dc;
        dc = new dbconnection();
        Connection conn = dc.ConnectDB();
        data = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM unbookedeqpmnts");
        while (rs.next()) {
            if (rs.getInt(5) >= 1) {
                data.add(new Availabledetails(rs.getString(2), rs.getString(6), rs.getInt(5), rs.getString(7), rs.getInt(1)));
            }
        }
        
        columnEquipments.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        columnquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnavailable.setCellValueFactory(new PropertyValueFactory<>("Available"));
        tableitems.setItems(null);
        tableitems.setItems(data);
        
        //***********************************************************************************************************************
        //This is the admins add equipment layout file.
       /* FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Addequipments.fxml"));
        Parent root2 = (Parent) fxmlLoader2.load();
        Stage stage2 = new Stage();
        stage2.setTitle("Administrator Only");
        stage2.setScene(new Scene(root2));
        stage2.show();*/
         //should be only visible to the administrator or technicians
       // PendingbookingsController pendings = new PendingbookingsController();
       // pendings.showpendingbookingslayout();
        //***********************************************************************************************************************
        
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
    public Availabledetails availableequipment(Availabledetails equipment ){
         
        return equipment;
    }

   //this method sets the static variable of the user ID to the one logged in
    public String useridentity(String Userid) {
        BooklayoutController.useridentity = Userid;
        System.out.println("The user id inside identity method is " + useridentity);
        return Userid;
    }
    //this  method sets the static global variable useridentity to the value of the logged in user
    public String loggedinuserId(){
     return useridentity;   
    }
     /**
     * This is the method that books the selected item/equipments does the
     * calculations for the equipments quantity and time
     *
     * @param Userid
     * @return
     */

    @FXML
    private void bookitem(ActionEvent event) {
        try {
            Availabledetails available = tableitems.getSelectionModel().getSelectedItem();
            Integer EqpId = available.getId();
            String quantity = txfdquantity.getText();
            String useridentification = useridentity;
            Integer quantityordered = Integer.parseInt(quantity);
            LocalDate fromtime=Fromdatepicker.getValue();
            LocalDate Todate=todatepicker.getValue();
            System.out.println("The user id is " + useridentity);
            System.out.println("The user id is " + useridentity);
            //reduces the equipment quantity by the number of  equipments ordered
            Integer remaining = fnctns.bookitem(EqpId, quantityordered, useridentification, fromtime,Todate);
            //Note we can also pass the clicked equipment as an object in the parameter field of the booking method
            //and do the necessary booking in the method where it is by retrieving the objects values
            available.setQuantity(remaining);
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
            dbconnection dc;
            dc = new dbconnection();
            Connection conn = dc.ConnectDB();
            data = FXCollections.observableArrayList();
            //select from allocated table and get the allocator id, eqpmentId, Quantity, from and to dates
            //query equipments for eqpmntname ,from login for allocator.
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM allocatedeqpmnts where Userid='"+this.loggedinuserId() +"'");
        while(rs.next()) {
                 ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM equipments where eqpID='"+rs.getInt(1) +"'");
                  ResultSet rs3 = conn.createStatement().executeQuery("SELECT * FROM users where staff_id='"+rs.getString(6) +"'");
                     if(rs2.next()){
                         if(rs3.next()){
                 data.add(new Availabledetails(rs2.getString(2), rs3.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(1)));
                     } else{
                columnallocated.setText("No items allocated yet");
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
    private void viewcleared(ActionEvent event) {
        columnby.setText("Cleared/Allocated by");
        columnFrom.setText("Booked From");   
    }
}
