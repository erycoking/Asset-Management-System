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
public class Student {
    
    private String regno;
    private String name;
    
    public Student() {
      this.regno = "";
      this.name = "";
    }
    
    public Student(String regno, String name) {
      this.regno = regno;
      this.name = name;
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
    
    
}
