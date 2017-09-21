package lecture3.butterfly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Butterfly butterfly = new Butterfly(input());
        output(butterfly.fill());

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
    private static void output(int[][] array) {
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
