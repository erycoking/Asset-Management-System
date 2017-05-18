/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeLogin.login2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 *
 * @author Matthews
 */
public class Images {
     public void showimage(String url){
         try {
             //create image
             Image image=new Image( new FileInputStream(url));
             Integer height=(int)image.getHeight();
             Integer width=(int)image.getWidth();
             //writable image
             WritableImage writableimage= new WritableImage(height,width);
             //pixelreader
             PixelReader reader=image.getPixelReader();
             //pixelwriter
           //  PixelWriter writer=image.getPixelWriter();
             
             //read color
             //setcolor/image
             
                     } catch (FileNotFoundException ex) {
             Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
}
