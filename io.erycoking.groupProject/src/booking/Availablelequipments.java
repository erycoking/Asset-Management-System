/*
 * The available equipments controller class
 */
package booking;

import beforeLogin.login2.dbconnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import lams.dbconnection;

/*
 * @author Matthews
 */
public class Availablelequipments implements Initializable {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /*The method with call method to images loading and redirects to book method after clicking book button*/
    public void display() throws FileNotFoundException, IOException {
        Stage stage = new Stage();
        AnchorPane root = new AnchorPane();
        //ScrollPane root=new ScrollPane();
        //ScrollPane scrpane=new ScrollPane();
        TilePane sp = new TilePane();
        sp.setId("tilepane");
        sp.setStyle("fx:id=tilepane");
        //sp.getId().equals();
        sp.setPadding(new Insets(5, 5, 5, 5));
        sp.setHgap(15);
        sp.setLayoutY(0);
        sp.setLayoutX(5);
        String path = "image";
        /*while ther exists a file with the name like one in db image column add to list of files*/

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        //File file = new File("image/matt.jpg");
//String path ="\"@../../image/matt.jpg\"";
//E:\\web\\c alc\\
        for (final File file : listOfFiles) {
            //Image img = new Image(file.toURI().toString());
/*use if to check if they match with theone in the result set*/
            final Image image = new Image(new FileInputStream(file));
            //150, 0, true,true);
            ImageView imgView = new ImageView(image);
            Button booking = new Button();
            TextField quantity = new TextField();
            Label quantit = new Label();
            TextField txtdate = new TextField();
            TextField txtfd = new TextField();
            imgView.setFitHeight(150);
            imgView.setFitWidth(150);
            int number = 5;
            int xv = 0;
            int yv = 6;
            String n = String.valueOf(number);
            Button button = new Button(String.valueOf(number));
            button.setLayoutX(xv);
            button.setLayoutY(yv);
            Label label = new Label(String.valueOf(number));
            label.setId(n);

            button.setId(n);
            double x = 90;
            //button.setLayoutX(x);
            //button.setLayoutY(450.0);
            label.setText("book now");
            button.setText("Say " + number);
            //scrpane.getChildrenUnmodifiable().add(sp);
            sp.getChildren().add(imgView);
            //sp.getChildren().add(button);
            //sp.getChildren().add(label);
            //grid.add(button, c, r);

            imgView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {

                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {

                        if (mouseEvent.getClickCount() == 2) {
                            try {
                                BorderPane borderPane = new BorderPane();
                                Pane right = new Pane();
                                right.minHeight(500);
                                right.minWidth(400);
                                right.setStyle("-fx-background-color: BLUE");
                                booking.setText("Book");
                                quantity.setText("1");
                                quantit.setText("Quantity You need");
                                txtdate.setText("date here");
                                // booking.setPadding(new Insets(10,10,10,10));
                                txtdate.setLayoutX(12);
                                txtdate.setLayoutY(14);
                                txtfd.setLayoutX(12);
                                txtfd.setLayoutY(50);
                                quantity.setLayoutY(120);
                                quantity.setLayoutX(12);
                                quantit.setLayoutX(0);
                                quantit.setLayoutY(86);
                                booking.setLayoutY(156);
                                ImageView imageView = new ImageView();
                                Image image = new Image(new FileInputStream(file));
                                imageView.setImage(image);
                                imageView.setStyle("-fx-background-color: BLACK");
                                imageView.setFitHeight(stage.getHeight() - 10);
                                imageView.setPreserveRatio(true);
                                imageView.setSmooth(true);
                                imageView.setCache(true);
                                borderPane.setCenter(imageView);
                                borderPane.setRight(right);
                                right.getChildren().add(quantity);
                                right.getChildren().add(quantit);
                                right.getChildren().add(txtdate);
                                right.getChildren().add(txtfd);
                                right.getChildren().add(booking);

                                borderPane.setStyle("-fx-background-color: BLACK");
                                Stage newStage = new Stage();
                                newStage.setWidth(stage.getWidth());
                                newStage.setHeight(stage.getHeight());
                                newStage.setTitle(file.getName());
                                Scene scene = new Scene(borderPane, Color.BLACK);
                                newStage.setScene(scene);
                                newStage.show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            });

            booking.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        /*Put a code here to update with the database*/
                        dbconnection dc = new dbconnection();
                        Connection conn = dbconnection.ConnectDB();
                        String imgname = file.getName();
                        String sql = "select * from unbookedeqpmnts where image= '" + imgname + "'";

                        //System.out.println(" my username "+user);
                        PreparedStatement pst;
                        ResultSet rs;
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();
                        while (rs.next()) {
                            txtfd.setText("there is");

                        }
                        String textdate = txtfd.getText();

                        txtfd.setText(imgname + textdate);
                        /*select from the db unbooked where image name is same as fie above then put in booked table delete from unbooked*/
                    } catch (SQLException ex) {
                        Logger.getLogger(Availablelequipments.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            number++;
            xv = xv + 10;

        }

        Scene scene = new Scene(root, 300, 250);
//primaryStage.setTitle("Hello World!");
//primaryStage.setScene(scene);
//primaryStage.show();
        root = FXMLLoader.load(getClass().getResource("availablelayout.fxml"));
        root.getChildren().add(sp);
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
