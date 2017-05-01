/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KaberereG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class connect{
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
     public connect() {
     }
     public static Connection getConnection() throws SQLException{
    try{
         Class.forName("com.mysql.jdbc.Driver"); 
         String url="jdbc:mysql://localhost:3306/equipment"+"?verifyServerCertificate=false"+"&useSSL=false"+"&requireSSL=false";
         con= DriverManager.getConnection(url,"grace","grace");
        st=con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Error here");
        }
    return con;
    }

    public ArrayList<Equipment> getData(){
      ArrayList<Equipment> list=new ArrayList<>();
        try{
            String query="select * from equipment_table";
            rs=st.executeQuery(query);
           // System.out.println("Records from database");
            while(rs.next()){
                Integer callid=rs.getInt("CallID");
                String name=rs.getString("name");
                Integer quantity=rs.getInt("quantity");
                Integer cost=rs.getInt("cost");
                
                list.add(new Equipment(callid,name,quantity,cost));
             
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
        return list;    }
    
}
