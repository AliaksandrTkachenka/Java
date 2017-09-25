package lecture3.hotCold;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите диапазон значений");
        HotCold hotCold = new HotCold();
        Input input = new Input();
        hotCold.start(input.inputInt(), input.inputInt());
    }

}
