/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeLogin.login2;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
//import lams.Equipments.Equipments;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.image.Image;

/**
 *
 * @author Matthews
 */
public class HomeController implements Initializable {

    private Label label;
    @FXML
    private Button button;
    private TextArea textarea;
    private Label labelcost;
    @FXML
    private Button btnbook;
    @FXML
    private Button imageshow;
    @FXML
    private Button button1;
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXPasswordField txtpassword;
    @FXML
    private Label dialoguelabel;
    Functions1 fnctns=new Functions1();

    @FXML
    private void handleButtonAction(ActionEvent event) {
      

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /*****************************************************************************************************/
    /* This method sets the Tile pane with images of the available equipments from the database*/
     /*****************************************************************************************************/

    public void view() {
        TilePane tile = new TilePane();//create the tilepane layout
        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(15);
        String path = "F:\\phone\\image";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (final File file : listOfFiles) {
            ImageView imageView;
            imageView = createImageView(file);
            //uncooment to see the tile pane with images
           tile.getChildren().addAll(imageView);
        }
    }
   /*****************************************************************************************************/
    //Method to help in creating a new imageview each time we have a new imagefile
    /**
     * @param imageFile
     * @return ***************************************************************************************************/
    public ImageView createImageView(final File imageFile) {
        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
        } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
        return imageView;
    }
    @FXML
    public void showavailable() throws IOException{
    
       /*
        
        
        
      
        Availablelequipments av=new  Availablelequipments();
        //this is the method in the available equipments class that dispalys the images available in the file
        av.display();*/
    }
    /*****************************************************************************************************/
    // The method displayavailabes() handles the loging in to the system after writing in the login details
    //********************************************************************************************************/
    @FXML
    public void displayavailabes(ActionEvent event) throws IOException, SQLException{
        
        //txtusername.onKeyTypedProperty();
       // String query="SELECT * FROM asm.login where username='adminn' && password='th95matttt'";
       String username=txtusername.getText();
       String Password= txtpassword.getText();
       if(txtusername.getText().equals("") && txtpassword.getText().equals("")){
            System.out.println("Please ensure you have written down your correct login details correctly");
            dialoguelabel.setText("Please ensure you have entered your correct login details correctly");
        }
       else{
       
        ((Node) event.getSource()).getScene().getWindow().hide();
         //this logingIn is a method in Functions1 class that checks existence of the user in the database
        fnctns.logingIn(username, Password);
                       }
        }
   
        
        
    }

 
