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
    private final StringProperty name; //equipoment name
    private final StringProperty activity;
    private final StringProperty role;
    private final StringProperty date;
    private final StringProperty department;
    private final IntegerProperty Id;
    private final IntegerProperty BookID;
    //private final DoubleProperty Quantity;

    public Auditadminbean(String name, String activity, String date) {
        this.name = new SimpleStringProperty(name);
        this.activity = new SimpleStringProperty(activity);
        this.role = null;
        this.date= new SimpleStringProperty(date);
        this.Id = null;
         this.BookID = null;
         this.department=null;
    }
    //constructor used for Users
     //USERRS name,Id,,department, role
     public Auditadminbean(String name, String department, Integer id,String role) {
        this.name = new SimpleStringProperty(name);
        this.activity = null;
        this.role = new SimpleStringProperty(role);
        this.date= null;
        this.Id = new SimpleIntegerProperty(id);
         this.BookID = null;
         this.department=new SimpleStringProperty(department);
    }
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
    public Integer getId() {
        return Id.get();
    }
     public Integer getBookID() {
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

    public void setId(Integer value) {
        Id.set(value);
    }
    public void setBookID(Integer value) {
        BookID.set(value);
    }

}
