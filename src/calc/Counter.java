package calc;

import calc.cmdOperations.*;

import java.util.*;

public class Counter {
    private int currentPriority;
    private Map<Operation, CmdOperation> commandMap;
    private List<Integer> integerList;
    private List<Operation> operationList;
    private CmdOperation command;

    /**
     * Parametrized constructor with the following parameter
     * @param commandMap assigns command operations and operations
     */
    public Counter(Map<Operation, CmdOperation> commandMap) {
        this.commandMap = new HashMap<>(commandMap);
    }

    /**
     * Counts expression with given parameters
     * @param integerList list of integer values
     * @param operationList operations between integer values
     * @return result of the expression
     */
    public Integer count(List<Integer> integerList, List<Operation> operationList) {
        this.integerList = new ArrayList<>(integerList);
        this.operationList = new ArrayList<>(operationList);
        currentPriority = countMinPriority(operationList);
        return countAll();
    }

    private Integer countAll() {
        Iterator<Operation> operationIterator = operationList.iterator();
        Operation operation;

        while(operationIterator.hasNext()) {
            operation = operationIterator.next();
            if(getOperationPriority(operation) == currentPriority) {
                countCurrent(operationList.indexOf(operation));
                operationIterator = operationList.iterator();
            }
        }

        currentPriority--;
        if(currentPriority < 0) {
            return integerList.get(0);
        }
        countAll();
        return integerList.get(0);
    }

    private void countCurrent(int index) {
        command = commandMap.get(operationList.get(index));
        Integer current = command.command(integerList.get(index), integerList.get(index + 1));
        integerList.remove(index + 1);
        integerList.set(index, current);
        operationList.remove(index);
    }

    private int countMinPriority(List<Operation> operationList) {
        int minPriority = 0;
        for(Operation operation : operationList) {
            if(minPriority < getOperationPriority(operation)) {
                minPriority = getOperationPriority(operation);
            }
        }
        return minPriority;
    }

    private int getOperationPriority(Operation operation) {
        if(operation == Operation.ADD || operation == Operation.SUBSTRACT) {
            return 0;
        }
        if(operation == Operation.MULTIPLY || operation == Operation.DIVIDE) {
            return 1;
        }
        if(operation == Operation.MERGE) {
            return 2;
        }
        return 0;
    }
}
