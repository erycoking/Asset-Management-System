/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Matthews
 */
public class Bookingsdetails {

    /*Declare the properties  we are to use ..of the equipments */
    private final StringProperty Equipment; //equipoment name
    private final StringProperty Orderedby;
    private final IntegerProperty quantityordered;
    private final StringProperty Fromtime;
    private final StringProperty Totime;
    private final StringProperty orderuserId;
    private final IntegerProperty BookingId;
    private final IntegerProperty IdEq;//this keeps the equipment cost
    //private final DoubleProperty Quantity;

    public Bookingsdetails(String Equipment, String Orderedby, Integer quantityordered, String Fromtime, Integer IdEq,String Totime,String orderuserId,Integer BookingId) {
        this.Equipment = new SimpleStringProperty(Equipment);
        this.Orderedby = new SimpleStringProperty(Orderedby);
        this.quantityordered = new SimpleIntegerProperty(quantityordered);
        this.Fromtime = new SimpleStringProperty(Fromtime);
        this.IdEq = new SimpleIntegerProperty(IdEq);
        this.Totime=new SimpleStringProperty(Totime);
        this.orderuserId=new SimpleStringProperty(orderuserId);
        this.BookingId=new SimpleIntegerProperty(BookingId);
    }
    //*********************************************************************************************//
    //this is the main constructor we are using in this system
    //**********************************************************************************************//
    public Bookingsdetails(Integer IdEq,Integer quantityordered, String Orderedby,String Equipment,String Fromtime,String Totime,String orderuserId,Integer BookingId) {
        this.Equipment = new SimpleStringProperty(Equipment);
        this.Orderedby = new SimpleStringProperty(Orderedby);
        this.quantityordered = new SimpleIntegerProperty(quantityordered);
        this.Fromtime = new SimpleStringProperty(Fromtime);
        this.IdEq = new SimpleIntegerProperty(IdEq);
        this.Totime=new SimpleStringProperty(Totime);
        this.orderuserId=new SimpleStringProperty(orderuserId);
        this.BookingId=new SimpleIntegerProperty(BookingId);
    }
    public void setEquipment(String value) {
        Equipment.set(value);
    }
  public void setOrderedby(String value){
    Orderedby.set(value);
  }
  public void setquantityordered(Integer value){
      quantityordered.set(value);
  }
  public void setFromtime(String value){
  Fromtime.set(value);
  }
  public void setTotime(String value){
  Totime.set(value);
  }
  public void setIdEq(Integer value){
  IdEq.set(value);
  }
   public void setuserorderId(String value){
      orderuserId.set(value);
  }
    public void setBookingId(Integer value){
      BookingId.set(value);
  }

    public String getEquipment() {
        return Equipment.get();
    }
    /* public Integer getId() {
        return Id.get();
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public String getAvailable() {
        return Available.get();
    }
*/

    public String getOrderedby() {
        return Orderedby.get();
    }

    public Integer getQuantityordered() {
        return quantityordered.get();
    }

    public String getFromtime() {
        return Fromtime.get();
    }
     public String getTotime() {
        return Totime.get();
    }

    public Integer getIdEq() {
        return IdEq.get();
    }
    public String getorderuserId() {
        return orderuserId.get();
    }
    public Integer getBookingId() {
        return BookingId.get();
    }
    

}
