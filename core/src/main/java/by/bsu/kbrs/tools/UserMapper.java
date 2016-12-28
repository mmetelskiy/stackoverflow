package by.bsu.kbrs.tools;

import by.bsu.kbrs.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 12/27/16.
 */
public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getString("user_name"), resultSet.getString("role_display_name"), resultSet.getString("user_password_hash"), resultSet.getString("user_salt"));
    }
}
