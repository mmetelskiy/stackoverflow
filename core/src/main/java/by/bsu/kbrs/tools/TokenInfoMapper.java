package by.bsu.kbrs.tools;

import by.bsu.kbrs.entity.TokenInfo;
import by.bsu.kbrs.json.UserSimple;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 12/28/16.
 */
public class TokenInfoMapper implements RowMapper<TokenInfo> {
    public TokenInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        return new TokenInfo(resultSet.getString("token"), resultSet.getString("role_display_name"));
    }
}