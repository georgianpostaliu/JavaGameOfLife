public class Life {

    public static final int ROWS = 20;
    public static final int COLS = 80;
    public static final int TIME_DELAY = 100;

    public static void initializeBoard(Board board){
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                int randVal = (int) (Math.random() * 3); // 1/3 chances for a cell to be alive
                if (randVal == 0) {
                    board.set(r, c, 1);
                }
            }
        }
    }

    public static void displayBoard(Board board){
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (board.get(r,c) == 0){
                    System.out.print(".");
                } else if (board.get(r,c) == 1){
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int countNeighbours(int row, int col, Board b) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < ROWS && c >= 0 && c < COLS && !(r == row && c == col) && b.get(r, c) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void calculateNextGen(Board b, Board nextB){

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){

                int neighbourCount = countNeighbours(r, c, b);

                if (b.get(r, c) == 1 && neighbourCount < 2) {
                    nextB.set(r, c, 0);

                } else if (b.get(r, c) == 1 && neighbourCount < 4) {
                    nextB.set(r, c, 1);

                } else if (b.get(r, c) == 1 && neighbourCount > 3) {
                    nextB.set(r, c, 0);
                } else if (b.get(r, c) == 0 && neighbourCount == 3) {
                    nextB.set(r, c, 1);
                } else {
                    nextB.set(r, c, 0);
                }
            }
        }
    }

    public static void transferNextToCurrent(Board board, Board nextBoard){
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                board.set(r, c, nextBoard.get(r, c));
            }
        }
    }

    private static void slow() {
        try {
            Thread.sleep(Life.TIME_DELAY);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Board board = new Board(ROWS, COLS);
        Board nextBoard = new Board(ROWS, COLS);
        initializeBoard(board);
        for (int i = 0; i < 100; i++) {
            displayBoard(board);
            slow();
            calculateNextGen(board, nextBoard);
            transferNextToCurrent(board, nextBoard);
        }
    }
}
