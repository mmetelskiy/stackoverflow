package by.bsu.kbrs.tools;

import by.bsu.kbrs.json.ShortQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wladek on 10/25/16.
 */
public class ShortQuestionMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        String questionText = resultSet.getString("question_text");
        return new ShortQuestion(resultSet.getInt("question_id"),
                                 resultSet.getInt("number_answers"),
                                 resultSet.getInt("question_rating"),
                                 resultSet.getString("user_name"),
                                 questionText.substring(0, Math.min(50, questionText.length())),
                                 resultSet.getDate("question_publish_date"));
    }
}
