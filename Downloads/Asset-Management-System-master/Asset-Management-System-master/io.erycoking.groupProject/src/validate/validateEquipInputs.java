package validate;

public class validateEquipInputs {
	public boolean validateEquipID(String id){
		return id.matches("([a-zA-Z]+[0-9]+[/]*)*");
	}
	public boolean validateEquiName(String name){
		return name.matches("[a-zA-Z]+[-/]*[a-zA-Z]*");
	}
	public boolean validateQuantity(String q){
		return q.matches("[1-9]+");
	}
	public boolean validateCurrentValue(String cash){
		return cash.matches("[0-9]+[.]*([0-9]{2})*");
	}
	public boolean validateDescription(String des){
		return des.matches("[a-zA-Z]*[.-/]*");
	}	
	public boolean validateDateAcquired(String date){
		return date.matches("[0-9]{2}[./-]{1}[0-9][./-]{1}[0-9]{4}");
	}
}
