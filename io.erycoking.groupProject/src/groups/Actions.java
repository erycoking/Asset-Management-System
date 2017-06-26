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
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Actions {
    Connection conn = Connect.ConnectDB();
    ArrayList<Students> students = new ArrayList<>();
    Formatvalue format = new Formatvalue();
    
    // method for adding students into the database    
    public void addStudent(Students student) {
        try{
            String sql = "INSERT INTO students(regno, name, leader) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, format.formatInput(student.getRegno()));
            ps.setString(2, student.getName());
            ps.setInt(3,0);
            ps.executeUpdate();
        }
        catch(SQLException se) {
           System.out.println("Error inserting student record into DB :");
           System.out.println(se);
        }
    }
    
    // method for updating student records in the database
    public void updateStudent(String name, String regno) {
      try {
          String sql = "UPDATE students SET name = ? WHERE regno = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, name);
          ps.setString(2, format.formatInput(regno));
          ps.executeUpdate();
      }
      catch(SQLException se) {
        System.out.println("Error inserting student record into DB :");
        System.out.println(se);
      }
    }
    
    // method for deleting students into the database
    public void deleteStudent(String regno) {
      try{
       String sql = "DELETE from students WHERE regno = "+"\""+format.formatInput(regno)+"\"";
       Statement stmt = conn.createStatement();
       stmt.executeUpdate(sql);
     }
     catch(SQLException se) {
       System.out.println("Error deleting a student record from DB :");
       System.out.println(se);
     }
    }
    
    // method for fetching students from the database
    public ArrayList<Students> getStudents() {
      try{
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
          students.add(new Students(format.formatOutput(rs.getString("regno")), rs.getString("name")));
        }
      }
      catch(SQLException se) {
        System.out.println("An error occured while fetching student from DB :");
        System.out.println(se);
      }
      return students;
    }
}
