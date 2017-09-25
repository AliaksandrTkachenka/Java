package lecture3.task4;

import java.util.Random;

import lecture3.hotCold.Input;

public class Task4 {

    private static final int BOUND = 0;

    /**
     * randomizes array with numbers from 0 to BOUND
     * and counts number of value that is derived from a keyboard
     *
     * @param width  array's width (vertical size)
     * @param length array's length (horizontal size)
     */
    public void start(int width, int length) {
        int[][] array = new int[length][width];
        Random random = new Random();
        //Заполняем массив случайными числами от 0 до верхней границы - BOUND
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = random.nextInt(BOUND + 1);
            }
        }
        int counter = 0;
        Input input = new Input();
        System.out.println("Введите число от 0 до 100");
        //Считаем количество чисел в масстве, равному введённому с клавиатуры
        int value = input.inputInt();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (value == array[i][j]) {
                    counter++;
                }
            }
        }
        //Вывод количества совпадений и самого массива
        System.out.println(counter);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }
}

