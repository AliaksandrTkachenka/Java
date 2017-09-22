package lecture3.xor;

import java.util.Scanner;

/**
 * Не думаю, что для задачи в 3 действия в одном методе (помимо ввода и вывода) создавать дополнительный класс
 * Если я не прав, поправь меня. С одной стороны, нет возможности для расширения. и это минус.
 * Но для тривиальной задачи, как мне кажется, незачем нагромождать всё.
 */

public class Main {
    public static void main(String[] args) {
        swap(input(), input());
    }

    public static void swap(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
        output(a, b);
    }

    /**
     * Однострочный вывод целоцичленных значений
     * @param a целочисленное число, введённое первым
     * @param b целочисленное число, введённое вторым
     */
    private static void output(int a, int b) {
        System.out.print(a + "\t" + b);
    }

    /**
     * Ввод целочисленного значения с проверкой типа
     * @return value, где value - введённое целочисленое значение
     */
    private static int input() {

        Scanner scanner = new Scanner(System.in);
        int value = 0;
        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return value;
    }
}
