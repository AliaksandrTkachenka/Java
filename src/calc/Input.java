package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    private List<Integer> list;

    /**
     * Input integer values using keyboard
     * @return the list of integer values split by any delimiters including non-decimal characters such as +,-,*,/
     * all the non-decimal characters will be ignored
     */
    public List<Integer> inputValues() {
        list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while (matcher.find()) {
            list.add(Integer.parseInt(matcher.group()));
        }
        return list;
    }
}
