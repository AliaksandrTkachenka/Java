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

}