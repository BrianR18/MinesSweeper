public class Main {

    public static void main(String[] args){
        Cell[][] b = new Cell[5][5];
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + b[i][j] + "]");
            }//End for
            System.out.println();
        }
    }//End main
}
