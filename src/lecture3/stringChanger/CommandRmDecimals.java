package lecture3.stringChanger;

public class CommandRmDecimals extends Commands {

    CommandRmDecimals(String string) {
        super(string);
    }

    @Override
    protected final String command(String string) {
        pattern = "\\d";
        replacement = "";
        super.string = string;
        return super.replace();
    }
}
