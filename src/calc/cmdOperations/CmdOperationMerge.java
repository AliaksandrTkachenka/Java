package calc.cmdOperations;

public class CmdOperationMerge extends CmdOperation {
    private StringBuilder stringBuilder;

    @Override
    protected void setPriority() {
        super.priority = super.PRIORITY_MERGE;
    }

    /**
     * Command to merge the first and the second integer values
     * @param first first integer value
     * @param second second integer value
     * @return the result of merging or null if the value exceeds maximum integer value or minimum integer value
     */
    @Override
    public Integer command(Integer first, Integer second) {
        stringBuilder = new StringBuilder(first.toString());
        stringBuilder.append(second);
        Long value = Long.parseLong(stringBuilder.toString());
        if(checkValue(value)) {
            return Integer.parseInt(stringBuilder.toString());
        }
        return null;
    }

    @Override
    protected boolean checkIntegerBound(Integer first, Integer second) {
        return true;
    }
}
