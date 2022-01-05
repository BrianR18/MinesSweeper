package model;

import java.util.Random;

public class SearchMines {

    private final int DEFAULT_COLUMNS = 5;
    private final int DEFAULT_ROWS = 5;
    private int MAX_MINES_AMOUNT;
    private final int IS_MINE_PROBABILITY = 3;
    private final double MAX_MINES_PERCENT = 0.4;
    private int columns;
    private int rows;
    private Cell board;

    public SearchMines(){
        columns = DEFAULT_COLUMNS;
        rows = DEFAULT_ROWS;
        MAX_MINES_AMOUNT = (int) (columns * rows * MAX_MINES_PERCENT);
    }//End Constructor

    public SearchMines(int w, int h){
        columns = w;
        rows = h;
        MAX_MINES_AMOUNT = (int) (columns * rows * MAX_MINES_PERCENT);
    }//End Constructor

    public void createBoard(){
        Random chosen = new Random();
        board = new Cell(chosen.nextInt(IS_MINE_PROBABILITY) == 1);
        createBoard(null, board,chosen,0);
    }//End createBoard

    private void createBoard(Cell currentAbove, Cell current, Random chosen,int rows){
        Cell firstColumn = current;
        for(int i = 1; i < columns; i++){
            Cell toAdd = new Cell(chosen.nextInt(IS_MINE_PROBABILITY) == 1);
            current.setRight(toAdd);
            toAdd.setLeft(current);
            if(currentAbove != null){
                toAdd.setUp(currentAbove.getRight());
                currentAbove.getRight().setDown(toAdd);
                currentAbove = toAdd.getUp();
            }//End if
            current = toAdd;
        }//End for
        rows++;
        if(rows < this.rows){
            Cell newRow = new Cell(chosen.nextInt(IS_MINE_PROBABILITY) == 1);
            firstColumn.setDown(newRow);
            newRow.setUp(firstColumn);
            createBoard(firstColumn,newRow,chosen,rows);
        }//End if
    }//End createBoard

    public int getWidth() {
        return columns;
    }

    public void setWidth(int width) {
        this.columns = width;
    }

    public int getHeight() {
        return rows;
    }

    public void setHeight(int height) {
        this.rows = height;
    }

    public Cell getBoard(){
        return board;
    }//End getBoard

    @Override
    public String toString(){
        String a = "";
        Cell current = board;
        Cell firstC = board;
        for(int i = 0; i < getWidth(); i++){
            for(int j = 0; j < getHeight(); j++){
                a += current.isMines()?" ":"#";
                current = current.getRight();
            }//End for
            a += "\n";
            current = firstC.getDown();
            firstC = current;
        }
        return a;
    }
}//End searchMines class
