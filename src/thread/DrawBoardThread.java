package thread;

import javafx.application.Platform;
import ui.*;

public class DrawBoardThread extends Thread{

    private GameController gm;

    public DrawBoardThread(GameController gm){
        this.gm = gm;
    }//End constructor

    @Override
    public void run(){
        Platform.runLater(new Thread(){
            @Override
            public void run(){
                gm.drawBoard();
            }//End run
        });
    }//End run
}//End
