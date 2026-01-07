package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // This assumes your Scene.fxml is in src/main/resources/gui/
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Scene.fxml"));
            primaryStage.setTitle("Shoe Store");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch(Exception e) {
            System.out.println("Error: Could not find Scene.fxml in /gui/");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // This will stay lowercase now
    }
}