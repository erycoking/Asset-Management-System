/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminend;

import beforeLogin.login2.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthews
 */
public class adminfunctions {

      dbconnection dc = new dbconnection();
    PreparedStatement ps;
   Connection conn = dc.ConnectDB();
    ResultSet rs;
    // here the admin will add the equipment to the database then call auditaddequipment()
    public void addequipment(){
        
       
    }
    public void updateequipment(){
        String insert="INSERT INTO EQUIPMENTS (eqpname, eqpcost, eqpdetails, quantity,eqpcategory,date_created)";
       // String x[];
    }
    public void deleteequipment(){
    
    }
     private void auditaddequipment(){
    
    }
      private void auditupdateequipment(){
    
    }
       private void auditdeleteequipment(){
    
    }
public void adduser(String staffname, String staffID, String staffdepartment, String staffrole,String username,String password,String contacts) {
          try {
              dbconnection dc = new dbconnection();
              PreparedStatement ps;
              Connection conn = dc.ConnectDB();
              ResultSet rs;
              String inserting = " INSERT INTO users (`staff_id`,`name`,`username`,`password`,`faculty`,`department`,`telephone_no`,`email`,`role`)VALUES"
                      + "('" +staffID + "','"+staffname+"','"+username+"','"+password+"','"+staffdepartment+"','"+staffdepartment+"','"+contacts+"','"+contacts+"','"+staffrole+"')";
              ps = conn.prepareStatement(inserting);
              ps.execute();
              conn.close();
              JOptionPane.showMessageDialog(null, "Successfully added a User", "Addition Success", JOptionPane.INFORMATION_MESSAGE);

          } catch (SQLException ex) {
              Logger.getLogger(adminfunctions.class.getName()).log(Level.SEVERE, null, ex);
          }
    
        }

   
}
