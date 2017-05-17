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
}
