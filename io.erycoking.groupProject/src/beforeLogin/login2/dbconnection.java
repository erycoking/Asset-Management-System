/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeLogin.login2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthews
 */
public class dbconnection {
    
     Connection con=null;
   
        public static Connection ConnectDB(){
             try{
           
          Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asset_management","root","geek");
          return con;
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
    }      
}
public void closeDB(){
    
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
         }

}
    
}
