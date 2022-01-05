public class Cell {

    private Cell up;
    private Cell down;
    private Cell right;
    private Cell left;
    private boolean mines;
    private int amountMinesClose;

    public Cell(boolean m){
        mines = m;
        amountMinesClose = 0;
    }//End constructor

    public Cell getUp() {
        return up;
    }

    public void setUp(Cell up) {
        this.up = up;
    }

    public Cell getDown() {
        return down;
    }

    public void setDown(Cell down) {
        this.down = down;
    }

    public Cell getRight() {
        return right;
    }

    public void setRight(Cell right) {
        this.right = right;
    }

    public Cell getLeft() {
        return left;
    }

    public void setLeft(Cell left) {
        this.left = left;
    }

    public void increaseCloseMines(){
        amountMinesClose++;
    }//End increaseCloseMines

    public boolean isMines() {
        return mines;
    }

    public void setMines(boolean mines) {
        this.mines = mines;
    }

    public int getAmountMinesClose() {
        return amountMinesClose;
    }

    public void setAmountMinesClose(int amountMinesClose) {
        this.amountMinesClose = amountMinesClose;
    }
}//End Cell Class
