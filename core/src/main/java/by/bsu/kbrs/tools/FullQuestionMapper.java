package by.bsu.kbrs.tools;

import by.bsu.kbrs.json.FullQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 11/14/16.
 */
public class FullQuestionMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new FullQuestion(resultSet.getInt("question_id"),
                resultSet.getInt("num_answers"),
                resultSet.getInt("question_rating"),
                resultSet.getInt("question_author_id"),
                resultSet.getString("user_name"),
                resultSet.getString("question_text"),
                resultSet.getDate("question_publish_date"));
    }
}
