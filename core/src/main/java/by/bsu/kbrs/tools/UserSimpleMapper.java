package by.bsu.kbrs.tools;

import by.bsu.kbrs.json.UserSimple;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 12/27/16.
 */
public class UserSimpleMapper implements RowMapper<UserSimple> {
    public UserSimple mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserSimple(resultSet.getString("user_name"), resultSet.getString("role_display_name"));
    }
}