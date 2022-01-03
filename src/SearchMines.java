import java.util.Random;

public class SearchMines {
    private Cell[][] board;
    private int width;
    private int height;
    private int minesAmount;
    private Random choosen;

    public SearchMines(){
        this.width = 5;
        this.height = 5;
        board = new Cell[5][5];
        minesAmount = (int) Math.floor((width*height)*0.3);
        choosen = new Random();
    }//End constructor

    public SearchMines(final int width, final int height){
        this.width = width;
        this.height = height;
        board = new Cell[width][height];
        minesAmount = (int) Math.floor((width*height)*0.3);
        choosen = new Random();
    }//End constructor

    public void createBoard(){
        int minesPlanted = 0;
        while(minesPlanted < minesAmount){

        }//End while
    }//End createBoard

    private int fillCells(){
        int minesPlanted = 0;
        for(int i = 0; i < width; i++)
            for(int j = 0; j < height; j++){
                if( choosen.nextInt(2) == 1) {
                    board[i][j] = new Cell(true);
                }//End if
            }//End for
        return 0;
    }//End fillCells
}//End searchMines class
