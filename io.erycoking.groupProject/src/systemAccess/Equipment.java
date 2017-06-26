/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemAccess;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author USER
 */
public class Equipment {
 private final SimpleIntegerProperty callId;
   private final SimpleStringProperty name;
     private final SimpleIntegerProperty cost;
     private final SimpleStringProperty eqpDetails;
      private final SimpleIntegerProperty quantity;
      private final SimpleStringProperty eqpCategory;
      private final SimpleStringProperty dateCreated;
      
 
   public Equipment(){
       this.name=new SimpleStringProperty();
       this.callId=new SimpleIntegerProperty();
       
       this.cost=new SimpleIntegerProperty();
       this.eqpDetails=new SimpleStringProperty();
       this.quantity=new SimpleIntegerProperty();
       this.eqpCategory=new SimpleStringProperty();
       this.dateCreated=new SimpleStringProperty();
   }
       
    
    public Equipment(int id,String n,int cst,String ed,int qty,String ec,String dc) {
        this.callId = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(n);
        this.cost = new SimpleIntegerProperty(cst);
         this.eqpDetails=new SimpleStringProperty(ed);
        this.quantity = new SimpleIntegerProperty(qty);
        this.eqpCategory=new SimpleStringProperty(ec);
        this.dateCreated=new SimpleStringProperty(dc);
    }

   
       
    
    //set methods
   public void setCallId(int id){
        callId.set(id);
    }
       public void setName(String n){
        name.set(n);
    }
      
             public void setCost(int c){
        cost.set(c);
    }
              public void setEqpDetails(String eqd){
           eqpDetails.set(eqd);
       }
                public void setQuantity(int q){
        quantity.set(q);
    }
                 public void setEqpCategory(String eqc){
           eqpCategory.set(eqc);
       }
                 public void setDateCreated(String dc){
        dateCreated.set(dc);
    }
             
             //get methods
    public int getCallId(){
        return callId.get();
    }
    public String getName(){
        return name.get();
    }
     
      public int getCost(){
        return cost.get();
    }
       public String getEqpDetails(){
        return eqpDetails.get();
    }
    public int getQuantity(){
        return quantity.get();
    }
  
  public String getEqpCategory(){
        return eqpCategory.get();
    }
   public String getDateCreated(){
        return dateCreated.get();
    }
    }

   
    
   
    

