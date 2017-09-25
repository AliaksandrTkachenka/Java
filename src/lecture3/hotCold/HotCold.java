package lecture3.hotCold;

import java.util.Random;

public class HotCold {


    /**
     * search for a randomized value
     * @param min initial range value
     * @param max range end value
     */
    public void start(int min, int max) {
        //Если в диапазоне первым указано максимальное значение, а потом минимальное, меняем их местами
            if(min > max) {
                min ^= max;
                max ^= min;
                min ^= max;
        }
        //Загаданное значение
        int value;
        //Ушадали ли значение - для проверки в цикле
        boolean isGuessed = false;
        //Для определения того, ближе мы к загаданному значению, нежели в прошлый раз,
        //храним прошлую попытку.
        int previousTry;
        int currentTry;
        //Счётчик попыток
        int counter = 0;
        Random random = new Random();
        value = random.nextInt(max - min + 1) + min;
        Input input = new Input();
        //Для более удобного сравнения используем не сами числа, а их "расстояние" от загаданного значения
        int currentDifference = 0;
        int previousDifference = 0;
        //Инициализируем предыдущую попытку как наиболее удалённую от загаданного,
        // но в диапазоне от минимального до максимального
        previousTry = (value > 0) ?  max : min;
        while(true) {
            counter++;
            System.out.println("Введите число");
            currentTry = input.inputInt();
            if(currentTry == value) {
                System.out.println("Угадали за " + counter + " попыток");
                break;
            }
            //Расчёт "удалённости" от искомого значения в предыдущий и текущий раз
            //Возможно, стоило хранить именно разницу, чтобы не вычислять её каждый раз
            previousDifference = (value > previousTry) ? value - previousTry : previousTry - value;
            currentDifference = (value > currentTry) ? value - currentTry : currentTry - value;
            if(previousDifference > currentDifference) {
                System.out.println("Горячо");
            }
            else {
                System.out.println("Холодно");
            }
            previousTry = currentTry;
        }
    }


}
