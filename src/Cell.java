public class Cell {
    private boolean mines;
    private int amountMinesClose;

    public Cell(){
        mines = false;
        amountMinesClose = 0;
    }//End constructor

    public Cell(boolean m){
        mines = m;
        amountMinesClose = 0;
    }//End constructor

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
