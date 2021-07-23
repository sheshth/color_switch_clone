
package sample;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Circle circle;
    @FXML
    private Line rightLine;
    @FXML
    private Line leftLine;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        TranslateTransition up = new TranslateTransition(Duration.seconds(2),circle);
        up.setByY(-80);
        up.setAutoReverse(true);
        up.setCycleCount(up.INDEFINITE);
        up.play();
        RotateTransition rotateC = new RotateTransition(Duration.seconds(4),circle);
        rotateC.setByAngle(360);
        rotateC.setCycleCount(rotateC.INDEFINITE);
        rotateC.play();
        ScaleTransition scale = new ScaleTransition(Duration.seconds(2),circle);
        scale.setByX(.75);
        scale.setByY(.75);
        scale.setAutoReverse(true);
        scale.setCycleCount(scale.INDEFINITE);
        scale.play();
        RotateTransition right = new RotateTransition(Duration.seconds(3),rightLine);
        RotateTransition left = new RotateTransition(Duration.seconds(3),leftLine);
        right.setByAngle(360);
        left.setByAngle(-360);
        right.setCycleCount(right.INDEFINITE);
        left.setCycleCount(left.INDEFINITE);
        right.play();
        left.play();
        TranslateTransition upLeft = new TranslateTransition(Duration.seconds(6),leftLine);
        upLeft.setByY(-350);
        upLeft.setAutoReverse(true);
        upLeft.setCycleCount(up.INDEFINITE);
        upLeft.play();
        TranslateTransition upRight = new TranslateTransition(Duration.seconds(6),rightLine);
        upRight.setByY(-350);
        upRight.setAutoReverse(true);
        upRight.setCycleCount(up.INDEFINITE);
        upRight.play();
    }
    @FXML
    private Button play_button,back_button;
    @FXML
    public void shut(){
        System.exit(0);
    }
    public void playCheck()  {
        System.out.println("Play Button connected");
    }
    public void loadGame() throws IOException {
//        System.out.println("Load Game connected");
        Stage stage = (Stage) play_button.getScene().getWindow();
        Parent root;

        root = FXMLLoader.load(getClass().getResource("load_game.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void how() throws IOException {
//        System.out.println("How Connected");
        Stage stage = (Stage) play_button.getScene().getWindow();
        Parent root;

        root = FXMLLoader.load(getClass().getResource("how_to_play.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void back_to_menu() throws IOException {
//        System.out.println("How Connected");
        Stage stage = (Stage) back_button.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}