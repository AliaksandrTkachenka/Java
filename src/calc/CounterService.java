package calc;

import calc.cmdOperations.*;

import java.util.*;

public class CounterService {
    private List<Integer> integerList;
    private List<Operation> operationList = new ArrayList<>();
    private int maxOperationCounter;
    private static Map<Operation, CmdOperation> cmdOperationMap = new HashMap<>();
    private Integer result;
    private List<String> resultStrings = new ArrayList<>();
    private Counter counter;

    private final static int ADD_CODE = 0;
    private final static int SUBSTRACT_CODE = 1;
    private final static int MULTIPLY_CODE = 2;
    private final static int DIVIDE_CODE = 3;
    private final static int MERGE_CODE = 4;

    private final static int CMD_NUMBER = 5;

    /**
     * Parametrized constructor with the following parameters
     * @param integerList list of integer value to calculate
     * @param result result to be reached
     */
    public CounterService(List<Integer> integerList, Integer result) {
        this.integerList = integerList;
        this.result = result;
        initOperations();
        initCommandsOperations();
        this.maxOperationCounter = (int)Math.pow(cmdOperationMap.size(), operationList.size());
        counter = new Counter(cmdOperationMap);
    }

    /**
     * Calculates all the variations of the right expressions
     * @return list of strings. Format of the strings:
     * value1 operation1 value2 operation2 value3 etc.
     * or
     * value1value2 operation1 value3 etc.
     * If there's no resulting expression, string list is empty
     */
    public List<String> startCalculations() {
        for(int pattern = 0; pattern < maxOperationCounter; pattern++) {
            changeOperations(pattern);
            if (counter.count(integerList, operationList).equals(result)) {
                resultStrings.add(setToString());
            }
        }
        return resultStrings;
    }

    private void changeOperations(int operationPattern) {
        int commandSetter = 0;
        int index = 0;
        while(operationPattern != 0) {
            commandSetter = operationPattern % CMD_NUMBER;
            operationList.set(index, getOperationByCode(commandSetter));
            index++;
            operationPattern /= cmdOperationMap.size();
        }
    }

    private String setToString() {
        Iterator<Integer> integerIterator = integerList.iterator();
        Iterator<Operation> operationsIterator = operationList.iterator();
        StringBuilder stringBuilder = new StringBuilder();

        while(integerIterator.hasNext()) {
            stringBuilder.append(integerIterator.next());
            if(operationsIterator.hasNext()) {
                switch (operationsIterator.next()) {
                    case ADD: {
                        stringBuilder.append(" + ");
                        break;
                    }
                    case SUBSTRACT: {
                        stringBuilder.append(" - ");
                        break;
                    }
                    case MULTIPLY: {
                        stringBuilder.append(" * ");
                        break;
                    }
                    case DIVIDE: {
                        stringBuilder.append(" / ");
                        break;
                    }
                    case MERGE: {
                        break;
                    }
                }
            }
        }
        stringBuilder.append(" = ").append(result);
        return stringBuilder.toString();
    }

    private void initOperations() {
        for(int i = 0; i < integerList.size() - 1; i++) {
            operationList.add(Operation.ADD);
        }
    }

    private void initCommandsOperations() {
        cmdOperationMap.put(Operation.ADD, new CmdOperationAdd());
        cmdOperationMap.put(Operation.SUBSTRACT, new CmdOperationSubstract());
        cmdOperationMap.put(Operation.MULTIPLY, new CmdOperationMultiply());
        cmdOperationMap.put(Operation.DIVIDE, new CmdOperationDivide());
        cmdOperationMap.put(Operation.MERGE, new CmdOperationMerge());
    }

    private Operation getOperationByCode(int code) {
        switch (code) {
            case ADD_CODE: return Operation.ADD;
            case SUBSTRACT_CODE: return Operation.SUBSTRACT;
            case MULTIPLY_CODE: return Operation.MULTIPLY;
            case DIVIDE_CODE: return Operation.DIVIDE;
            case MERGE_CODE: return Operation.MERGE;
        }
        return null;
    }
}
