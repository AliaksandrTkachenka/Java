package lecture3.factorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        Factorial factorial = new Factorial();
        System.out.println("Input value:");
        result = input();
        System.out.println("Factorial:");
        result = factorial.count(result);
        System.out.println(result);

    }
    private static int input() {

        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return 0;
    }
}
