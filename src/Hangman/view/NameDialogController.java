package Hangman.view;

import Hangman.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameDialogController {
    
    private Stage dialogStage;
    private Main main;
    @FXML
    private TextField nameInput; // ( = ""//is empty)
    @FXML
    private Button OK;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    

    @FXML
    private void handleOk() {
        if (nameInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(dialogStage);
            alert.setHeaderText("Invalid name");
            alert.setContentText("Please type correct name");

            alert.showAndWait(); 
        } else {
        main.name = nameInput.getText();
        main.points = 0;
        dialogStage.close();
        main.showTopics();
        main.database.insert(main.name, main.points);
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
        main.showMenu();
    }
}
