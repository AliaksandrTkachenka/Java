package lecture3.task4;

import lecture3.hotCold.Input;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        int length = input.inputInt();
        int width = input.inputInt();
        if(length <= 0 || width <= 0) {
            System.out.println("Incorrect input");
            return;
        }
        Task4 task4 = new Task4();
        task4.start(width, length);

    }
}
