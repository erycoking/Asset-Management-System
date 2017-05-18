/*
*This is the booking controller class
 *This class displays the available equipments in a table form and helps in booking
 */
package booking;

//import Technicians.*;
import beforeLogin.login2.*;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    private ImageView image;
    @FXML
    private Button allocated;
    @FXML
    private Button clearedbutton;
    //declare the user identity as static to be able to access it anywhere in this class' code
    private static String useridentity;
   
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
    private TextArea txtfdbookdetails;
    @FXML
    private TextArea txfdallocateddetails;
    @FXML
    private Button btnbooked;
    @FXML
    private Button btnunbook;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    dbconnection dc= new dbconnection();
                        PreparedStatement ps;

    /* This method is called from the home controller to set or call the bookinglayout  user interface*/
    public void showstagetable(String UserID, String usersname) {
        try {
            this.view();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booklayout.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:images/matthews.jpg"));
            stage.setTitle("These Are the Available Equipments and this is Your Identity Number If not please contact admin:" + UserID + usersname.toUpperCase());
          stage.setScene(new Scene(root1));  
          String css = BooklayoutController.class.getResource("booklayout.css").toExternalForm();
                 root1.getStylesheets().clear();
                root1.getStylesheets().add(css);
            stage.show();
             //image.setImage(new Image("/assetmanagement/images/equipment2.jpg"));
            // view();
        } catch (IOException ex) {
            Logger.getLogger(Functions1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void view() {
        TilePane tile = new TilePane();//create the tilepane layout
        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(15);
        String path = "F:\\phone\\image1";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (final File file : listOfFiles) {
            ImageView imageView;
           // imageView = createImageView(file);
            image=createImageView(file);
            //uncooment to see the tile pane with images
          // tile.getChildren().addAll(imageView);
        }
    }
   /*****************************************************************************************************/
    //Method to help in creating a new imageview each time we have a new imagefile
    /**
     * @param imageFile
     * @return ***************************************************************************************************/
    public ImageView createImageView(final File imageFile) {
        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
        } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
        return imageView;
    }
    /*This method  loads data into the table view from the database*/
    @FXML
    public void loaddatafromdatabase() throws SQLException, IOException {
        Connection conn = dc.ConnectDB();
        data = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM unbookedeqpmnts");
        while (rs.next()) {
            if (rs.getInt(5) >= 1) {
                data.add(new Availabledetails(rs.getString(2), rs.getString(6), rs.getString(4),rs.getInt(5), rs.getString(7), rs.getInt(1),rs.getString(3)));
            }
        }

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
        txtfdbookdetails.setText(eqp.getDetails());
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
     * @param Userid
     * @return
     */

    @FXML
    private void bookitem(ActionEvent event) {
        try {
             Functions1 fnctns = new Functions1();   Availabledetails available = tableitems.getSelectionModel().getSelectedItem();
            Integer EqpId = available.getId();
            String quantity = txfdquantity.getText();
            String useridentification = useridentity;
            Integer quantityordered = Integer.parseInt(quantity);
            LocalDate fromtime = Fromdatepicker.getValue();
            LocalDate Todate = todatepicker.getValue();
            System.out.println("The user id is " + useridentity);
            System.out.println("The user id is " + useridentity);
            //reduces the equipment quantity by the number of  equipments ordered
           Integer remaining = fnctns.bookitem(EqpId, quantityordered, useridentification, fromtime, Todate);
            //Note we can also pass the clicked equipment as an object in the parameter field of the booking method
            //and do the necessary booking in the method where it is by retrieving the objects values
            available.setQuantity(remaining);
            
                
            
        } catch (SQLException ex) {
            Logger.getLogger(BooklayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private void Viewallocated(ActionEvent event) {
        try {
            columnby.setText("Allocated by");
        columnFrom.setText("Booked From");
        btnunbook.setVisible(false);
            Connection conn = dc.ConnectDB();
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
           Connection conn = dc.ConnectDB();
            data = FXCollections.observableArrayList();
            //select from allocated table and get the allocator id, eqpmentId, Quantity, from and to dates
            //query equipments for eqpmntname ,from login for allocator.
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM bookedeqpmnts where Userid='" + this.loggedinuserId() + "'");
            while (rs.next()) {
                ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM equipments where eqpID='" + rs.getInt(3) + "'");
                ResultSet rs3 = conn.createStatement().executeQuery("SELECT * FROM users where staff_id='" + rs.getString(2) + "'");
                if (rs2.next()) {
                    if (rs3.next()) {
                        data.add(new Availabledetails(rs2.getString(2), rs3.getString(2), rs.getInt(4), rs.getString(5), rs.getInt("eqpID"),rs.getInt("bookId")));
                      
                    } else {
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
    private void unbookequipment() {
        try {
            Connection conn = dc.ConnectDB();
            Availabledetails available= this.onthetableclick();
            if(!(available==null)){
            Integer EqpId = available.getId();
            available.getBookID();
            //Test lines works properly
            System.out.println("Booklayoutcontroller314// The bookId is " + available.getBookID());
            System.out.println("The equipment id is " + EqpId);
            String Delete = "DELETE FROM bookedeqpmnts WHERE bookId='"+available.getBookID()+"'";
            ps = conn.prepareStatement(Delete);
            ps.execute();
             Functions1 fnctns = new Functions1();
            fnctns.auditunbooking(this.loggedinuserId(),available.getEquipment(),available.getBookID(),available.getType());
            JOptionPane.showMessageDialog(null, "Successful Unbooking", "Cancelled Booking", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Please select an Equipment to delete from the Table ", "No selection Made", JOptionPane.INFORMATION_MESSAGE);
           
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

}
