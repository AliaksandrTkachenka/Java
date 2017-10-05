package lecture3.stringChanger;

import java.util.HashMap;
import java.util.Map;

public abstract class Commands {
    String pattern;
    String replacement;
    protected String string;
    Map<String, Commands> hashMap = new HashMap<>();

    /**
     * constructor can only be used by subclass objects
     * @param string
     */
    Commands(String string) {
        this.string = string;
    }

    /**
     * Different kinds of operations which subclasses must override
     * @param string Input string
     * @return Output string
     */
    protected abstract String command(String string);

    /**
     * A common method for all sublcasses which modifies an input string of "command" method
     * @return modified string
     */
    String replace() {
        return string.replaceAll(pattern,replacement);
    }
}