package calc.cmdOperations;

public class CmdOperationDivide extends CmdOperation {
    @Override
    protected void setPriority() {
        super.priority = super.PRIORITY_MULTIPLY;
    }

    /**
     * Command to divide the first and the second integer values.
     * @param first first integer value
     * @param second second integer value
     * @return the result of division or null if the the second value is zero
     */
    @Override
    public Integer command(Integer first, Integer second) {
        if(second == 0) {
            return null;
        }
        return first / second;
    }

    @Override
    protected boolean checkIntegerBound(Integer first, Integer second) {
        return true;
    }
}
