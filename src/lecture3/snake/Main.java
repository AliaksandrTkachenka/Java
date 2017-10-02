package lecture3.snake;

public class Main {
    public static void main(String[] args) {
        Snake snake = new Snake(8, 10, 4, 5, Direction.left);
        snake.move();
    }
}
