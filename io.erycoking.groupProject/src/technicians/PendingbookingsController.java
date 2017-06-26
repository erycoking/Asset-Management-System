/*
 * This class controlls the pending bookings of the whole System where any technician logged in can see them and 
 *allow any booking process to be complete by alocating the required items to the user who had previously booked
 *the items
 *It also helps the technician view his specific completed, cleared and pending bookings which he/she is responsible over 
 */
package technicians;

import beforeLogin.login2.Functions1;
import beforeLogin.login2.dbconnection;
import booking.AddequipmentsController;
import booking.Bookingsdetails;
import booking.BooklayoutController;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Matthews
 */
public class PendingbookingsController implements Initializable {
    

    private static String useridentity;
    private ObservableList<Bookingsdetails> data;
    private ObservableList<allocatedequipmentsmodel> allocateddetailsdata;
    @FXML
    private TableView<Bookingsdetails> bookeditemstable;
    @FXML
    private TableColumn<Bookingsdetails, String> bookedEquipments;
    @FXML
    private TableColumn<Bookingsdetails, Integer> Quantityordered;
    @FXML
    private TableColumn<Bookingsdetails, String> orderedBy;
    @FXML
    private TableColumn<Bookingsdetails, String> Fromtime;
    @FXML
    private TableColumn<Bookingsdetails, String> Totime;
    @FXML
    private TableColumn<Bookingsdetails, String> EquipmentCost;
    @FXML
    private JFXTextField txfdequipment;
    @FXML
    private Label labeleqpcost;
    @FXML
    private Label labelquantity;
    @FXML
    private Label labelfromtime;
    @FXML
    private Label labeltotime;
    @FXML
    private Button btnallocate;
    @FXML
    private JFXTextField txfdallocatedto;
    @FXML
    private Label labelbright;
    @FXML
    private Label label;
    @FXML
    private Label labelkorderuserId;
    Functions1 fnctns = new Functions1();
    @FXML
    private Button loadingbutton;
    @FXML
    private Button Showequipments;

    /**
     * Initializes the controller class.
     */
     BooklayoutController bk;
    @FXML
    private JFXButton allocatedbtn;
    @FXML
    private JFXButton returneqpmntbtn;
    @FXML
    private TableView<allocatedequipmentsmodel> allocateditemstable;
    @FXML
    private TableColumn<allocatedequipmentsmodel, String> bookedEquipments1;
    @FXML
    private TableColumn<allocatedequipmentsmodel, String> Quantityordered1;
    @FXML
    private TableColumn<allocatedequipmentsmodel, String> orderedBy1;
    @FXML
    private TableColumn<allocatedequipmentsmodel, String> Fromtime1;
    @FXML
    private TableColumn<allocatedequipmentsmodel, String> Totime1;
    @FXML
    private TableColumn<allocatedequipmentsmodel, String> EquipmentCost1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public static void userlogggedin(String useridentity) {
     PendingbookingsController.useridentity=useridentity;   
    }
public String loggedinuserid(){
    return useridentity;
}

