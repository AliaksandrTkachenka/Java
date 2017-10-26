package lecture12.connections;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void testRequest() {
        //given
        UserDAO userDAO = new UserDAO();
        String expected = "login2";
        //when
        String actual = userDAO.getUser(2).getLogin();
        //then
        Assert.assertEquals("Wrong value on get", expected, actual);
    }

    @Test
    public void testInsertRequest() {
        //given
        UserDAO userDAO = new UserDAO();
        String expectedString = "password4";
        int expectedIntNotExisting = 1;
        int expected = -1;
        //when
        int actualIntNotExisting = userDAO.insertUser("login4", "password4");
        int actualIntExisting = userDAO.insertUser("login4", "password4");
        String actual = userDAO.getUser(4).getPassword();
        //then
        Assert.assertEquals("Request insert failed", expectedIntNotExisting, actualIntNotExisting);
        Assert.assertEquals("Request insert failed", expected, actualIntExisting);
        Assert.assertEquals("Wrong value on insert", expectedString, actual);
    }

    @Test
    public void testUpdateRequest() {
        //given
        UserDAO userDAO = new UserDAO();
        String expectedString = "password21";
        int expectedIntExisting = 1;
        int expectedIntNotExisting = 0;
        //when
        int actualIntExisting = userDAO.updateUser("login1", "password21");
        int actualIntNotExisting = userDAO.updateUser("login5", "password21");
        String actualString = userDAO.getUser(1).getPassword();
        //then
        Assert.assertEquals("Request update failed", expectedIntExisting, actualIntExisting);
        Assert.assertEquals("Request update failed", expectedIntNotExisting, actualIntNotExisting);
        Assert.assertEquals("Wrong value on update", expectedString, actualString);
    }

    @Test
    public void testDeleteRequest() {
        //given
        UserDAO userDAO = new UserDAO();
        String expectedString = null;
        int expectedIntExisting = 1;
        int expectedIntNotExisting = 0;
        userDAO.insertUser("login4", "password4");
        //when
        int actualIntExisting = userDAO.deleteUser("login4");
        int actualIntNotExisting = userDAO.deleteUser("login4");
        String actualString = userDAO.getUser(4).getPassword();
        //then
        Assert.assertEquals("Request delete failed", expectedIntExisting, actualIntExisting);
        Assert.assertEquals("Request delete failed", expectedIntNotExisting, actualIntNotExisting);
        Assert.assertEquals("Wrong value on delete", expectedString, actualString);
    }
}