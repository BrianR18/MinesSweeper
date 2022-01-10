package ui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
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
        minesSweeper.createBoard();
        double cellWidth = board.getWidth() / (double) minesSweeper.getWidth();
        double cellHeight = board.getHeight() / (double) minesSweeper.getHeight();
        int x = 0;
        int y = 0;
        Cell newCell = minesSweeper.getBoard();
        Cell firstCol;
       for(int i = 0; i < minesSweeper.getHeight(); i++){
           firstCol = newCell;
           for(int j = 0; j < minesSweeper.getWidth(); j++){
               newCell.setWidth(cellWidth);
               newCell.setHeight(cellHeight);
               newCell.setFill(Paint.valueOf("#0000FF"));
               newCell.setStroke(Paint.valueOf("#000000"));
               newCell.setStrokeWidth(2);
               newCell.setLayoutX(x);
               newCell.setLayoutY(y);
               newCell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e){
                       System.out.println("Funciona excelente");
                   }//End handle
               });
               Cell finalNewCell = newCell;
               newCell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e){
                       finalNewCell.setOpacity(0.7);
                   }//End handle
               });
               newCell.setOnMouseExited(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e){
                       finalNewCell.setOpacity(1);
                   }//End handle
               });
               board.getChildren().add(newCell);
               x += newCell.getWidth();
               newCell = newCell.getRight();
           }//End for
           x = 0;
           y += cellHeight;
           newCell = firstCol.getDown();
        }//End for*/
    }//End drawBoard

    public void createBoard(){
        drawThread = new DrawBoardThread(this);
        drawThread.start();
    }//End createBoard

}//End GameController class
