/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

/**
 *
 * @author philnzau
 */
import org.apache.commons.validator.routines.RegexValidator;

public class validateGroupInputs {
    public boolean validateRegno(String regno) {
                String regex = "([A-Z]+[0-9]{2}+[/]+)+([0-9]+[/-]*)*";
		RegexValidator validator = new RegexValidator(regex);
		return validator.isValid(regno);
    } 
}
