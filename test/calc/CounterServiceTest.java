package calc;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CounterServiceTest {
    @Test
    public void startCalculationsTest() throws Exception {
        //given
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(5);

        List<String> expectedStringListNotNull = new ArrayList<>();
        List<String> expectedStringListNull = new ArrayList<>();

        expectedStringListNotNull.add("1 * 2 + 3 + 5 = 10");
        expectedStringListNotNull.add("12 + 3 - 5 = 10");

        CounterService serviceNotNull = new CounterService(integerList, 10);
        CounterService serviceNull = new CounterService(integerList, 255);
        List<String> actualStringListNotNull;
        List<String> actualStringListNull;
        //when
        actualStringListNotNull = serviceNotNull.startCalculations();
        actualStringListNull = serviceNull.startCalculations();
        //then
        Assert.assertEquals("Incorrect expressions",
                expectedStringListNotNull,
                actualStringListNotNull);
        Assert.assertEquals("Incorrect expressions",
                expectedStringListNull,
                actualStringListNull);

    }

}