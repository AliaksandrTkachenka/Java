package lecture3.snake;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Введите размер матрицы, начальную позицию и направление движения\n" +
                "d - вниз, u - вверх, l - влево, r - вправо\n" +
                "По умолчанию - вниз\n");
        Snake snake = new Snake(inputSize(), inputSize(), inputPosition(), inputPosition(), inputString());
        snake.move();
    }
    private  static int inputSize() {
        int value = inputInt();
        if(value <= 0) {
            System.out.print("Incorrect input");
            return 1;
        }
        return value;
    }

    private static int inputPosition() {
        int value = inputInt();
        if(value < 0) {
            System.out.print("Incorrect input");
            return 0;
        }
        return value;
    }

    private static int inputInt() {
        int value = 0;
        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return value;
    }

    private static Direction inputString() {
        String s = scanner.nextLine();
        switch (s) {
            case "l": {
                return Direction.left;
            }
            case "r": {
                return Direction.right;
            }
            case "u": {
                return Direction.up;
            }
            default: {
                return Direction.down;
            }
        }
    }
}
