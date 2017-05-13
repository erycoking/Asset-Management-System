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

public class CRUD {
    Connection conn = Connect.ConnectDB();
    
    public void addStudent(Student student) {
        try {
         String sql = "INSERT INTO STUDENTS(regno, name) VALUES(?,?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, student.getRegno());
         ps.setString(2, student.getName());
         ps.executeUpdate();
        }
        catch(SQLException se){
          System.out.println("Error inserting student record into DB :"+se);
        }
    }
    
    public void deleteStudent(String query) {
     try{
       String sql = "DELETE from students WHERE regno = "+query;
       Statement stmt = conn.createStatement();
       stmt.executeUpdate(sql);
     }
     catch(SQLException se) {
       System.out.println("Error deleting a student record from DB :"+se);
     }
    }
    
    public void updateStudent(String regno, String name) {
       try{
        String sql = "UPDATE students SET name = ? WHERE regno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, regno);
        ps.executeUpdate();
       }
       catch(SQLException se) {
         System.out.println("An error occured while changing student record :"+se);
       }
    }
    
    public void fetchStudents() {
     try{
      String sql = "SELECT * FROM students";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()) {
       String regno = rs.getString("regno");
       String name = rs.getString("name");
      }
     }
     catch(SQLException se) {
       System.out.println("An error occured while fetching student from DB :"+se);
     }
    }
    
    public void createRandomStudentList() {
    
    }
}

