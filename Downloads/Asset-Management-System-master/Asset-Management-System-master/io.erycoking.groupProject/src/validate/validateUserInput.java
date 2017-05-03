package validate;

public class validateUserInput {
	public boolean validateId(String id){
		return id.matches("([a-zA-Z]+[0-9]+[/]+)+([0-9]+[/-]*)*");
	}
	public boolean validateUsername(String name){
		return name.matches("[a-zA-Z]+([ '-][a-zA-Z]+)*");
	}
	public boolean validatePassword(String passwd){
		return passwd.matches("\\w{8,}");
	}
	public boolean validateFaculty(String fac){
		return fac.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*");
	}
	public boolean validateDepartment(String dep){
		return dep.matches("[a-zA-Z]+([ ][a-zA-Z]+)*");
	}
	public boolean validatePhonenum(String phone){
		return phone.matches("([07]|[+254]|[254])+\\d{8}");
	}
}
