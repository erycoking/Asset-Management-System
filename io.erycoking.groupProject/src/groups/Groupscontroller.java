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
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;

public class Groupscontroller {
    Connection conn = Connect.ConnectDB();
    Statement stmt = null;
    PreparedStatement ps = null;
    
    // TODO all actions
    public boolean insertIntoGroup() {
        String sql = "INSERT INTO groups(regno,name) VALUES(?,?)";
        try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1,sql);
        }
        catch(SQLException es) {
            System.err.printf("An error occured while inserting groups to db: %s ", es);
        }
       return true;
    }
    
    public boolean deleteFromGroup() {
        
        return true; // if successful delete
    }
    
    public boolean updateGroup() {
        
        return true;
    }
    
    public ArrayList<Groups> getGroup() {
       ArrayList<Groups> groups = new ArrayList<>();
       
       return groups;
    }
    
    public ArrayList<Groups> randomGroups() {
       ArrayList<Groups> groups = new ArrayList<>();
       
       return groups;
    }
}
