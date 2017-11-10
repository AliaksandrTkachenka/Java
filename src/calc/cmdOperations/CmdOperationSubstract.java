package calc.cmdOperations;

public class CmdOperationSubstract extends CmdOperation {
    @Override
    protected void setPriority() {
        super.priority = super.PRIORITY_ADD;
    }

    /**
     * Command to substract the first and the second integer values
     * @param first first integer value
     * @param second second integer value
     * @return the result of substracting or null if the value exceeds maximum integer value or minimum integer value
     */
    @Override
    public Integer command(Integer first, Integer second) {
        if(checkIntegerBound(first, second)) {
            return first - second;
        }
        return null;
    }

    @Override
    protected boolean checkIntegerBound(Integer first, Integer second) {
        return checkValue(Long.valueOf(first) - Long.valueOf(second));
    }
}
