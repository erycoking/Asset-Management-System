/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemAccess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Booking extends Application {

    Boolean answer;

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Log in");

        Button button1 = new Button("Add Equipment");

        button1.setOnAction(e -> {
            try {
                Add add = new Add();
                add.display();
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button button2 = new Button("View Equipment");

        Button button3 = new Button("Book Equipment");

        Button button4 = new Button("View booked Equipments");

        Button button5 = new Button("Return Equipment");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(button1, button2, button3, button4, button5);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 300);
        scene.getStylesheets().addAll(Booking.class.getResource("style.css").toExternalForm());
        window.setScene(scene);

        window.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }
}
