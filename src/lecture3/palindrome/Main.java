package lecture3.palindrome;

import java.util.Scanner;

/**
 * Splitting an input string by the pattern and checking it whether it is a palindrome
 */
public class Main {
    public static void main(String[] args) {
        //Ввод строки с клавиатуры
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        //Шаблон - всё, кроме букв для разбиения именно на слова
        String pattern = "[^a-zA-Zа-яА-Я]";
        //Разбиваем строку
        String[] stringArray = string.split(pattern);
        //Проходим циклом foreach по массиву строк, полученных разбиением исходной строки
        for (String outString: stringArray) {
            StringBuilder stringBuilder = new StringBuilder(outString);
            //Проверяем, совпадает ли она со своим отражением
            if(outString.equalsIgnoreCase(stringBuilder.reverse().toString())) {
                System.out.println(outString);
            }
        }
            
    }
}