    @FXML
    public void showpendingbookings() {
        try {
            dbconnection dc;
            dc = new dbconnection();
            Connection conn = dbconnection.ConnectDB();
            data = FXCollections.observableArrayList();
            //query both tables that we need their data that is the equipments and booked equipments where the eqpment Ids matches
            ResultSet rs = conn.createStatement().executeQuery("select equipments.*, bookedeqpmnts.* from  equipments, bookedeqpmnts\n"
                    + "where equipments.eqpID = bookedeqpmnts.eqpID");
            //String sql= "select * from user where username= '"+user+"' and userpassword ='coder'";

            while (rs.next()) {
                System.out.println("The values" + rs.getInt(1));
                //String Sql="SELECT * FROM equipments  Where eqpId='"+rs.getInt(1)+"'";
                PreparedStatement pst;
                // ResultSet rs2=conn.createStatement().executeQuery("SELECT * FROM equipments  Where eqpID='"+rs.getInt(1)+"'");
                // pst=conn.prepareStatement(Sql);
                //rs2= pst.executeQuery();
                //System.out.println("The values" + rs2.getString(2));
                //*********************************************
                //note rs.getString(13) is the to time
                String UserId=rs.getString(9);
                //testing line
                System.out.println("The user ID is "+ UserId);
                ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM users where staff_id='"+UserId+"'");
                while (rs2.next()){
                data.add(new Bookingsdetails(rs.getInt("eqpcost"), rs.getInt(11), rs2.getString(2), rs.getString("eqpname"), rs.getString("Fromdate_time"), rs.getString("Todate_time"),rs.getString("userId"),rs.getInt("bookId")));
            }
            }
            /* System.out.println("The values" + rs.getString(1));
            System.out.println("The values" + rs.getString(2));
            System.out.println("The values" + rs.getString(3));
            System.out.println("The values" + rs.getString(4));*/

            bookedEquipments.setCellValueFactory(new PropertyValueFactory<>("Equipment"));
            Fromtime.setCellValueFactory(new PropertyValueFactory<>("Fromtime"));
            Quantityordered.setCellValueFactory(new PropertyValueFactory<>("quantityordered"));
            orderedBy.setCellValueFactory(new PropertyValueFactory<>("Orderedby"));
            Totime.setCellValueFactory(new PropertyValueFactory<>("Totime"));
            EquipmentCost.setCellValueFactory(new PropertyValueFactory<>("IdEq"));
            bookeditemstable.setItems(null);
            bookeditemstable.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(PendingbookingsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showpendingbookingslayout(String useridentity) {

        try {
            PendingbookingsController.userlogggedin(useridentity);
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Pendingbookings.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Administrator Page for pending bookings");
           
            stage2.setScene(new Scene(root2));
            stage2.show();

        } catch (IOException ex) {
            Logger.getLogger(PendingbookingsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
//******************************************************************************************************//
//This method fills in the values clicked from the table model to their appropriate areas for next transactions
//******************************************************************************************************//
    @FXML
    private void retrieverowclicked(MouseEvent event) {
        Bookingsdetails tablerowclicked = bookeditemstable.getSelectionModel().getSelectedItem();
        txfdequipment.setText(tablerowclicked.getEquipment());
        labeleqpcost.setText(tablerowclicked.getIdEq().toString()+" Kshs");
        labelfromtime.setText("From: "+tablerowclicked.getFromtime());
        labeltotime.setText("To: "+tablerowclicked.getTotime());
        labelquantity.setText("Quantity: "+tablerowclicked.getQuantityordered().toString());
        txfdallocatedto.setText(tablerowclicked.getOrderedby());
        labelkorderuserId.setText(tablerowclicked.getorderuserId());
    }
    public Integer returnbookidselected(){
    Bookingsdetails tablerowclicked = bookeditemstable.getSelectionModel().getSelectedItem();
    Integer bookId=tablerowclicked.getBookingId();
    return bookId;
            }
//*******************************************************************************************************************//
//In this method we allocate a certain user the equipments they have previously booked and then weremove the book from the 
//pending bookings or from the booked eqpmntsDB to Allocated equipments Db 
//then we save the actions in the audit trail that is allocated details saved there
//*********************************************************************************************************************//
    @FXML
    private void Allocateequipment(ActionEvent event) {
        try {
            Bookingsdetails tablerowclicked = bookeditemstable.getSelectionModel().getSelectedItem();
            tablerowclicked.getEquipment();
            //tablerowclicked.
            String Equipment=txfdequipment.getText();
            //Integer cost= Integer.parseInt(labeleqpcost.getText());
            String fromtime=labelfromtime.getText();
            String totime=labeltotime.getText();
            //Integer quantity=Integer.parseInt(labelquantity.getText());
            //Integer userId=Integer.parseInt( labelkorderuserId.getText());
             // this is the user who had borrowed the equipment
            String userId= labelkorderuserId.getText();
             bk= new BooklayoutController();
            String loggedinuserId=bk.loggedinuserId();
            
            //testing line... works as expected
            System.out.println("the logged in user"+loggedinuserId);
            Integer allocate=this.returnbookidselected();
            //we pass the bookid, userId of whoever booked it before and the logged in technician or allocator Id
           fnctns.allocateequipment(allocate,userId,loggedinuserId);
        } catch (SQLException ex) {
            Logger.getLogger(PendingbookingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
  public void addshowallequipments(){
   AddequipmentsController add=new  AddequipmentsController();
        add.showstage();
    }

    @FXML
    private void retrieveallocatedequipments(ActionEvent event) {
            try {
            dbconnection dc;
            dc = new dbconnection();
            Connection conn = dbconnection.ConnectDB();
           // ObservableList<allocatedequipmentsmodel> allocateddetailsdata;
            //data = FXCollections.observableArrayList();
            allocateddetailsdata=FXCollections.observableArrayList();
            ResultSet rs=conn.createStatement().executeQuery("select * from allocatedeqpmnts");
            if(rs.next()){
              //allocatedeqpmnts(`eqpID`,`Userid`,`quantity`, `Fromdate_time`,`Todate_time`,`AllocatedbyID`,`BookID`)VALUES('" + equipmentId + "','" + userID + "','" + quantityordered + "','" + fromdate + "',SYSDATE(),'" + allocatorId + "','" + bookid + "')";
          
            /*DateFormat df= new SimpleDateFormat("MM/dd/YYYY");
            Date from,To;
            try{
            from=df.parse(rs.getString(4));
            To=df.parse(rs.getString(5));
            LocalDate eventfromdate =new LocalDate(from);
            LocalDate eventtodate= To;
            
            Days.daysBetween(from,To);
            }   catch (ParseException ex) {
                    Logger.getLogger(PendingbookingsController.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            //if( rs3.next() && rs4.next()){
          while(rs.next()){
            ResultSet rs2=conn.createStatement().executeQuery("select * from equipments where eqpID='"+rs.getString("eqpID")+"'");
           //allocated person details
            ResultSet rs3=conn.createStatement().executeQuery("select * from users where staff_id='"+rs.getString("userid")+"'");
          //for allocator details
          ResultSet rs4=conn.createStatement().executeQuery("select * from users where staff_id='"+rs.getString(6)+"'");
          if(rs2.next() && rs3.next() && rs4.next()){
  allocateddetailsdata.add(new allocatedequipmentsmodel(
            rs2.getString(2),rs.getString("eqpID"),rs3.getString("Name"), rs.getString("userid"),
            rs4.getString("Name"),rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5),
            rs.getString("AllocationNumber")));
          }
          }    
          
             bookedEquipments1.setCellValueFactory(new PropertyValueFactory<>("equipmentname"));//name
            Fromtime1.setCellValueFactory(new PropertyValueFactory<>("fromdate"));
            Quantityordered1.setCellValueFactory(new PropertyValueFactory<>("quantityAllocated"));
            orderedBy1.setCellValueFactory(new PropertyValueFactory<>("allocatedToName"));
            Totime1.setCellValueFactory(new PropertyValueFactory<>("todate"));
             EquipmentCost1.setCellValueFactory(new PropertyValueFactory<>("allocatedByName"));
            allocateditemstable.setItems(null);
            allocateditemstable.setItems(allocateddetailsdata);
        
            
            }
            else{
            JOptionPane.showMessageDialog(null,"No items allocated yet","Null allocations made ",JOptionPane.INFORMATION_MESSAGE);
            }
            rs.close();
            conn.close();
            
         } catch (SQLException ex) {
            Logger.getLogger(PendingbookingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returnequipment(ActionEvent event) {
        try {
            dbconnection dc;
            dc = new dbconnection();
            Connection conn = dbconnection.ConnectDB();
            PreparedStatement ps;
            //
            allocatedequipmentsmodel tablerowclicked = allocateditemstable.getSelectionModel().getSelectedItem();
            tablerowclicked.getClass();
            tablerowclicked.getAlloctionId();
            String Equipment=txfdequipment.getText();
            String returneqpmnt = "DELETE FROM allocatedeqpmnts WHERE AllocationNumber= '"+tablerowclicked.getAlloctionId()+"' ";
            ps=conn.prepareStatement(returneqpmnt);
            //since the .execute() method returns true if it is a resultset and false if not resultset or simply if it was an update
            //like delete or update query has been executed
           if( ps.execute()==false){
               String ReturnEquipment= "System User" + tablerowclicked.getAllocatedByName()+ ": Returned" +  tablerowclicked.getEquipmentname()+" Quantity :"+ tablerowclicked.getQuantityAllocated()+" "+ ": Earlier Borrowed By:" +  tablerowclicked.getAllocatedToName() + ": Of ID number " +  tablerowclicked.getAllocatedToId() + " ";
                String inserting = " INSERT INTO Audittrail (`Userid`,`date_time`,`Activity`)VALUES('" +this.loggedinuserid() + "',SYSDATE(),'" + ReturnEquipment + "')";
                ps= conn.prepareStatement(inserting);
                ps.execute();
           JOptionPane.showMessageDialog(null,"Successfully Returned the equipment","Successful Return of Equipment",JOptionPane.INFORMATION_MESSAGE);
           }
           else{
           JOptionPane.showMessageDialog(null,"System Failure Retruning the equipment '"+tablerowclicked.getAlloctionId()+"'","Failure Return of Equipment",JOptionPane.INFORMATION_MESSAGE);
                      }
            //Integer cost= Integer.parseInt(labeleqpcost.getText());
            String fromtime=labelfromtime.getText();
            String totime=labeltotime.getText();
            //Integer quantity=Integer.parseInt(labelquantity.getText());
            //Integer userId=Integer.parseInt( labelkorderuserId.getText());
            // this is the user who had borrowed the equipment
            String userId= labelkorderuserId.getText();
            bk= new BooklayoutController();
            String loggedinuserId=bk.loggedinuserId();
            
            //testing line... works as expected
            System.out.println("the logged in user"+loggedinuserId);
            System.out.println(tablerowclicked.getClass());
            //Integer allocate=this.returnbookidselected();
            //we pass the bookid, userId of whoever booked it before and the logged in technician or allocator Id
            // fnctns.allocateequipment(allocate,userId,loggedinuserId);
        } catch (SQLException ex) {
            Logger.getLogger(PendingbookingsController.class.getName()).log(Level.SEVERE, null, ex);
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
