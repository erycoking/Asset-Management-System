/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groups;

/**
 *
 * @author philnzau
 */

/*
*Connecting to the database is done here
*
*/
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connect {
    
    static final String JDBC_URL = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/asm?autoReconnect=true&useSSL=false";
    
    static final String User = "username";
    static final String Pass = "password";
    
    public static Connection ConnectDB() {
       try {
        Class.forName(JDBC_URL);
        Connection conn = DriverManager.getConnection(DB_URL, User, Pass);
        return conn;
       }
       catch(ClassNotFoundException | SQLException se) {
         System.err.println("Error connecting to db : "+se);
         return null;
       }
    }
}
