package lecture4.sportsmen;

import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

public class Main {
    private static Random random = new Random();
    private static Comparator<Sportsman> comparator;
    public static void main(String[] args) {
        Sportsman[] sportsmen = new Sportsman[10];
        //Использование 2 конструкторов - с параметрами - первых 5, по умолчанию - последних 5
        for(int i = 0; i < 5; i++) {
            sportsmen[i] = new Sportsman(randomizeName(), random.nextInt(30), random.nextInt(40));
        }
        for(int i = 5; i < 10; i++) {
            sportsmen[i] = new Sportsman();
            sportsmen[i].setName(randomizeName());
            sportsmen[i].setGoldMedals(random.nextInt(30));
            sportsmen[i].setSilverMedals(random.nextInt(40));
        }
        System.out.print("Сортировка по имени\n");
        comparator = new NameComparator();
        Arrays.sort(sportsmen, comparator);
        printArray(sportsmen);
        System.out.print("Сортировка по золотым медалям\n");
        comparator = new GoldMedalsComparator();
        Arrays.sort(sportsmen, comparator);
        printArray(sportsmen);
        System.out.print("Сортировка по серебряным медалям\n");
        comparator = new SilverMedalsComparator();
        Arrays.sort(sportsmen, comparator);
        printArray(sportsmen);
    }

    private static void printArray(Sportsman[] sportsmen) {
        for (int i = 0; i < 10; i++) {
            System.out.println(sportsmen[i].toString());
        }
    }

    private static String randomizeName() {
        int randomizer;
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j < 10; j++) {
            randomizer = random.nextInt(26) + 97;
            stringBuilder.append((char)randomizer);
        }
        return stringBuilder.toString();
    }
}
