package shift;

import java.util.Scanner;

public class Main {
    //Не до конца понял, что требуется в этой задаче.
    //Если просто продемонстрировать работу операторов сдвига, то самым наглядным
    //было бы отразить вывод значения после сдвига.
    //Наиболее эффективное - ввести нечётное значение для первого.
    //В этом случае отобразится целовичленное деление на 2 в степени количества разрядов сдвига
    //В третьем - отрицательное число, в этом сучае последний вывод отобразит Integer.MAX_VALUE - value / 2
    //В последнем - (Integer.MAX_VALUE - value / 2) / 2
    //Вывод Integer.MAX_VALUE - для сравнения и анализа
    //
    //Если надо что-то ещё для демонстрации, пиши, доделаю/переделаю


    public static void main(String[] args) {
        int value = input();
        value >>= 1;
        System.out.println(value);
        value <<= 2;
        System.out.println(value);
        value >>>= 1;
        System.out.println(value >>> 1);
        System.out.println(value >>> 2);
        System.out.println(Integer.MAX_VALUE);
    }

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
