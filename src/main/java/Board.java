public class Board {
    int[][] b;

    public Board(int rows, int cols) {
        b = new int[rows][cols];
    }

    public int get(int row, int col){
        return b[row][col];
    }

    public void set(int row, int col, int value){
        b[row][col] = value;
    }
}

