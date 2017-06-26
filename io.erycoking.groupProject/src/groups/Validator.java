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
     String regex = "[a-zA-Z //s]{2,10}[a-zA-Z]{0,5}('[a-zA-Z]{0,11})";
     System.out.println(s+" "+(!s.isEmpty() && !this.unSafeInput(s) && s.matches(regex)));
     return !s.isEmpty() && !this.unSafeInput(s) && s.matches(regex);
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
