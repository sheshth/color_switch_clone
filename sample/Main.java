package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent main_menu = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent how_to_play = FXMLLoader.load(getClass().getResource("how_to_play.fxml"));
        primaryStage.setTitle("Color Switch");
        Scene scene = new Scene(main_menu);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}