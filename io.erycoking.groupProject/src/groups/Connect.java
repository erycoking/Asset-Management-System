/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groups;

/**
 *
 * @author makwata
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// this class connects to the database
public class Connect {
    
    Connection conn = null;
    
    // returns a connection to the database
    public static Connection ConnectDB() {
        try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asset_management?autoReconnect=true&useSSL=false", "root", "geek");
          return conn;
        }
        catch(SQLException | ClassNotFoundException se) {
           System.out.println("Error connecting to db : "+se);
           return null;
        }
    }
}
