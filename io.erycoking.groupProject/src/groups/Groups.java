/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groups;

/**
 *
 * @author philnzau
 */
public class Groups {
    private String name;
    private String registration;
    
    // getters
    public String getName() {
     return this.name;
    }
    
    public String getRegistration() {
      return this.registration;
    }
    
    // constructor which is used to set the values
    public Groups(String regno, String name) {
      this.registration = regno;
      this.name = name;
    }
    
}
