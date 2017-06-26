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

import javafx.application.Application;
import javafx.stage.Stage;

public class UI extends Application {
    UIgroup uigroup = new UIgroup();
    
   @Override
   public void start(Stage stage){
       stage.setTitle("asset management system");
       stage.setWidth(1080);
       stage.setHeight(720);
       uigroup.showUi(stage);
       stage.show();
   }
   
   public static void main(String[] args) {
       launch(args);
   }
}
