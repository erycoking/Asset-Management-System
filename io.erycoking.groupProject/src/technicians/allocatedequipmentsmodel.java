/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technicians;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Matthews
 */

public class allocatedequipmentsmodel {
    
    private final StringProperty equipmentname;
    private final StringProperty equipmentId;
    private final StringProperty allocatedToName;
    private final StringProperty allocatedToId;
    private final StringProperty allocatedByName;
    private final StringProperty allocatedById;
    private final IntegerProperty quantityAllocated;
    private final StringProperty fromdate;
    private final StringProperty todate;
    private final StringProperty datedelayed;
    private final StringProperty finedue;
    private final StringProperty allocationId;
    private final StringProperty BookID;

    public allocatedequipmentsmodel(String equipmentname, String equipmentId, String allocatedToName, String allocatedToId, String allocatedByName, String allocatedById, Integer quantityAllocated, String fromdate,String todate,String allocationId,String BookID) {
        this.equipmentname = new SimpleStringProperty(equipmentname);
        this.equipmentId = new SimpleStringProperty(equipmentId);
        this.allocatedToName = new SimpleStringProperty(allocatedToName);
        this.allocatedToId =new SimpleStringProperty( allocatedToId);
        this.allocatedByName =new SimpleStringProperty(allocatedByName);
        this.allocatedById = new SimpleStringProperty(allocatedById);
        this.quantityAllocated =new SimpleIntegerProperty( quantityAllocated);
        this.fromdate = new SimpleStringProperty(fromdate);
        this.todate =new SimpleStringProperty(todate);
        this.datedelayed =null;//new SimpleStringProperty(datedelayed);
        this.finedue =null; //new SimpleStringProperty(finedue); to be implemented later incase they ask for fine
        this.allocationId=new SimpleStringProperty(allocationId);
         this.BookID=new SimpleStringProperty(BookID);
    }

    public String getEquipmentname() {
        return equipmentname.get();
    }

    public String getEquipmentId() {
        return equipmentId.get();
    }

    public String getAllocatedToName() {
        return allocatedToName.get();
    }

    public StringProperty getAllocatedToId() {
        return allocatedToId;
    }

    public String getAllocatedByName() {
        return allocatedByName.get();
    }

    public StringProperty getAllocatedById() {
        return allocatedById;
    }

    public Integer getQuantityAllocated() {
        return quantityAllocated.get();
    }

    public String getFromdate() {
        return fromdate.get();
    }

    public String getTodate() {
        return todate.get();
    }

    public String getDatedelayed() {
        return datedelayed.get();
    }

    public String getFinedue() {
        return finedue.get();
    }
     public String getAlloctionId() {
        return allocationId.get();
    }
      public String getBookId() {
        return BookID.get();
    }
      public void setEquipmentname(String value) {
        equipmentname.set(value);
    }

    public void setEquipmentId(String value) {
       equipmentId.set(value);
    }

    public void setAllocatedToName(String value) {
        allocatedToName.set(value);
    }

    public void setAllocatedToId(String value) {
         allocatedToId.set(value);
    }

    public void setAllocatedByName(String value) {
         allocatedByName.set(value);
    }

    public void setAllocatedById(String value) {
        allocatedById.set(value);
    }

    public void setQuantityAllocated(Integer value) {
        quantityAllocated.set(value);
    }

    public void setFromdate(String value) {
        fromdate.set(value);
    }

    public void setTodate(String value) {
       todate.set(value);
    }

    public void setDatedelayed(String value) {
         datedelayed.set(value);
    }
    public void setFinedue(String value){
    finedue.set(value);
    }
    public void setAllocationId(String value){
    allocationId.set(value);
    }
    public void setBookId(String value){
   BookID.set(value);
    }
   
    
}
