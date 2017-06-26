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
public class Formatvalue {
   /* take an input with backslash and format it replacing '/' with '&'
    * this is done since mySQL does not support '/' as input.
    *
    */
    public String formatInput(String s) {
       String h = s.replace("/", "&");
       System.out.println(h);
       return h;
    }
   
   public String formatOutput(String s) {
       String a = s.replace("&", "/");
       return a;
   }
   
}
