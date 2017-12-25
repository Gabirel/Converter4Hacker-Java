package Converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));

        primaryStage.setTitle("Converter For Hacker");
        primaryStage.setScene(new Scene(root, 603, 323));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
