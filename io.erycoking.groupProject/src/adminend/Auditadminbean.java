/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Matthews
 */
public class Auditadminbean {
    
     /*Declare the properties  we are to use ..of the audits */
    //AUDIT USERS NAME, DATE ACTIVITY
    //USERRS name,Id,,department, role
    private final StringProperty name; //equipoment name and user name in users
    private final StringProperty activity; //also faculty in users
    private final StringProperty role; //role in users too
    private final StringProperty date; //username
    private final StringProperty department; //also department in users
    private final StringProperty Id;           //Staff_id in users  email,
    private final StringProperty BookID; //telephone number in users
    private final StringProperty email; //email for users
    //private final DoubleProperty Quantity;

    public Auditadminbean(String name, String userid,String activity, String date) {
        this.name = new SimpleStringProperty(name);
        this.activity = new SimpleStringProperty(activity);
        this.role = new SimpleStringProperty(date);
        this.date= new SimpleStringProperty(date);
        this.Id = new SimpleStringProperty(userid);
         this.BookID = new SimpleStringProperty(userid);
         this.department=new SimpleStringProperty(userid);
         this.email=new SimpleStringProperty("");
    }
    public Auditadminbean(String name, String userid,String faculty, String username,String email,String role,String telephone,String department) {
        this.name = new SimpleStringProperty(name);
        this.activity = new SimpleStringProperty(faculty);
        this.role = new SimpleStringProperty(role);
        this.date= new SimpleStringProperty(username);
        this.Id = new SimpleStringProperty(userid);
         this.BookID = new SimpleStringProperty(telephone);
         this.department=new SimpleStringProperty(department);
         this.email=new SimpleStringProperty(email);
    }
    //constructor used for Users
     //USERRS name,Id,,department, role
    /* public Auditadminbean(String name, String department, String id,String role) {
        this.name = new SimpleStringProperty(name);
        this.activity = null;
        this.role = new SimpleStringProperty(role);
        this.date= null;
        this.Id = new SimpleStringProperty(id);
         this.BookID = null;
         this.department=new SimpleStringProperty(department);
    }*/
   /*public Auditadminbean(String Equipment, String Type, Integer quantity, String Available,String details,Integer Id,Integer BookID) {
        this.Equipment = new SimpleStringProperty(Equipment);
        this.Type = new SimpleStringProperty(Type);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.Available = new SimpleStringProperty(Available);
        this.Id = new SimpleIntegerProperty(Id);
         this.BookID = new SimpleIntegerProperty(Id);
         this.Details=new SimpleStringProperty(details);
    }*/

   

    public String getActivity() {
        return activity .get();
    }

    public String getDepartment() {
        return department.get();
    }
    public String getId() {
        return Id.get();
    }
     public String getBookID() {
        return BookID.get();
    }

    public String getRole() {
        return role.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getName() {
        return name.get();
    }
    public String getEmail() {
        return email.get();
    }

    public void setDate(String value) {
        date.set(value);
    }

    public void setActivity (String value) {
        activity .set(value);
    }
 public void setDepartment(String value) {
        department.set(value);
    }
    public void setName(String value) {
        name.set(value);
    }

    public void setRole(String value) {
        role.set(value);
    }

    public void setId(String value) {
        Id.set(value);
    }
    public void setBookID(String value) {
        BookID.set(value);
    }
     public void setEmail(String value) {
        email.set(value);
    }

}
