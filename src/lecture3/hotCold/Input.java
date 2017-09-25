package lecture3.hotCold;

import java.util.Scanner;

//Для избежания повтора кода вынес выполнение ввода в отдельный класс/метод.
//По хорошему, его можно было бы использовать и в других задачах.
//Такой вопрос: лучше сделать отдельный пакет для ввода
// или достаточно поместить этот ввод в класс внутри пакета lecture3?
public class Input {
    /**
     * Input integer value or throw NumberFormatException
     * @see "https://docs.oracle.com/javase/7/docs/api/java/lang/NumberFormatException.html"
     * @return integer value
     */
    public int inputInt() {
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
