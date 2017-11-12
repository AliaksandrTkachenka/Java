package calc;

import calc.cmdOperations.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CounterTest {
    private Map<Operation, CmdOperation> cmdOperationMap = new HashMap<>();
    @Before
    public void init() {
        cmdOperationMap.put(Operation.ADD, new CmdOperationAdd());
        cmdOperationMap.put(Operation.SUBSTRACT, new CmdOperationSubstract());
        cmdOperationMap.put(Operation.MULTIPLY, new CmdOperationMultiply());
        cmdOperationMap.put(Operation.DIVIDE, new CmdOperationDivide());
        cmdOperationMap.put(Operation.MERGE, new CmdOperationMerge());
    }

    @Test
    public void countTest() throws Exception {
        //given
        Counter counter = new Counter(cmdOperationMap);
        List<Integer> integerList = new ArrayList<>();

        integerList.add(5);
        integerList.add(2);

        List<Operation> operationListAdd = new ArrayList<>();
        operationListAdd.add(Operation.ADD);
        List<Operation> operationListSubstract = new ArrayList<>();
        operationListSubstract.add(Operation.SUBSTRACT);
        List<Operation> operationListMultply = new ArrayList<>();
        operationListMultply.add(Operation.MULTIPLY);
        List<Operation> operationListDivide = new ArrayList<>();
        operationListDivide.add(Operation.DIVIDE);
        List<Operation> operationListMerge = new ArrayList<>();
        operationListMerge.add(Operation.MERGE);
        //when
        Integer actualResultAdd = counter.count(integerList, operationListAdd);
        Integer actualResultSubstract = counter.count(integerList, operationListSubstract);
        Integer actualResultMultiply = counter.count(integerList, operationListMultply);
        Integer actualResultDivide = counter.count(integerList, operationListDivide);
        Integer actualResultMerge = counter.count(integerList, operationListMerge);
        //then
        Assert.assertEquals("Incorrectly counted add",
                Integer.valueOf(7),
                actualResultAdd);
        Assert.assertEquals("Incorrectly counted substract",
                Integer.valueOf(3),
                actualResultSubstract);
        Assert.assertEquals("Incorrectly counted multiply",
                Integer.valueOf(10),
                actualResultMultiply);
        Assert.assertEquals("Incorrectly counted divide",
                Integer.valueOf(2),
                actualResultDivide);
        Assert.assertEquals("Incorrectly counted merge",
                Integer.valueOf(52),
                actualResultMerge);
    }

}