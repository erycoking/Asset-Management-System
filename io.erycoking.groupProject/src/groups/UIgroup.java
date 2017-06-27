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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Priority;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;

public class UIgroup {
    
    TableView<Students> table;
    TextField regnoInput, nameInput;
    Actions crudAction = new Actions();
    Validator validate = new Validator();
    BorderPane bpane = new BorderPane();
    
    public void showUi(Stage stage) {
       // column on the table for registration number
       TableColumn<Students, String> regnoColumn = new TableColumn<>("Registration");
       regnoColumn.setMinWidth(360);
       regnoColumn.setCellValueFactory(new PropertyValueFactory<>("regno"));
       
       // column on the table for names, values in the cells in this column can be edited
       TableColumn<Students, String> nameColumn = new TableColumn<>("Name");
       nameColumn.setMinWidth(360);
       nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
       nameColumn.setCellFactory(TextFieldTableCell.<Students>forTableColumn());
       nameColumn.setOnEditCommit((CellEditEvent<Students, String> t) ->  { 
              ((Students) t.getTableView().getItems().get(
                      t.getTablePosition().getRow()
              )).setName(t.getNewValue());
              updateSelectedCell();
         });
       
       // column to get the truth value of whether one is a group leader or not
       TableColumn<Students, Boolean> leaderColumn = new TableColumn<>("Group Leader");
       leaderColumn.setMinWidth(360);
       leaderColumn.setCellValueFactory(new PropertyValueFactory<>("leader"));
       
       table = new TableView<>();
       table.setEditable(true);
       table.setItems(getStudents());
       table.getColumns().addAll(regnoColumn, nameColumn, leaderColumn);
       
       // set the titles for the input fields
       Text nametxt = new Text("Name");
       nametxt.getStyleClass().add("text-label");
       Text regnotxt = new Text("Registration");
       regnotxt.getStyleClass().add("text-label");
        
       // take input for registration number
       regnoInput = new TextField();
       regnoInput.setPromptText("ABXX/XXXXX/XX"); // set the placeholder
       regnoInput.setMinWidth(150);

       // take input for names 
       nameInput = new TextField();
       nameInput.setPromptText("Jack Ma"); // set the placeholder
       nameInput.setMinWidth(150);
       
       // now add the buttons
       Button addButton = new Button("ADD");
       addButton.setMaxSize(150, 150);
       addButton.setOnAction(e -> addButtonClicked());
       
       Button deleteButton = new Button("DELETE");
       deleteButton.setMaxSize(150, 150);
       deleteButton.setOnAction(e -> deleteButtonClicked());
       
       Button groupButton = new Button("CREATE GROUPS");
       groupButton.setMaxSize(150,150);
       groupButton.getStyleClass().add("actionbuttons");
       groupButton.setOnAction((ActionEvent event) -> {
           UIstudent uistudent = new UIstudent();
           uistudent.showUi(stage);
       });
       
       Button backButton = new Button("GO BACK!");
       backButton.setMaxSize(150,150);
       backButton.getStyleClass().add("actionbuttons");
       backButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Stage stage = new Stage();
               ((Node)event.getSource()).getScene().getWindow().hide();
               FXMLLoader loader = new FXMLLoader();
               Parent root;
               try {
                    root = loader.load(getClass().getResource("/booking/booklayout.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("/booking/booklayout.css").toExternalForm());
                    stage.setScene(scene);
//                    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/equipment2.jpg")));
                    stage.setTitle("Active Inventory");
                    stage.show();
               } catch (IOException ex) {
                   Logger.getLogger(UIgroup.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       
       // configure the hBox layout for inputs and the text fields and the buttons add and delete are placed
       HBox.setHgrow(addButton, Priority.ALWAYS);
       HBox.setHgrow(deleteButton, Priority.ALWAYS);
       HBox hBox = new HBox();
       hBox.setPadding(new Insets(15, 15, 15, 15));
       hBox.setSpacing(10);
       hBox.getChildren().addAll(regnotxt, regnoInput, nametxt, nameInput, addButton, deleteButton);
       hBox.getStyleClass().add("hbox");
       
       // configure the border pane where the buttons creategroup and goback are placed
       bpane.setLeft(backButton);
       bpane.setRight(groupButton);
       bpane.setPadding(new Insets(15, 15, 15, 15));
               
       VBox vBox = new VBox();
       vBox.getChildren().addAll(bpane, hBox, table);
       
       Scene scene = new Scene(vBox);
       scene.getStylesheets().add(getClass().getResource("prettify.css").toExternalForm());
       stage.setScene(scene);
        
    }
    
    /**
     * Methods attached to the buttons.
     * 
     */
    public void addButtonClicked() {
        Students student = new Students();
        student.setName(nameInput.getText());
        student.setRegno(regnoInput.getText());
        if(validate.isValidRegno(student.getRegno()) && validate.isValidName(student.getName())) {
          crudAction.addStudent(student);
          table.getItems().add(student);
          nameInput.clear();
          regnoInput.clear();
        }
        else {
            nameInput.clear();
            regnoInput.clear();
            student.setName(nameInput.getText());
            student.setRegno(regnoInput.getText()); 
        }
    }
    
    public void deleteButtonClicked() {
      ObservableList<Students> selectedStudent, allStudents;
      String regno;
      allStudents = table.getItems();
      selectedStudent = table.getSelectionModel().getSelectedItems();
      regno = selectedStudent.get(0).getRegno();
      System.out.println(selectedStudent.get(0).getRegno());
      crudAction.deleteStudent(selectedStudent.get(0).getRegno());
      selectedStudent.forEach(allStudents::remove);
    }
    
    public void updateSelectedCell() {
          ObservableList<Students> selectedStudent;
          String regno, name;
          selectedStudent = table.getSelectionModel().getSelectedItems();
          regno = selectedStudent.get(0).getRegno();
          name = selectedStudent.get(0).getName();
          crudAction.updateStudent(name, regno);
    }
    
    public ObservableList<Students> getStudents() {
        ObservableList<Students> students = FXCollections.observableArrayList();
        crudAction.getStudents().forEach((ab) -> {
            students.add(ab);
        });
        return students;
    }

}