package lecture3.snake;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Snake snake = new Snake(input(), input());
        snake.start();
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        if(value <= 0) {
            System.out.println("Incorrect input");
        }
        return value;
    }
}
