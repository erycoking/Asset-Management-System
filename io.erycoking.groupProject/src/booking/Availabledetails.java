/*The available equipments class model details */
package booking;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Matthews
 */
public class Availabledetails {

    /*Declare the properties  we are to use ..of the equipments */
    private final StringProperty Equipment; //equipoment name
    private final StringProperty Type;
    private final IntegerProperty quantity;
    private final StringProperty Available;
    private final StringProperty Details;
    private final IntegerProperty Id;
    private final IntegerProperty BookID;
    //private final DoubleProperty Quantity;

    public Availabledetails(String Equipment, String Type, Integer quantity, String Available, Integer Id,Integer BookID) {
        this.Equipment = new SimpleStringProperty(Equipment);
        this.Type = new SimpleStringProperty(Type);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.Available = new SimpleStringProperty(Available);
        this.Id = new SimpleIntegerProperty(Id);
         this.BookID = new SimpleIntegerProperty(BookID);
         this.Details=null;
    }
     public Availabledetails(String Equipment, String Type, Integer quantity, String Available,String details,Integer Id,Integer BookID) {
        this.Equipment = new SimpleStringProperty(Equipment);
        this.Type = new SimpleStringProperty(Type);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.Available = new SimpleStringProperty(Available);
        this.Id = new SimpleIntegerProperty(Id);
         this.BookID = new SimpleIntegerProperty(Id);
         this.Details=new SimpleStringProperty(details);
    }

   

    public String getType() {
        return Type.get();
    }

    public String getDetails() {
        return Details.get();
    }
    public Integer getId() {
        return Id.get();
    }
     public Integer getBookID() {
        return BookID.get();
    }

    public Integer getQuantity() {
        return quantity.get();
    }

    public String getAvailable() {
        return Available.get();
    }

    public String getEquipment() {
        return Equipment.get();
    }

    public void setAvailable(String value) {
        Available.set(value);
    }

    public void setType(String value) {
        Type.set(value);
    }
 public void setDetails(String value) {
        Details.set(value);
    }
    public void setEquipment(String value) {
        Equipment.set(value);
    }

    public void setQuantity(Integer value) {
        quantity.set(value);
    }

    public void setId(Integer value) {
        Id.set(value);
    }
    public void setBookID(Integer value) {
        BookID.set(value);
    }

}
