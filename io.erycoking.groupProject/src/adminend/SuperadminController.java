/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matthews
 */
public class SuperadminController implements Initializable {

    @FXML
    private TableView<?> tableaudits;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void showstagetable(String useridentity){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("superadmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:images/matthews.jpg"));
            stage.setTitle("These Are the Available Equipments and this is Your Identity Number If not please contact admin: "+useridentity);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SuperadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
