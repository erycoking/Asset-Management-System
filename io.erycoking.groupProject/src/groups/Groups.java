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
public class Groups {
   private String regno;
   private String name;
   private boolean leader;
   
   public Groups() {
     this.regno = "";
     this.name = "";
     this.leader = false;
   }
   
   public Groups(String regno, String name, boolean leader){
       this.regno = regno;
       this.name = name;
       this.leader = leader;
   }

    public String getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
   
}