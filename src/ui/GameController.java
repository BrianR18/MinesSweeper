package ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.*;
import thread.*;
public class GameController {

    private final int WINDOW_WIDTH = 457;
    private final int WINDOW_HEIGHT = 494;
    @FXML private Pane board;

    private DrawBoardThread drawThread;
    private MinesSweeper minesSweeper;

    public GameController(MinesSweeper ms){
        minesSweeper = ms;
    }//End Constructor

    public void drawBoard(){
        double cellWidth = board.getWidth() / (double) minesSweeper.getWidth();
        double cellHeight = board.getHeight() / (double) minesSweeper.getHeight();
        int x = 0;
        int y = 0;
       for(int i = 0; i < minesSweeper.getHeight(); i++){
           for(int j = 0; j < minesSweeper.getWidth(); j++){
               Rectangle newCell = new Rectangle(cellWidth,cellHeight);
               newCell.setFill(Paint.valueOf("#0000FF"));
               newCell.setStroke(Paint.valueOf("#000000"));
               newCell.setStrokeWidth(2);
               newCell.setLayoutX(x);
               newCell.setLayoutY(y);
               board.getChildren().add(newCell);
               x += newCell.getWidth();
           }//End for
           x = 0;
           y += cellHeight;
        }//End for
    }//End drawBoard

    public void createBoard(){
        drawThread = new DrawBoardThread(this);
        drawThread.start();
    }//End createBoard

}//End GameController class
