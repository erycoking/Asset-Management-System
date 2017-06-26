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

// this is the model for student object

/**
 *  Contains the name, registration number, the truth value of 
 *  whether or not is group leader and the group they belong to.
 * 
 */
public class Students {
    private String regno;
    private String name;
    private Boolean leader;
    private String group;
    
    public Students() {
      this.regno = "";
      this.name = "";
      this.leader = false;
      this.group = "";
    }
    
    public Students(String regno, String name) {
      this.regno = regno;
      this.name = name;
      this.leader = false;
      this.group = "";
    }

    public String getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
}
