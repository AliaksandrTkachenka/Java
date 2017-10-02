package lecture3.snake;

public class Board {
    private int[][] board;
    private int width;
    private int length;

    /**
     * creates a board
     * @param width board's width
     * @param length board's length
     */
    public Board(int width, int length) {
        this.width = width;
        this.length = length;
        this.board = new int[width][length];
    }

    /**
     * displays current state of the board
     */
    public void showBoard() {
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**
     * returns element of the board with coordinates or -1 if coordinates are wrong
     * @param positionHor vertical position on board
     * @param positionVer horizontal position on board
     * @return 1 if element is filled, 0 if element is empty, -1 if position doesn't exist
     */
    public int getElement(int positionVer, int positionHor) {
        if(checkCoordinates(positionVer, positionHor) == false) {
            return -1;
        }
        return board[positionVer][positionHor];
    }

    /**
     * Fills the element of the board with 1
     * @param positionVer vertical coordinate
     * @param positionHor horizontal coordinate
     */
    public void fillElement(int positionVer, int positionHor) {
        if(checkCoordinates(positionVer, positionHor) == true) {
            this.board[positionVer][positionHor] = 1;
        } else {
            System.out.println("Incorrect");
        }
    }

    private boolean checkCoordinates(int positionVer, int positionHor) {
        if(positionVer >= width || positionHor >= length
                || positionVer < 0 || positionHor <0) {
            return false;
        }
        return true;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }
}
