package lecture12.connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends AbstractDAO {

    private String getQuery = "SELECT * FROM Users WHERE idUsers=";
    private String insertQuery = "INSERT INTO Users(login, password) VALUES ";
    private String updateQuery = "UPDATE Users SET `password` = '";
    private String deleteQuery = "DELETE FROM Users WHERE `login`='";

    /**
     * get User's login and password by id
     * @param userId User's id for request
     * @return User's data - login and password
     */
    @Override
    public Users getUser(int userId) {
        Users user = new Users();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(getQuery + userId);
            while(rs.next()) {
                user.setId(1);
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
//                user.setDateOfRegistration(rs.getDate(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Insert request with the following parameters:
     * @param login User's login (unique)
     * @param password User's password
     * @return 1 on success, -1 of SQLException (such as trying to add an existing field)
     */
    @Override
    public int insertUser(String login, String password) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(insertQuery + "('" + login + "','" + password + "');");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Updates some User's password by the given login
     * @param login
     * @param newPassword
     * @return 0 if User doesn't exist, 1 on success, -1 otherwise
     */
    @Override
    public int updateUser(String login, String newPassword) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(updateQuery + newPassword + "' WHERE login='" + login + "';");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Deletes given user field
     * @param login user's login to delete
     * @return 0 if User doesn't exist, 1 on success, -1 otherwise
     */
    @Override
    public int deleteUser(String login) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(deleteQuery + login + "';");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}