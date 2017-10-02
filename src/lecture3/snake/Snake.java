package lecture3.snake;

public class Snake {
    private static final int DEFAULT_SIZE = 5;
    private int positionHor;
    private int positionVer;
    private Direction direction;
    private Board board;

    /**
     * Creates a default snake with the following parameters
     * default direction is down
     * default board size is 5x5
     */
    public Snake() {
        direction = Direction.down;
        board = new Board(DEFAULT_SIZE, DEFAULT_SIZE);
    }

    /**
     * Creates a default snake with the following parameters
     * @param length - board's length
     * @param width - board's width
     */
    public Snake(int length, int width) {
        board = new Board(length, width);
        direction = Direction.down;
    }

    /**
     * Creates a snake with the following parameters
     * @param length - board's length
     * @param width - board's width
     * @param positionVer - initial vertical position
     * @param positionHor - initial horizontal position
     * @param direction - initial direction of the snake
     */
    public Snake(int length, int width, int positionVer, int positionHor, Direction direction) {
        board = new Board(length, width);
        this.positionVer = positionVer;
        this.positionHor = positionHor;
        this.direction = direction;
    }

    /**
     * starts snake's movement
     */
    public void move() {
        board.fillElement(positionVer, positionHor);
        do {
            do {
                board.showBoard();
            } while (moveStep() == true);
        } while(turnCheck() == true);
    }

    /**
     * @return true if movement to any of 4 directions is allowed
     */
    private boolean turnCheck() {
        direction = Direction.down;
        if(moveCheck() == true) {
            positionVer++;
            board.fillElement(positionVer, positionHor);
            return true;
        }
        direction = Direction.right;
        if(moveCheck() == true) {
            positionHor++;
            board.fillElement(positionVer, positionHor);
            return true;
        }
        direction = Direction.up;
        if (moveCheck() == true) {
            positionVer--;
            board.fillElement(positionVer, positionHor);
            return true;
        }
        direction = Direction.left;
        if (moveCheck() == true) {
            positionHor--;
            board.fillElement(positionVer, positionHor);
            return true;
        }
        return false;
    }

    /**
     * makes snake move for 1 step in it's direction
     *
     * @return true if snake moved, otherwise false
     */
    private boolean moveStep() {
        if(moveCheck() == true) {
            switch (direction) {
                case down: {
                    positionVer++;
                    break;
                }
                case right: {
                    positionHor++;
                    break;
                }
                case left: {
                    positionHor--;
                    break;
                }
                case up: {
                    positionVer--;
                    break;
                }
            }
            board.fillElement(positionVer, positionHor);
            return true;
        }
        return false;
    }

    /**
     * checking if move is allowed
     *
     * @return true if move is allowed, otherwise false
     */
    private boolean moveCheck() {
        switch (direction) {
            case down: {
                if(checkSurround(positionVer + 1, positionHor) == 0
                        && board.getElement(positionVer + 1, positionHor) == 0) {
                    return true;
                }
                break;
            }
            case right: {
                if(checkSurround(positionVer, positionHor + 1) == 0
                        && board.getElement(positionVer, positionHor + 1) == 0) {
                    return true;
                }
                break;
            }
            case up: {
                if(checkSurround(positionVer - 1, positionHor) == 0
                        && board.getElement(positionVer - 1, positionHor) == 0) {
                    return true;
                }
                break;
            }
            case left: {
                if(checkSurround(positionVer, positionHor - 1) == 0
                        && board.getElement(positionVer, positionHor - 1) == 0) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    /**
     * gets the amount of filled elements of the board around element with given coordinates
     * @param positionHor vertical coordinate
     * @param positionVer horizontal coordinate
     * @return the amount of filled elements of the board around element with given coordinates
     */
    private int checkSurround(int positionVer, int positionHor) {
        int counter = 0;
        if(board.getElement(positionVer - 1, positionHor) == 1
                && direction != Direction.down) {
            counter++;
        }
        if(board.getElement(positionVer - 1, positionHor + 1) == 1
                && direction != Direction.down
                && direction != Direction.left) {
            counter++;
        }
        if(board.getElement(positionVer, positionHor + 1) == 1
                && direction != Direction.left) {
            counter++;
        }
        if(board.getElement(positionVer + 1, positionHor + 1) == 1
                && direction != Direction.up
                && direction != Direction.left) {
            counter++;
        }
        if(board.getElement(positionVer + 1, positionHor) == 1
                && direction != Direction.up) {
            counter++;
        }
        if(board.getElement(positionVer + 1, positionHor - 1) == 1
                && direction != Direction.up
                && direction != Direction.right) {
            counter++;
        }
        if(board.getElement(positionVer, positionHor - 1) == 1
                && direction != Direction.right) {
            counter++;
        }
        if(board.getElement(positionVer - 1, positionHor - 1) == 1
                && direction != Direction.down
                && direction != Direction.right) {
            counter++;
        }
        return counter;
    }
}