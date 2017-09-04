package Hangman.view;

import Hangman.Main;
import javafx.fxml.FXML;

public class MenuController {
    
    private Main main;
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param main
     */
    public void setMain(Main main) {
            this.main = main;
    }
    @FXML
    private void handlePlay() {
        main.showNameDialog();
    }
    @FXML
    private void handleOptions() {
        main.database.selectAll();
    }
    @FXML
    private void handleQuit() {
        main.quit();
    }
}
