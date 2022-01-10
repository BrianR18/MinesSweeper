package ui;

import model.MinesSweeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private GameController gc;
    private MinesSweeper ms;

    public Main(){
        ms = new MinesSweeper(5,5);
        gc = new GameController(ms);
    }

    public static void main(String[] args){
        launch(args);
    }//End main

    @Override
    public void start(Stage window) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("PlayScene.fxml"));
        fxml.setController(gc);
        Parent root = fxml.load();
        Scene scene = new Scene(root,null);
        window.setScene(scene);
        window.setTitle("Mines Sweeper");
        window.show();
        gc.createBoard();
    }//End start

}//End Main
