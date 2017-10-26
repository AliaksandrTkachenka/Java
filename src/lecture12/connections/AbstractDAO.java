package lecture12.connections;

import java.sql.Connection;

public abstract class AbstractDAO {
    Connection connection = JDBCFactory.getConnection();

    public abstract Users getUser(int userId);

    public abstract int insertUser(String login, String password);

    public abstract int updateUser(String login, String newPassword);

    public abstract int deleteUser(String login);
}