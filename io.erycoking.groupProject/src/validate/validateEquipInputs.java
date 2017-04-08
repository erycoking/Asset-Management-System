package validate;

public class validateEquipInputs {
	public boolean validateEquipID(String id){
		return id.matches("[]");
	}
	public boolean validateEquiName(String name){
		return name.matches("[a-zA-Z]+");
	}
}
