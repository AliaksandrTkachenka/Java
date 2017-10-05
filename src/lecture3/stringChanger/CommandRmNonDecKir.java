package lecture3.stringChanger;

public class CommandRmNonDecKir extends Commands {
    CommandRmNonDecKir(String string) {
        super(string);
    }

    @Override
    protected String command(String string) {
        pattern = "[^а-яА-Я0-9]";
        replacement = "";
        super.string = string;
        return super.replace();
    }
}
