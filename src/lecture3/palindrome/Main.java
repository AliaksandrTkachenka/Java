package lecture3.palindrome;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String pattern = "[^a-zA-Zа-яА-Я]";
        String[] stringArray = string.split(pattern);
        for (String outString: stringArray) {
            StringBuilder stringBuilder = new StringBuilder(outString);
            if(outString.equalsIgnoreCase(stringBuilder.reverse().toString())) {
                System.out.println(outString);
            }
        }
            
    }
}
