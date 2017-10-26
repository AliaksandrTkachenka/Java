package lecture8.ownList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class OwnListTest {

    OwnList<Integer> ownList;
    @Before
    public void beforeAll() {
        ownList = new OwnList<>();
    }

    @Test
    public void addTestSizeAndGetElement() throws Exception {
        //given
        int expectedSize = 1;
        int expectedElement = 1;
        //when
        ownList.add(1);
        int actualSize = ownList.size();
        int actualElement = ownList.get(0);
        //then
        Assert.assertEquals("Incorrect size", expectedSize, actualSize);
        Assert.assertEquals("Incorrect value", expectedElement, actualElement);
    }

    @Test
    public void addETest() throws Exception {
        //given
        int expectedSize = 2;
        int expectedValue0 = 1;
        int expectedValue1 = 2;
        //when
        ownList.addE(1).addE(2);
        int actualValue0 = ownList.get(0);
        int actualValue1 = ownList.get(1);
        int actualSize = ownList.size();
        Assert.assertEquals("Incorrect size on addE with multiple invokes",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value [0] on addE",
                expectedValue0,
                actualValue0);
        Assert.assertEquals("Incorrect value [1] on addE",
                expectedValue1,
                actualValue1);
    }

    @Test
    public void addESeveralTest() throws Exception {
        //given
        int expectedSize = 2;
        int expected0 = 1;
        int expected1 = 2;
        //when
        ownList.addE(1).addE(2);
        int actualSize = ownList.size();
        int actualValue0 = ownList.get(0);
        int actualValue1= ownList.get(1);
        //then
        Assert.assertEquals("Incorrect size", expectedSize, actualSize);
        Assert.assertEquals("Incorrect value 0", expected0, actualValue0);
        Assert.assertEquals("Incorrect value 1", expected1, actualValue1);
    }

    @Test
    public void buildTestAllKindsOfAddAfterBuildShouldNotAdd() throws Exception {
        //given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);

        int expectedSize = 1;
        int expectedValue = 1;
        //when
        ownList.add(1);
        ownList.build();
        ownList.add(2);
        ownList.addE(3);
        ownList.addLast(4);
        ownList.addFirst(5);
        ownList.addAll(linkedList);
        ownList.addAll(0, linkedList);
        ownList.add(3, 12);
        ownList.addAllE(linkedList);
        ownList.addAllE(0,linkedList);
        int actualSize = ownList.size();
        int actualValue = 1;
        //then
        Assert.assertEquals("Added to the immutable list: incorrect size",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value int the list",
                expectedValue,
                actualValue);
    }

    @Test
    public void addFirstAddLastTest() throws Exception {
        //given
        int expectedSize = 3;
        int expectedFirstValue = 1;
        int expectedLastValue = 3;
        //when
        ownList.add(2);
        ownList.addFirst(1);
        ownList.addLast(3);
        int actualSize = ownList.size();
        int actualFirstValue = ownList.getFirst();
        int actualLastValue = ownList.getLast();
        Assert.assertEquals("Incorrect size", expectedSize, actualSize);
        Assert.assertEquals("Incorrect First Value", expectedFirstValue, actualFirstValue);
        Assert.assertEquals("Incorrect First Value", expectedLastValue, actualLastValue);
    }

    @Test
    public void addAllTest() throws Exception {
        //given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);

        int expectedSize = 7;
        int expectedValueN = 1;
        int expectedValueFirst = 10;
        int expectedValueLast = 12;
        //when
        ownList.add(1);
        ownList.addAll(linkedList);
        ownList.addAll(0, linkedList);
        int actualValueN = ownList.get(3);
        int actualValueFirst = ownList.getFirst();
        int actualValueLast = ownList.getLast();
        int actualSize = ownList.size();
        //then
        Assert.assertEquals("Incorrect size on add all",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value (first) on add all",
                expectedValueFirst,
                actualValueFirst);
        Assert.assertEquals("Incorrect value (middle) on add all",
                expectedValueN,
                actualValueN);
        Assert.assertEquals("Incorrect value (last) on add all",
                expectedValueLast,
                actualValueLast);
    }

    @Test
    public void addAllETest() throws Exception {
        //given
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(13);
        linkedList1.add(14);
        linkedList1.add(15);
        int expectedSize = 6;
        int expectedValue4 = 11;
        //when
        ownList.addAll(linkedList);
        ownList.addAll(0, linkedList1);
        int actualSize = ownList.size();
        int actualValue4 = ownList.get(4);
        //then
        Assert.assertEquals("Incorrect size on multiple invokes of addAllE",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect value on multiple invokes of addAllE",
                expectedValue4,
                actualValue4);
    }

    @Test
    public void addToThePositionTest() {
        //given
        ownList.addE(1).addE(2);
        int expectedSize = 3;
        int expectedValue = 3;
        int expectedNext = 2;
        //when
        ownList.add(1, 3);
        int actualSize = ownList.size();
        int actualValue = ownList.get(1);
        int actualNext = ownList.get(2);
        //then
        Assert.assertEquals("Incorrect size on insert",
                expectedSize,
                actualSize);
        Assert.assertEquals("Incorrect inserted value on insert",
                expectedValue,
                actualValue);
        Assert.assertEquals("Incorrect value next to inserted on insert",
                expectedNext,
                actualNext);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByIndexTest() throws Exception {
        //given
        ownList.add(1);
        int expectedSize = 0;
        Integer expectedElementAfterBuild = null;
        Integer expectedElementExisting = 1;
        //when
        Integer actualElementExisting = ownList.remove(0);
        Integer actual = ownList.remove(0);
        ownList.build();
        Integer actualElementAfterBuild = ownList.remove(0);
        int actualSize = ownList.size();
        //then
        Assert.assertEquals("Incorrect size on remove by index",
                expectedSize,
                actualSize);
        Assert.assertEquals("Removed from immutable list",
                expectedElementAfterBuild,
                actualElementAfterBuild);
        Assert.assertEquals("Incorrect value on remove existing element",
                expectedElementExisting,
                actualElementExisting);
        Assert.assertEquals("Incorrect exception or deleted incorrect element",
                expectedElementExisting,
                actualElementExisting);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstTest() throws Exception {
        //given
        int expectedSize = 1;
        Integer expected = null;
        Integer expectedElementAfterBuild = null;
        Integer expectedElementExisting = 1;
        //when
        Integer actual = ownList.removeFirst();
        ownList.addE(1).addE(2);
        Integer actualElementExisting = ownList.removeFirst();
        ownList.build();
        Integer actualElementAfterBuild = ownList.remove(0);
        int actualSize = ownList.size();
        //then
        Assert.assertEquals("Incorrect size on remove by index",
                expectedSize,
                actualSize);
        Assert.assertEquals("Removed from immutable list",
                expectedElementAfterBuild,
                actualElementAfterBuild);
        Assert.assertEquals("Incorrect value on remove existing element",
                expectedElementExisting,
                actualElementExisting);
        Assert.assertEquals("Incorrect exception or deleted incorrect element",
                expected,
                actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastTest() throws Exception {
        //given
        int expectedSize = 1;
        Integer expected = null;
        Integer expectedElementAfterBuild = null;
        Integer expectedElementExisting = 2;
        //when
        Integer actual = ownList.removeLast();
        ownList.addE(1).addE(2);
        Integer actualElementExisting = ownList.removeFirst();
        ownList.build();
        Integer actualElementAfterBuild = ownList.remove(0);
        int actualSize = ownList.size();
        //then
        Assert.assertEquals("Incorrect size on remove by index",
                expectedSize,
                actualSize);
        Assert.assertEquals("Removed from immutable list",
                expectedElementAfterBuild,
                actualElementAfterBuild);
        Assert.assertEquals("Incorrect value on remove existing element",
                expectedElementExisting,
                actualElementExisting);
        Assert.assertEquals("Incorrect exception or deleted incorrect element",
                expected,
                actual);
    }

    @Test
    public void removeExistingByObjectTest() {
        //given
        OwnList<String> stringOwnList = new OwnList<>();
        int expectedSize = 1;
        boolean expectedValueBeforeBuild = true;
        boolean expectedValueAfterBuild = false;
        stringOwnList.addE("one").addE("two");
        //when
        boolean actualValueBeforeBuild = stringOwnList.remove("one");
        int actualSizeBeforeBuild = stringOwnList.size();
        stringOwnList.build();
        boolean actualValueAfterBuild = stringOwnList.remove("two");
        int actualSizeAfterBuild = stringOwnList.size();
        //then
        Assert.assertEquals("Incorrect size before build on remove by object",
                expectedSize,
                actualSizeBeforeBuild);
        Assert.assertEquals("Incorrect size after build on remove by object",
                expectedSize,
                actualSizeAfterBuild);
        Assert.assertEquals("Incorrect size after build on remove by object",
                expectedValueBeforeBuild,
                actualValueBeforeBuild);
        Assert.assertEquals("Incorrect size after build on remove by object",
                expectedValueAfterBuild,
                actualValueAfterBuild);
    }

    @Test
    public void nextTestWithGetTest() throws Exception {
        //given
        ownList.addE(1).addE(2).addE(3).addE(4).addE(5);
        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedAfterGet = 4;
        //when
        int actualFirst = ownList.next();
        int actualSecond = ownList.next();
        ownList.get(3);
        int actualAfterGet = ownList.next();
        //then
        Assert.assertEquals("Incorrect first value on next",
                expectedFirst,
                actualFirst);
        Assert.assertEquals("Incorrect second (after next) value on next",
                expectedSecond,
                actualSecond);
        Assert.assertEquals("Incorrect value after get on next",
                expectedAfterGet,
                actualAfterGet);
    }
}