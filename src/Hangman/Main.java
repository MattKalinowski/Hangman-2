package Hangman;

import Hangman.data.Database;
import Hangman.view.FinController;
import Hangman.view.MenuController;
import Hangman.view.GameController;
import Hangman.view.NameDialogController;
import Hangman.view.TopicsController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    
    private Stage window;
    private BorderPane rootLayout;
    private TopicsController topicController;
    private NameDialogController nameController;
    public String name;
    public int points = 0;
    public Database database = new Database();

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hangman");

        initRootLayout();
        showMenu();
    }
    
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the menu inside the root layout.
     */
    public void showMenu() {
        try {   
            // Load Menu screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Menu.fxml"));
            AnchorPane menu = (AnchorPane) loader.load();

            // Set Menu into the center of root layout.
            rootLayout.setCenter(menu);
            
            // Give the controller access to the main app.
        MenuController controller = loader.getController();
        controller.setMain(this);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showNameDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/NameDialog.fxml"));
            AnchorPane nameDialog = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(window);
            Scene scene = new Scene(nameDialog);
            dialogStage.setScene(scene);
            
            nameController = loader.getController();
            nameController.setDialogStage(dialogStage);
            nameController.setMain(this);
        
            dialogStage.showAndWait();
            
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTopics() {
        try {   
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Topics.fxml"));
            BorderPane game = (BorderPane) loader.load();

            Scene scene = new Scene(game);
            window.setScene(scene);
            
        topicController = loader.getController();
        topicController.setMain(this);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showGame() {
        try {   
            // Load Game screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Game.fxml"));
            BorderPane game = (BorderPane) loader.load();

            Scene scene = new Scene(game);
            window.setScene(scene);
            
            // Give the controller access to the main app.
        GameController controller = loader.getController();
        controller.setMain(this);
        controller.setCore(topicController.getCore());
        controller.initLabel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFin() {
        try {   
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Fin.fxml"));
            BorderPane fin = (BorderPane) loader.load();

            Scene scene = new Scene(fin);
            window.setScene(scene);
            
        FinController controller = loader.getController();
        controller.setMain(this);
        controller.setCore(topicController.getCore());
        controller.result();
        database.update(name, points);
        database.clearLeaderboard();
        selectLeaderboard();
        database.fillTheListWithSampleData();
        controller.showNames();
        controller.showPoints();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void quit() {
        window.close();
    }
    
    public Stage getPrimaryStage() {
        return window;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    public void selectLeaderboard() {
        database.selectAll();
    }
}