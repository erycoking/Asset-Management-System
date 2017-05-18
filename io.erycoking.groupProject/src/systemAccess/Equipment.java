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
    private final SimpleIntegerProperty quantity;
     private final SimpleIntegerProperty cost;
     

    public Equipment(int id,String n,int qty, int cst) {
        this.callId = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(n);
        this.quantity = new SimpleIntegerProperty(qty);
        this.cost = new SimpleIntegerProperty(cst);
    }
    
    //set methods
    public void setCallId(int id){
        callId.set(id);
    }
       public void setName(String n){
        name.set(n);
    }
          public void setQuantity(int q){
        quantity.set(q);
    }
             public void setCost(int c){
        cost.set(c);
    }
             
             //get methods
    public int getCallId(){
        return callId.get();
    }
    public String getName(){
        return name.get();
    }
    public int getQuantity(){
        return quantity.get();
    }
    public int getCost(){
        return cost.get();
    }
  
    }

   
    
   
    

