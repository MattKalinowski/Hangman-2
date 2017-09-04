package Hangman.view;

import Hangman.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Hangman.model.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class GameController {
    
    private Main main;
    
    private Core core;
    @FXML
    private Label word;
    @FXML
    private Label score;
    @FXML 
    private Label lives;
    @FXML
    ImageView hangman;
    
    Image image1 = new Image(getClass().getResource("HangmanPhotos/Hangman1.png").toExternalForm());
    Image image2 = new Image(getClass().getResource("HangmanPhotos/Hangman2.png").toExternalForm());
    Image image3 = new Image(getClass().getResource("HangmanPhotos/Hangman3.png").toExternalForm());
    Image image4 = new Image(getClass().getResource("HangmanPhotos/Hangman4.png").toExternalForm());
    Image image5 = new Image(getClass().getResource("HangmanPhotos/Hangman5.png").toExternalForm());
    Image image6 = new Image(getClass().getResource("HangmanPhotos/Hangman6.png").toExternalForm());
    Image image7 = new Image(getClass().getResource("HangmanPhotos/Hangman7.png").toExternalForm());
    Image image8 = new Image(getClass().getResource("HangmanPhotos/Hangman8.png").toExternalForm());
    Image image9 = new Image(getClass().getResource("HangmanPhotos/Hangman9.png").toExternalForm());
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param main
     */
    public void setMain(Main main) {
            this.main = main;
    }
    public void setCore(Core core) {
        this.core = core;
    }
    @FXML
    private void handleExit() {
        main.initRootLayout();
        main.showMenu();
    }
    @FXML
    private void handleLetter(ActionEvent event) {
        String buttonLetter = ((Button)event.getSource()).getText();
        ((Button)event.getSource()).setDisable(true); 
        core.checkLetters(buttonLetter.charAt(0));
        setLabel();
        setLives();
        endGameChecker();
        showImage();
    }
    private void setLabel() {
        word.setText(String.valueOf(core.getEncrypt()));
    }    
    public void initLabel() {
        core.setLetters();
        core.setEncrypt();
        word.setText(String.valueOf(core.getEncrypt()));
    }
    private void endGameChecker() {
        if (core.counter == core.getLettersLength() || core.missCounter == 9) {
            main.showFin();
        } 
    }
    private void setLives() {
        lives.setText(String.valueOf(9 - core.missCounter));
    }
    private void showImage() {
        switch (core.missCounter) {
            case 0:
                break;
            case 1:
                hangman.setImage(image1);
                break;
            case 2:
                hangman.setImage(image2);
            break;
            case 3:
                hangman.setImage(image3);
            break;
            case 4:
                hangman.setImage(image4);
            break;
            case 5:
                hangman.setImage(image5);
            break;
            case 6:
                hangman.setImage(image6);
            break;
            case 7:
                hangman.setImage(image7);
            break;
            case 8:
                hangman.setImage(image8);
            break;
            case 9:
                hangman.setImage(image9);
            break;
        }
    }
    
}