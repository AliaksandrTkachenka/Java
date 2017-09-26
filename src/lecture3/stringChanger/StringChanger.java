package lecture3.stringChanger;

import java.util.Scanner;

public class StringChanger {
    /**
     * Infinite loop with a possibility to choose operation
     *
     * @param string input string
     */
    public void start(String string) {
        Scanner scanner = new Scanner(System.in);
        String outString;
        String pattern = "";
        String replacement = "";
        System.out.println("Введите номер операции.\n" +
                "1. Удалить все числа из строки\n" +
                "2. Заменить все символы латинского алфавита символом ?\n" +
                "3. Оставить в строке только русские символы и числа\n" +
                "4. Ввести новую строку\n" +
                "5. Выход");
        while (true) {
            System.out.print(">");
            String operation = scanner.nextLine();
            switch (operation) {
                case "1": {
                    //Замена чисел на пустую строку - удаление
                    pattern = "\\d";
                    replacement = "";
                    break;
                }
                case "2": {
                    //Замена латинских символов на знак ?
                    pattern = "[a-zA-Z]";
                    replacement = "?";
                    break;
                }
                case "3": {
                    //Удаление всех символов, не являющихся символов кириллицы и цифр
                    pattern = "[^а-яА-Я0-9]";
                    replacement = "";
                    break;
                }
                //Ввод новой строки
                case "4": {
                    string = scanner.nextLine();
                    continue;
                }
                //Выход
                case "5": {
                    return;
                }
                default: {
                    System.out.println("Некорректный ввод");
                }
            }
            outString = string.replaceAll(pattern, replacement);
            System.out.println(outString);
        }
    }
}
