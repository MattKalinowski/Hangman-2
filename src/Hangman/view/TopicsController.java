package Hangman.view;

import Hangman.Main;
import javafx.fxml.FXML;
import Hangman.model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;

public class TopicsController {
    
    private Main main;
    private Core core = new Core();
    private boolean buttonPressed = false;
    
    public void setMain(Main main) {
            this.main = main;
    }
    
    @FXML
    private void handleChoice(ActionEvent event) {
        String buttonTopic = ((RadioButton)event.getSource()).getText();
        core.setTopic(buttonTopic);
        buttonPressed = true;
    }
    @FXML
    private void handleStart() {
        if (!buttonPressed) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setHeaderText("No selection");
            alert.setContentText("Please select your topic");
            alert.showAndWait(); 
        } else {
        core.setWord();
        main.showGame();
        }
    }

    public Core getCore() {
        return core;
    }
}
