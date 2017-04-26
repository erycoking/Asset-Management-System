package validate;

import org.apache.commons.validator.routines.RegexValidator;

public class validateEquipInputs {
	public boolean validateEquipID(String id){
		String regex = "([a-zA-Z]+[0-9]+[/]*)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(id);	}
	public boolean validateEquiName(String name){
		String regex = "[a-zA-Z]+[-/]*[a-zA-Z]*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(name);	}
	public boolean validateQuantity(String q){
		String regex = "[1-9]+";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(q);	}
	public boolean validateCurrentValue(String cash){
		String regex = "[0-9]+[.]*([0-9]{2})*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(cash);	}
	public boolean validateDescription(String des){
		String regex = "[a-zA-Z]*[.-/]*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(des);	}	
	public boolean validateDateAcquired(String date){
		String regex = "[0-9]{2}[./-]{1}[0-9][./-]{1}[0-9]{4}";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(date);	}
}
