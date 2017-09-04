package Hangman.view;

import Hangman.Main;
import Hangman.model.Core;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FinController {
    
    private Main main;
    
    private Core core;
    @FXML
    private Label word;
    @FXML
    private Label score;
    @FXML
    private Label namesLabel;
    @FXML
    private Label pointsLabel;
    
    private int points;
    
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    private String name6;
    private String name7;
    private String name8;
    private String name9;
    private String name10;
    
    private String points1;
    private String points2;
    private String points3;
    private String points4;
    private String points5;
    private String points6;
    private String points7;
    private String points8;
    private String points9;
    private String points10;

    public void setMain(Main main) {
            this.main = main;
    }
    public void result() {
        if (core.counter == core.getLettersLength()) {
            exposeWord();
            showVictoryLabel();
            addPoint();
        }
        if (core.missCounter == 9) {
            exposeWord();
            showLossLabel();
            subPoint();
        }
    }
    @FXML
    private void handleExit() {
        main.initRootLayout();
        main.showMenu();
    }
    @FXML
    private void handlePlayAgain() {
        main.showTopics();
    }
    @FXML
    private void handleNextWord() {
        core.setTopic(core.topic);
        core.setWord();
        core.counter = 0;
        core.missCounter = 0;
        main.showGame();
    }
    private void showVictoryLabel() {
        score.setTextFill(Color.GREEN);
        score.setText("You got it!");
    }
    private void showLossLabel() {
        score.setTextFill(Color.RED);
        score.setText("You loose!");
    }

    public void setCore(Core core) {
        this.core = core;
    }
    private void exposeWord() {
        word.setText(String.valueOf(core.getLetters()));
    }
    private void addPoint() {
        main.points = main.points + 1;
    }
    private void subPoint() {
        if (main.points > 0) {
            main.points = main.points - 1;
        }
    }
    public void showNames() {
        setNames();
        namesLabel.setText(name1 + "\n" 
                         + name2 + "\n" 
                         + name3 + "\n" 
                         + name4 + "\n" 
                         + name5 + "\n" 
                         + name6 + "\n" 
                         + name7 + "\n" 
                         + name8 + "\n" 
                         + name9 + "\n" 
                         + name10); 
    }
    public void showPoints() {
        setPoints();
        pointsLabel.setText(points1 + "\n" 
                          + points2 + "\n" 
                          + points3 + "\n" 
                          + points4 + "\n" 
                          + points5 + "\n" 
                          + points6 + "\n" 
                          + points7 + "\n" 
                          + points8 + "\n" 
                          + points9 + "\n" 
                          + points10); 
    }
    public void setNames() {
        name1 = "1. "+main.database.getNamesList().get(0);
        name2 = "2. "+main.database.getNamesList().get(1);
        name3 = "3. "+main.database.getNamesList().get(2);
        name4 = "4. "+main.database.getNamesList().get(3);
        name5 = "5. "+main.database.getNamesList().get(4);
        name6 = "6. "+main.database.getNamesList().get(5);
        name7 = "7. "+main.database.getNamesList().get(6);
        name8 = "8. "+main.database.getNamesList().get(7);
        name9 = "9. "+main.database.getNamesList().get(8);
        name10 = "10. "+main.database.getNamesList().get(9);
    }
    public void setPoints() {
        points1 = main.database.getPointsList().get(0).toString();
        points2 = main.database.getPointsList().get(1).toString();
        points3 = main.database.getPointsList().get(2).toString();
        points4 = main.database.getPointsList().get(3).toString();
        points5 = main.database.getPointsList().get(4).toString();
        points6 = main.database.getPointsList().get(5).toString(); 
        points7 = main.database.getPointsList().get(6).toString();
        points8 = main.database.getPointsList().get(7).toString();
        points9 = main.database.getPointsList().get(8).toString();
        points10 = main.database.getPointsList().get(9).toString();       
    }
}
