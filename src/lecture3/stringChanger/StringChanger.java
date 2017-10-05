package lecture3.stringChanger;

import java.util.HashMap;
import java.util.Map;

    class StringChanger {
    private Commands commands;
    private String string;
    private String outString;
    private boolean breakFlag;
    private HashMap<String, Commands> hashMap = new HashMap<>();

    /**
     * Infinite loop with a possibility to choose within operations
     */
    public void start() {
        breakFlag = true;
        InputString inputString = new InputString();
        System.out.println("Введите строку");
        string = inputString.input();
        init(string);
        System.out.println("Введите номер операции.\n" +
                "1. Удалить все числа из строки\n" +
                "2. Заменить все символы латинского алфавита символом ?\n" +
                "3. Оставить в строке только русские символы и числа\n" +
                "4. Ввести новую строку\n" +
                "Ввод прочих команд: выход");
        while (breakFlag == true) {
            System.out.print(">");
            String operation = inputString.input();
            //С 4 до меня не дошло, как сделать так же, если не выносить в отдельную группу классов
            if(operation.equals("4")) {
                System.out.println("Введите новую строку");
                string = inputString.input();
                continue;
            }
            commands = hashMap.get(operation);
            if(commands == null) {
                breakFlag = false;
            }
            outString = commands.command(string);
            if(outString == null) {
                breakFlag = false;
            }
            if(breakFlag == true) {
                System.out.println(outString);
            }
        }
    }

    private Map<String, Commands> init(String string) {
        hashMap.put("1", new CommandRmDecimals(string));
        hashMap.put("2", new CommandRpLatins(string));
        hashMap.put("3", new CommandRmNonDecKir(string));
        return hashMap;
    }
}