package lecture8.ownList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ImmutableListBuilderTest {
    ImmutableList<String> immutableList;
    ImmutableList.ImmutableListBuilder<String> builder;

    @Before
    public void init() {
        builder = new ImmutableList.ImmutableListBuilder<>();
    }

    @Test
    public void addSeveralTest() {
        //given
        int expectedSize = 2;
        String expectedValue = "string 2";
        //when
        immutableList = builder.add("string 1").add("string 2").build();
        int actualSize = immutableList.size();
        String actualValue = immutableList.get(1);
        //then
        Assert.assertEquals("Incorrect size on adding several values in a row",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value on adding several values in a row",
                expectedValue,
                actualValue);
    }

    @Test
    public void addAllTest() {
        //given
        int expectedSize = 2;
        List<String> stringList = new ArrayList<>();
        stringList.add("string 1");
        stringList.add("string 2");
        String expectedValue = "string 2";
        //when
        immutableList = builder.addAll(stringList).build();
        int actualSize = immutableList.size();
        String actualValue = immutableList.get(1);
        //then
        Assert.assertEquals("Incorrect size on addAll",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value on addAll",
                expectedValue,
                actualValue);
    }

    @Test
    public void removeTest() {
        //given
        int expectedSize = 1;
        List<String> stringList = new ArrayList<>();
        stringList.add("string 1");
        stringList.add("string 2");
        String expectedValue = "string 2";
        //when
        immutableList = builder.addAll(stringList).remove("string 1").build();
        int actualSize = immutableList.size();
        String actualValue = immutableList.get(0);
        //then
        Assert.assertEquals("Incorrect size on remove",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value on remove",
                expectedValue,
                actualValue);
    }

    @Test
    public void add() {
        //given
        int expectedSize = 3;
        List<String> stringList = new ArrayList<>();
        stringList.add("string 1");
        stringList.add("string 2");
        stringList.add("string 3");
        String expectedValue = "string 2";
        //when
        String value;
        Iterator<String> itr = immutableList.iterator();
        for(int i = 0; i < 5; i++) {
            value = itr.next();
        }
        immutableList = builder.addAll(stringList).build();
        int actualSize = immutableList.size();
        String actualValue = immutableList.get(1);
        //then
        Assert.assertEquals("Incorrect size on addAll",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value on addAll",
                expectedValue,
                actualValue);
    }
}
