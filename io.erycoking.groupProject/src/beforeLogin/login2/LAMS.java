/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeLogin.login2;

import booking.BooklayoutController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Matthews
 */
public class LAMS extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Functions1 functions = new Functions1();
        functions.showimagesavailabe();
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
