package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application{

    static Stage window;
    static Scene menu_scene,how_to_play_scene,pause_scene,game_scene;
    static int height = 500, width = 400;
    Button play_button ,load_button , quit_button , how_to_play_button , htp_to_menu_button;
    Button pause_button,resume_button,save_game_button , pause_to_menu_button;
    static Circle ball = new Circle(100,200.0f,20.0f);
    int velocity = 0 ;
    float acceleration = 1.1f;
    float x_c = 100f;
    float y_c = 200f;
    static Label score = new Label("Score = 0");
    public static void game_loop() {
        System.out.println("game loop");
        Group base = new Group();
        base.getChildren().addAll(score,ball);
        Scene game_scene = new Scene(base,width,height);
        window.setScene(game_scene);
        System.out.println("b4 loop\n");
        final float[] vel = {0f};
        float acc = 0.5f;
        final int[] t = {5};
        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        game_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                         @Override
                        public void handle(KeyEvent keyEvent) {
                             System.out.println("Something happened\n");
                             if(keyEvent.getCode() == KeyCode.SPACE){
                                 vel[0] = -10;
                             }
                             if(keyEvent.getCode()== KeyCode.P){
                                 window.setScene(pause_scene);
                             }
                         }
                        });
                        ball.setCenterY(ball.getCenterY()+vel[0]);
                        vel[0]+=acc;

                    }
                }, 0, 50);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////MAIN MENU////////////////////////////////
        Label label1 = new Label("Main menu");
        play_button = new Button("Play Game");
        load_button = new Button("Load Game");
        quit_button = new Button("Quit Game");
        how_to_play_button = new Button("how to play ");
        play_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Play button pressed");
//                window.setScene(game_scene);
                game_loop();
            }
        });
        load_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("load button pressed");
            }
        });
        quit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("quit button pressed");
                window.close();
            }
        });
        how_to_play_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("how to play button pressed");
                window.setScene(how_to_play_scene);
            }
        });
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,play_button,load_button,how_to_play_button,quit_button);
        menu_scene = new Scene(layout1,width,height);
        ////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////HOW TO PLAY/////////////////////////////////
        Label how_to_play_label = new Label("press space bar to play");
        htp_to_menu_button = new Button("Back to menu");
        htp_to_menu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu_scene);
            }
        });
        VBox how_to_play_layout = new VBox(20);
        how_to_play_layout.getChildren().addAll(how_to_play_label,htp_to_menu_button);
        how_to_play_scene = new Scene(how_to_play_layout,width,height);
        ////////////////////////////////////////////////////////////////////////



        ////////////////////////////////////////////////////////////////////////
        /////////////////////////MAIN GAME//////////////////////////////////////
        Label score = new Label("Score = 0");
        pause_button = new Button("Pause game");
        pause_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Game paused");
                window.setScene(pause_scene);
            }
        });
        Group base = new Group();
        base.getChildren().addAll(score,ball);
        game_scene = new Scene(base,width,height);
        game_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("Something happened\n");
                if(keyEvent.getCode() == KeyCode.SPACE){

                    System.out.println("Space pressed");
                    ball.setCenterY(ball.getCenterY()+10);
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////
        /////////////////////////PAUSE GAME/////////////////////////////////////
        Label pause = new Label("Game paused");
        resume_button = new Button("resume game");
        save_game_button = new Button("save game");
        pause_to_menu_button = new Button("back to menu");
        resume_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("game resumed");
                window.setScene(game_scene);
//                game_loop();
            }
        });
        save_game_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Game saved");
            }
        });
        pause_to_menu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu_scene);
            }
        });
        VBox pause_layout = new VBox(20);
        pause_layout.getChildren().addAll(pause,resume_button,save_game_button,pause_to_menu_button);
        pause_scene = new Scene(pause_layout,width,height);
        ////////////////////////////////////////////////////////////////////////

        window.setScene(menu_scene);

        window.setTitle("Color Switch Game");

        window.show();





    }


    public static void main(String[] args) {
        launch(args);
    }

}
