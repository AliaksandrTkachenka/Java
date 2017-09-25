package lecture3.lcmGdc;

import java.util.Scanner;

/**
 * Input 2 values. First counting greatest common divisor (gcd) then
 * least common multiple
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите 2 числа");
        int value1 = input();
        int value2 = input();
        System.out.println("НОД: " + gdc(value1, value2) + "\nНОК: " + lcm(value1, value2));
    }

    /**
     * GDC or greatest common divisor is calculated by Euclid's Algorithm
     * @param value1 is the first value for calculating GDC
     * @param value2 is the second value for calculating GDC
     * @return result which is greatest common divisor
     */
    public static int gdc(int value1, int value2) {
        return value2 == 0 ? value1 : gdc(value2, value1 % value2);
    }

    /**
     * LCM or least common multiple is calculated by the formula value1 * value2 / GCD (value1, value2)
     * @param value1 is the first value for calculating LCM
     * @param value2 is the second value for calculating LCM
     * @return result which is least common multiple
     */
    public static int lcm(int value1, int value2) {
        return value1 * value2 / gdc(value1, value2);
    }

    private  static int input() {
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
