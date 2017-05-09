/*The available equipments class model details */
package booking;

import javafx.beans.property.DoubleProperty;
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
    private final IntegerProperty Id;
    //private final DoubleProperty Quantity;

    public Availabledetails(String Equipment, String Type, Integer quantity, String Available, Integer Id) {
        this.Equipment = new SimpleStringProperty(Equipment);
        this.Type = new SimpleStringProperty(Type);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.Available = new SimpleStringProperty(Available);
        this.Id = new SimpleIntegerProperty(Id);
    }

    public String getType() {
        return Type.get();
    }

    public Integer getId() {
        return Id.get();
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

    public void setEquipment(String value) {
        Equipment.set(value);
    }

    public void setQuantity(Integer value) {
        quantity.set(value);
    }

    public void setId(Integer value) {
        Id.set(value);
    }

}