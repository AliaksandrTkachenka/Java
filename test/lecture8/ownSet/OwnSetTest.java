package lecture8.ownSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class OwnSetTest {

    OwnSet<Integer> ownSet;
    public static Integer ONE = 1;
    public static int AMOUNT = 5;

    @Before
    public void setUp() throws Exception {
        ownSet = new OwnSet<>();
    }

    @Test
    public void addCheck() throws Exception {
        //given
        boolean expected = true;
        //when
        boolean actual = ownSet.add(ONE);
        //then
        Assert.assertEquals("Wrong actual value of adding", expected, actual);
    }

    @Test
    public void getAmountCheckForNoneValues() throws Exception {
        //given
        int expected = 0;
        //when
        int actual = ownSet.getAmount(ONE);
        //then
        Assert.assertEquals("Wrong number of values", expected, actual);
    }

    @Test
    public void getAmountCheckForSeveralValues() throws Exception {
        //given
        for(int i = 0; i < AMOUNT; i++) {
            ownSet.add(ONE);
        }
        int expected = AMOUNT;
        //when
        int actual = ownSet.getAmount(ONE);
        //then
        Assert.assertEquals("Wrong number of values", expected, actual);
    }

    @Test
    public void removeExistingElement() throws Exception {
        //given
        boolean expected = true;
        ownSet.add(ONE);
        //when
        boolean actual = ownSet.remove(ONE);
        //then
        Assert.assertEquals("Could'n remove existing element", expected, actual);
    }

    @Test
    public void removeNotExistingElement() throws Exception {
        //given
        boolean expected = false;
        //when
        boolean actual = ownSet.remove(ONE);
        //then
        Assert.assertEquals("Deleted not existing element element", expected, actual);
    }

    @Test
    public void removeAllExistingElement() throws Exception {
        //given
        boolean expected = true;
        ownSet.add(ONE);
        //when
        boolean actual = ownSet.removeAll(ONE);
        //then
        Assert.assertEquals("Could'n delete element", expected, actual);
    }

    @Test
    public void removeAllNotExistingElement() throws Exception {
        //given
        boolean expected = false;
        //when
        boolean actual = ownSet.removeAll(ONE);
        //then
        Assert.assertEquals("Deleted not existing element", expected, actual);
    }

    @Test
    public void removeSeveralExistingElementGetAmount() throws Exception {
        //given
        int expected = 4;
        for(int i = 0; i < AMOUNT; i++) {
            ownSet.add(ONE);
        }
        ownSet.remove(ONE);
        //when
        int actual = ownSet.getAmount(ONE);
        //then
        Assert.assertEquals("Wrong number of values", expected, actual);
    }

    @Test
    public void removeAllElementsGetAmount() throws Exception {
        //given
        int expected = 0;
        for(int i = 0; i < AMOUNT; i++) {
            ownSet.add(ONE);
        }
        ownSet.removeAll(ONE);
        //when
        int actual = ownSet.getAmount(ONE);
        //then
        Assert.assertEquals("Wrong number of values", expected, actual);
    }

    @Test
    public void containsExisting() throws Exception {
        //given
        boolean expected = true;
        ownSet.add(ONE);
        //when
        boolean actual = ownSet.contains(ONE);
        //then
        Assert.assertEquals("Doesn't contain existing element", expected, actual);
    }

    @Test
    public void containsNotExisting() throws Exception {
        //given
        boolean expected = false;
        //when
        boolean actual = ownSet.contains(ONE);
        //then
        Assert.assertEquals("Contains not existing element", expected, actual);
    }

    @Test
    public void containsNotExistingAddRemove() throws Exception {
        //given
        boolean expected = false;
        ownSet.add(ONE);
        ownSet.remove(ONE);
        //when
        boolean actual = ownSet.contains(ONE);
        //then
        Assert.assertEquals("Contains not existing element", expected, actual);
    }

    @Test
    public void isEmptyEmpty() throws Exception {
        //given
        boolean expected = true;
        //when
        boolean actual = ownSet.isEmpty();
        //then
        Assert.assertEquals("Not empty without elements", expected, actual);
    }

    @Test
    public void isEmptyNotEmpty() throws Exception {
        //given
        boolean expected = false;
        ownSet.add(ONE);
        //when
        boolean actual = ownSet.isEmpty();
        //then
        Assert.assertEquals("Is empty with elements", expected, actual);
    }

    @Test
    public void isEmptyEmptyAddRemove() throws Exception {
        //given
        boolean expected = true;
        ownSet.add(ONE);
        ownSet.remove(ONE);
        //when
        boolean actual = ownSet.isEmpty();
        //then
        Assert.assertEquals("Not empty without elements", expected, actual);
    }

    @Test
    public void sizeCheck() throws Exception {
        //given
        int expected = 1;
        ownSet.add(ONE);
        ownSet.add(ONE);
        //when
        int actual = ownSet.size();
        //then
        Assert.assertEquals("Size is wrong", expected, actual);
    }

    @Test
    public void sizeTotalCheck() throws Exception {
        //given
        int expected = 2;
        ownSet.add(ONE);
        ownSet.add(ONE);
        //when
        int actual = ownSet.sizeTotal();
        //then
        Assert.assertEquals("Size is wrong", expected, actual);
    }

    @Test
    public void clearSizeTest() throws Exception {
        //given
        int expected = 0;
        ownSet.add(ONE);
        ownSet.add(2);
        ownSet.clear();
        //when
        int actual = ownSet.size();
        //then
        Assert.assertEquals("Size is wrong", expected, actual);
    }

    @Test
    public void equalsCheckEquals() throws Exception {
        //given
        boolean expected = true;
        ownSet.add(ONE);
        OwnSet<Integer> ownSet1 = new OwnSet<>();
        ownSet1.add(ONE);
        //when
        boolean actual = ownSet.equals(ownSet1);
        //then
        Assert.assertEquals("Not equal return wrong value", expected, actual);
    }

    @Test
    public void equalsCheckNotEquals() throws Exception {
        //given
        boolean expected = false;
        ownSet.add(ONE);
        OwnSet<Integer> ownSet1 = new OwnSet<>();
        ownSet1.add(2);
        //when
        boolean actual = ownSet.equals(ownSet1);
        //then
        Assert.assertEquals("Equals return wrong value", expected, actual);
    }

    @Test
    public void equalsCloned() throws Exception {
        //given
        boolean expected = true;
        ownSet.add(ONE);
        OwnSet<Integer> ownSet1 = new OwnSet<>();
        ownSet1 = ownSet.clone();
        //when
        boolean actual = ownSet.equals(ownSet1);
        //then
        Assert.assertEquals("Cloned set is not equal to original", expected, actual);
    }
}