package lecture3.stringChanger;

import java.util.Scanner;

//stringChanger
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        StringChanger stringChanger = new StringChanger();
        stringChanger.start(string);
    }
}
