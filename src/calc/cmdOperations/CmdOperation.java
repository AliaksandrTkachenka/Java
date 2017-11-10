package calc.cmdOperations;

public abstract class CmdOperation {
    protected int priority;
    protected final static int PRIORITY_ADD = 2;
    protected final static int PRIORITY_MULTIPLY = 1;
    protected final static int PRIORITY_MERGE = 0;

    /**
     * Command to calculate some operations between two integer values
     * @param first first integer value
     * @param second second integer value
     * @return the result of calculations
     */
    public abstract Integer command(Integer first, Integer second);

    protected abstract void setPriority();
    protected abstract boolean checkIntegerBound(Integer first, Integer second);

    protected boolean checkValue(Long value) {
        if(value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }
}
