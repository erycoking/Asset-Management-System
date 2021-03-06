package validate;

import org.apache.commons.validator.routines.RegexValidator;

public class validateUserInput {
	public boolean validateId(String id){
		String regex = "([a-zA-Z]+[0-9]+[/]+)+([0-9]+[/-]*)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(id);
	}
	public boolean validateName(String name){
		String regex = "[a-zA-Z]+([ '-][a-zA-Z]+)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(name);
	}
	public boolean validateUsername(String name){
		String regex = "[a-zA-Z]+([ '-][a-zA-Z]+)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(name);
	}
	public boolean validatePassword(String passwd){
		String regex = "\\w{8,}";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(passwd);	}
	public boolean validateFaculty(String fac){
		String regex = "[a-zA-Z]+(\\s[a-zA-Z]+)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(fac);	}
	public boolean validateDepartment(String dep){
		String regex = "[a-zA-Z]+([ ][a-zA-Z]+)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(dep);	}
	public boolean validatePhonenum(String phone){
		String regex = "([07]|[+254]|[254])+\\d{8}";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(phone);	}
	public boolean validateEmail(String email){
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(email);	}
	public boolean validateRole(String role){
		String regex = "[a-zA-z]+";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(role);	}
}
