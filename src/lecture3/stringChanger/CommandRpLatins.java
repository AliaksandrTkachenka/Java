package lecture3.stringChanger;

public class CommandRpLatins extends Commands {
    CommandRpLatins(String string) {
        super(string);
    }

    @Override
    protected String command(String string) {
        replacement = "?";
        pattern = "[a-zA-Z]";
        super.string = string;
        return super.replace();
    }
}
