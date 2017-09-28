package lecture3.snake;

import java.io.IOException;

public class Snake {
    private int[][] array;
    private int positionV;
    private int positionH;
    private int width;
    private int length;

    private enum direction {
        up,
        down,
        left,
        right
    }

    direction dir;
    private boolean isMoving;

    /**
     * Creates an empty array with start position (0,0) and start direction "down"
     * @param width
     * @param length
     */
    public Snake(int width, int length) {
        array = new int[length][width];
        positionV = 0;
        positionH = 0;
        array[positionV][positionH] = 1;
        this.width = width;
        this.length = length;
        dir = direction.down;
        isMoving = true;
    }

    private void output() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**
     * Describes the motion of a snake in a spiral with the verification
     * of the possibility of turning and continuing motion
     */
    public void start() {
        //Проверка на то, двигается ли ещё змейка.
        while (isMoving) {
            //Вывод текущего состояния матрицы (пооения змейки)
            output();
            if(width == 1 && length == 1) {
                break;
            }
            //В зависимости от направления движения проверки возможности движения различные
            //По сути, они симметричны. Если есть возможность сделать это более красиво, буду рад посмотреть.
            switch (dir) {
                case down: {
                    if(length == 1) {
                        array[positionV][positionH] = 1;
                        dir = direction.right;
                        break;
                    }
                    if (positionV + 2 < length) {
                        if (array[positionV + 2][positionH] == 0) {
                            array[positionV + 1][positionH] = 1;
                            positionV++;
                        } else {
                            if (positionH + 2 < width) {
                                if (array[positionV][positionH + 1] == 0 &&
                                        array[positionV + 1][positionH + 1] == 0 &&
                                        array[positionV][positionH + 2] == 0
                                        ) {
                                    dir = direction.right;
                                }
                                else {
                                    isMoving = false;
                                }
                            }
                            else {
                                isMoving = false;
                            }
                        }
                    } else if (positionV + 1 < length && positionV + 2 >= length) {
                        array[positionV + 1][positionH] = 1;
                        positionV++;
                        dir = direction.right;
                        if(width == 1) {
                            output();
                            isMoving = false;
                        }
                    }
                    //if(width)
                    break;
                }
                case right: {
                    if(width == 1) {
                        array[positionV][positionH] = 1;
                        dir = direction.up;
                        break;
                    }
                    if (positionH + 2 < width) {
                        if (array[positionV][positionH + 2] == 0) {
                            array[positionV][positionH + 1] = 1;
                            positionH++;
                        } else {
                            if (positionV - 1 > 0) {
                                if (array[positionV - 1][positionH] == 0 &&
                                        array[positionV - 1][positionH - 1] == 0 &&
                                        array[positionV - 2][positionH] == 0
                                        ) {
                                    dir = direction.up;
                                }
                                else {
                                    isMoving = false;
                                }
                            }
                            else {
                                isMoving = false;
                            }
                        }
                    } else if (positionH + 1 < width && positionH + 2 >= width) {
                        array[positionV][positionH + 1] = 1;
                        positionH++;
                        dir = direction.up;
                        if(length == 1) {
                            output();
                            isMoving = false;
                        }
                    }
                    break;
                }
                case up: {
                    if(length == 1) {
                        array[positionV][positionH] = 1;
                        dir = direction.left;
                        break;
                    }
                    if (positionV - 1 > 0) {
                        if (array[positionV - 2][positionH] == 0) {
                            array[positionV - 1][positionH] = 1;
                            positionV--;
                        } else {
                            if (positionH - 1 > 0) {
                                if (array[positionV][positionH - 1] == 0 &&
                                        array[positionV - 1][positionH - 1] == 0 &&
                                        array[positionV][positionH - 2] == 0
                                        ) {
                                    dir = direction.left;
                                }
                                else {
                                    isMoving = false;
                                }
                            }
                            else {
                                isMoving = false;
                            }
                        }
                    } else if (positionV > 0 && positionV - 2 <= 0) {
                        array[positionV - 1][positionH] = 1;
                        positionV--;
                        dir = direction.left;
                        if(width == 1) {
                            output();
                            isMoving = false;
                        }
                    }
                    break;
                }
                case left: {
                    if(width == 1) {
                        array[positionV][positionH] = 1;
                        dir = direction.down;
                        break;
                    }
                    if (positionH - 1 > 0) {
                        if (array[positionV][positionH - 2] == 0) {
                            array[positionV][positionH - 1] = 1;
                            positionH--;
                        } else {
                            if (positionV + 2 < length) {
                                if (array[positionV + 1][positionH] == 0 &&
                                        array[positionV + 1][positionH + 1] == 0 &&
                                        array[positionV + 2][positionH] == 0
                                        ) {
                                    dir = direction.down;
                                }
                                else {
                                    isMoving = false;
                                }
                            }
                            else {
                                isMoving = false;
                            }
                        }
                    } else if (positionH > 0 && positionH - 2 <= 0) {
                        array[positionV][positionH - 1] = 1;
                        positionH--;
                        dir = direction.down;
                        if(length == 1) {
                            output();
                            isMoving = false;
                        }
                    }
                    break;
                }
            }
        }
    }
}
