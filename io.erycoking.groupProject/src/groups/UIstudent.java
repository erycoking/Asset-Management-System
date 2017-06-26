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
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

public class UIstudent {
    TableView<Students> table;
    BorderPane bpane = new BorderPane();
    Actions crudAction = new Actions();
     
    public void showUi(Stage stage) {
       // column for 
       TableColumn<Students, String> regnoColumn = new TableColumn<>("Registration");
       regnoColumn.setMinWidth(270);
       regnoColumn.setCellValueFactory(new PropertyValueFactory<>("regno"));
        
       TableColumn<Students, String> nameColumn = new TableColumn<>("Name");
       nameColumn.setMinWidth(270);
       nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
       
       TableColumn<Students, Boolean> leaderColumn = new TableColumn<>("Group Leader");
       leaderColumn.setMinWidth(270);
       leaderColumn.setCellValueFactory(new PropertyValueFactory<>("leader"));
       
       TableColumn<Students, String> groupColumn = new TableColumn<>("Groups");
       groupColumn.setMinWidth(270);
       groupColumn.setCellValueFactory(new PropertyValueFactory("group"));
       
       table = new TableView<>();
       table.setEditable(true);
       table.setItems(shuffleStudents());
       table.getColumns().addAll(regnoColumn, nameColumn, groupColumn, leaderColumn);
       
       // add the buttons 
       Button backButton = new Button("GO BACK!");
       backButton.setMaxSize(150, 150);
       backButton.getStyleClass().add("actionbuttons");
       
       Button printButton = new Button("Print Form");
       printButton.setMaxSize(150, 150);
       printButton.getStyleClass().add("actionbuttons");
       
       backButton.setOnAction((ActionEvent event)->{
           UIgroup uigroup = new UIgroup();
           uigroup.showUi(stage);
       });
       
       printButton.setOnAction((ActionEvent event) -> printList());
       
       // 
       bpane.setLeft(backButton);
       bpane.setRight(printButton);
       bpane.setPadding(new Insets(15, 15, 15, 15));
       
       VBox vBox = new VBox();
       vBox.getChildren().addAll(bpane, table);
       
       Scene scene = new Scene(vBox);
       scene.getStylesheets().add(getClass().getResource("prettify.css").toExternalForm());
       stage.setScene(scene);
    }  
    
    public ObservableList<Students> getStudents() {
        ObservableList<Students> students = FXCollections.observableArrayList();
        crudAction.getStudents().forEach((ab) -> {
            students.add(ab);
        });
        return students;
    }
    
    // method for generating a random list of students
    public ObservableList<Students> shuffleStudents() {
      ObservableList<Students>groups = getStudents();
      ObservableList<Students>groupList;
      int j = 0;
      Collections.shuffle(groups);
      groupList = groups;
      // set one out 4 students as the group leader 
      for(int i = 0; i < groups.size();i++) {
          Students student = groups.get(i);
          if(i%4 == 0) {
             student.setLeader(true);     
          }
      }
      // set the students into groups
      for(Students student: groups) {
        String group = "Group"+j;
        student.setGroup(group);
        if(student.getLeader()) {
            String grup = "Group"+(j+1);
            student.setGroup(grup);
            j++;
        }
      }
      return groups;
    }
    
    // method that calls the print class to print the random list
    public void printList() {
        Printpdf print = new Printpdf();
        try{
            print.createPdf(table);
        }
        catch(Exception e) {
         System.out.println(e);
        }
    }
}
