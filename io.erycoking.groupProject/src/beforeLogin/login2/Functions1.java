/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeLogin.login2;

import adminend.SuperadminController;
import booking.AddequipmentsController;
import booking.BooklayoutController;
import technicians.PendingbookingsController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import views.BooklayoutController;

/**
 *
 * @author Matthews
 */
public class Functions1 {

    
    PreparedStatement ps;
     ResultSet rs;
   
            //AddequipmentsController addeqpmn = new AddequipmentsController();

        public void showimagesavailabe() throws FileNotFoundException {

        try {

            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:images/matthews.jpg"));
            AnchorPane root = new AnchorPane();
            TilePane sp = new TilePane();
            sp.setPadding(new Insets(5, 5, 5, 5));
            //sp.setHgap(15);
            sp.setLayoutY(0);
            sp.setLayoutX(5);
            String path = "image";

            Scene scene = new Scene(root, 300, 250);

            root = FXMLLoader.load(getClass().getResource("Index.fxml"));
            root.setStyle("-fx-background-color: #fb8c00");
            //root.setBackground(Background.EMPTY);
            //root.setBorder(Border.red);
            root.getChildren().add(sp);

            scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(Functions1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void auditlogin(String userID) throws SQLException {
        dbconnection dc = new dbconnection();
         Connection conn = dc.ConnectDB();
            String inserting = " INSERT INTO Audittrail (`Userid`,`date_time`,`Activity`)VALUES('" + userID + "',SYSDATE(),'Logged in to LAMS')";
            ps = conn.prepareStatement(inserting);
            ps.execute();
        
    }

    public void auditbooking(String userID, Integer eqpid, Integer quantity) throws SQLException {
        //"select equipments.*, bookedeqpmnts.* from  equipments, bookedeqpmnt where equipments.eqpID = bookedeqpmnts.eqpID"
        dbconnection dc = new dbconnection();
        Connection conn = dc.ConnectDB();
        String name = null;
        String eqpname = null;
        try ( //testing line
        //System.out.println("User ID"+ userID+"Eqp Id"+eqpid+"quantity"+quantity);
        //works as expected
                ResultSet rs3 = conn.createStatement().executeQuery("select equipments.*, users.* from  equipments, users where equipments.eqpID ='" + eqpid + "' and users.staff_id='" + userID + "'")) {
            while (rs3.next()) {
                // note you need to positionyour cursor on the first row of the resultset and not at the very begginning where you have no results resultset.next() helps us do this
                name = rs3.getString(10);//the table column for users name as registered
                eqpname = rs3.getString(2);
                //testing line
                //System.out.println("name:"+name +" equimnt Name: "+eqpname);
                //works as expected
            }
            String booking = "User " + name + ": Logged in and booked " + quantity + " " + eqpname + " in number.";
            String inserting = " INSERT INTO Audittrail (`Userid`,`date_time`,`Activity`)VALUES('" + userID + "',SYSDATE(),'" + booking + "')";
            ps = conn.prepareStatement(inserting);
            ps.execute();
        }
        conn.close();
    }

    public void auditallocating(Integer bookid, String UserID, String allocatorId) throws SQLException {
        try {
            dbconnection dc = new dbconnection();
            Connection conn = dc.ConnectDB();
            String allocatorname;
            String USER = null;
            String Equipmentname = null;
            Integer bookedeqpmntId = 0;
            Integer quantityallocated = 0;
            String allocating = " User/Technician +technician name+ allocated +username+:+ equipment+: quantity:5+quantityordered+ ";
            
            rs = conn.createStatement().executeQuery("SELECT * FROM users WHERE staff_id='" + allocatorId + "'");
            if (rs.next()) {
                allocatorname = rs.getString(2);

                rs = conn.createStatement().executeQuery("SELECT * FROM users WHERE staff_id='" + UserID + "'");
                while (rs.next()) {
                    USER = rs.getString(2);
                }
                rs = conn.createStatement().executeQuery("SELECT * FROM bookedeqpmnts WHERE BookID='" + bookid + "'");
                while (rs.next()) {
                    bookedeqpmntId = rs.getInt(1);
                    quantityallocated = rs.getInt(2);
                }
                rs = conn.createStatement().executeQuery("Select * from equipments where eqpID='" + bookedeqpmntId + "'");
                while (rs.next()) {
                    Equipmentname = rs.getString(2);
                }
                String booking = "User " + allocatorname + ": Logged in and allocated " + USER + " " + quantityallocated + " " + Equipmentname + " in number.";
                String inserting = " INSERT INTO Audittrail (`Userid`,`date_time`,`Activity`)VALUES('" + UserID + "',SYSDATE(),'" + booking + "')";
                ps = conn.prepareStatement(inserting);
                ps.execute();
                rs.close();
                conn.close();
                System.out.println("Congratulations,You successfully audited the allocation");
            } else {
                System.out.println("You are not logged in to allocate equipments here");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Functions1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void logingIn(String username, String password) throws SQLException {
        dbconnection dc = new dbconnection();
        Connection conn = dc.ConnectDB();
        rs = conn.createStatement().executeQuery("SELECT * FROM users where username='" + username + "' && password='" + password + "'");
        BooklayoutController bk = new BooklayoutController();
        if (rs.next()) {
            //If there exists such a user the following is executed. and we need to pass the user ID to be able to monitor them
            String UserIdentity = rs.getString(1);
            String name=rs.getString("Name");
            //Functions1 fnctns=new Functions1();
            //fnctns.
           
            
            switch (rs.getString("role")) {
                //display the window with the priorities of a super admin
                case "superadmin":
                    //TESTING LINE
                    System.out.println("You are the super user/admin");
                     SuperadminController superadmin=new SuperadminController ();
                    superadmin.showstagetable(UserIdentity);
                     break;
                case "admin":
                    //the technicians window with priorities/responsibilities granted technician
                   PendingbookingsController pendings=new PendingbookingsController();
                    pendings.showpendingbookingslayout();
                    
                    bk.useridentity(UserIdentity);

                    break;
                default:
                    //method showstagetable is only shown if there are such credentials hence you wont view the next window if not logged in
                    bk.showstagetable(UserIdentity,username);
                    //we call this method to return the logged in user's Id to keep track of them
                    bk.useridentity(UserIdentity);
                    break;

            }
          auditlogin(UserIdentity);
          rs.close();
          conn.close();
            
        } else {
            rs.close();
            conn.close();//close the connection before then output
            System.out.println("THE credentials does not exist");

        }
        //conn.close();//close the database connection
    }

    //**************************************************************************************************************//
    //This method bookitem takes in the equipment id quantity oredered the logged in user Identification number, and from time
    //It then calculates the remaining quantity after the order and then returns the remaining commodities number
    //***************************************************************************************************************//
    public Integer bookitem(Integer EqpId, Integer quantity, String useridentification, LocalDate fromtime, LocalDate Todate) throws SQLException {
        /*checks the id and  removes that item from unbooked eqpmnts db then puts 
        the item into booked db and qtty booked too.. then updates the unbooked 
        db qtty field by reducing by ordered amount 
         */
        dbconnection dc = new dbconnection(); 
        Connection conn = dc.ConnectDB();
        String inserting = " INSERT INTO bookedeqpmnts (`eqpID`, `quantity`, `Fromdate_time`,`Todate_time`,`Userid`)VALUES('" + EqpId + "','" + quantity + "','" + fromtime + "','" + Todate + "','" + useridentification + "')";
        ps = conn.prepareStatement(inserting);
        ps.execute();
        rs = conn.createStatement().executeQuery("SELECT * FROM unbookedeqpmnts where eqpID='" + EqpId + "'");
        Integer ordered = quantity;
        //= Integer.parseInt(quantity);
        int remaining = 0;
        while (rs.next()) {
            //calculate the remaining eqpments and set the variable for updating the database
            remaining = rs.getInt(5) - ordered;
        }
        System.out.println("remainders" + remaining);
        //we have to use the remaining value to be able to drop the raw with zero or no equipment available
        //for booking
        if (remaining == 0) {
            //if there are no remaining equipments remove the equipment from the unbooked list
            String Delete = "DELETE FROM unbookedeqpmnts WHERE quantity=0 ";
            String Update = "UPDATE unbookedeqpmnts SET quantity='" + remaining + "' Where eqpID='" + EqpId + "'";
            ps = conn.prepareStatement(Delete);
            ps.execute();
            ps = conn.prepareStatement(Update);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful Booking", "Booked all of these Equipment", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            String Update = "UPDATE unbookedeqpmnts SET quantity='" + remaining + "' Where eqpID='" + EqpId + "'";
            ps = conn.prepareStatement(Update);
            ps.execute();
            //we the audit the booking ction
            rs.close();
            conn.close();
            this.auditbooking(useridentification, EqpId, quantity);
            JOptionPane.showMessageDialog(null, "Successful Booking", "Booking completed", JOptionPane.INFORMATION_MESSAGE);
        }

        return remaining;

    }

    public void allocateequipment(Integer bookid, String userID, String allocatorId) throws SQLException {
        Integer equipmentId = 0;
        String quantityordered=null;
        String fromdate = null;
        String todate = null;
        dbconnection dc = new dbconnection();
        Connection conn = dc.ConnectDB();
        rs = conn.createStatement().executeQuery("SELECT * FROM bookedeqpmnts where BookID='" + bookid + "'");
        while (rs.next()) {
            equipmentId = rs.getInt(1);
            quantityordered = rs.getString("quantity");
            fromdate = rs.getString(3);
            todate = rs.getString(4);
            System.out.println("The from date is" + fromdate);
            String inserting = " INSERT INTO allocatedeqpmnts(`eqpID`,`Userid`,`quantity`, `Fromdate_time`,`Todate_time`,`AllocatedbyID`,`BookID`)VALUES('" + equipmentId + "','" + userID + "','" + quantityordered + "','" + fromdate + "',SYSDATE(),'" + allocatorId + "','"+bookid+"')";
            ps = conn.prepareStatement(inserting);
            ps.execute();
            //after we allocate an equipment we have to remove it from the bookdequipments table
            String Delete = "DELETE FROM bookedeqpmnts WHERE BookID='"+bookid+"' ";
            ps = conn.prepareStatement(Delete);
            ps.execute();

        }
        this.auditallocating(bookid, userID, allocatorId);
         PendingbookingsController pendings=new PendingbookingsController();
        pendings.showpendingbookingslayout();

    }

    

    public void auditunbooking(String userID, String equipment, Integer bookID, String type) {
    try {
        dbconnection dc = new dbconnection();
        Connection conn = dc.ConnectDB();
        String unbooking="Unbooked the previous booking of"+equipment+ ": Book  reference Number"+ bookID;
            String inserting = " INSERT INTO Audittrail (`Userid`,`date_time`,`Activity`)VALUES('" + userID + "',SYSDATE(),'"+unbooking+"')";
            ps = conn.prepareStatement(inserting);
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Functions1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
