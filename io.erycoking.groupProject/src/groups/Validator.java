/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groups;

/**
 *
 * @author makwata
 */
public class Validator {
     // A list of bad inputs to filter
     private enum BadInput{
     INSERT,
     SELECT,
     DELETE,
     UPDATE,
     FROM,
     WHERE
   }
    
   // Validate if its a valid registration number
   public boolean isValidRegno(String s){
      String regex = "[A-Z]{1,2}[0-9]{1,2}[//][0-9]{5,6}[//][0-9]{2}"; // ie S12/162626/18
      System.out.println(s+" "+(!s.isEmpty() && s.matches(regex)));
      return !s.isEmpty() && s.matches(regex);
   }
   
   // Validate if its a valid name
   public boolean isValidName(String s) {
     String regex = "[A-Za-z \\s]{2,12}('[A-Za-z]{0,11})";
     String regex1 = "[A-Za-z \\s]{2,12}[A-Za-z]{0,11}";
     System.out.println(s+" "+(!s.isEmpty() && !this.unSafeInput(s) && (s.matches(regex) || s.matches(regex1))));
     return !s.isEmpty() && !this.unSafeInput(s) && (s.matches(regex) || s.matches(regex1));
  }
   
    // if not a safe input return true
   private boolean unSafeInput(String s) {
       String h = s.toUpperCase();
       for(BadInput badInput: BadInput.values()) {
           if(badInput.toString().contains(h)) {
             return true;
           }
       }
       return false;
   }
   
}
