package by.bsu.kbrs.tools;

import by.bsu.kbrs.json.Answer;
import by.bsu.kbrs.json.FullQuestion;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 11/14/16.
 */
public class FullQuestionSetExtractor implements ResultSetExtractor<List<FullQuestion>> {
    public List<FullQuestion> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Integer, FullQuestion> map = new HashMap<Integer, FullQuestion>();
        FullQuestion fullQuestion = null;
        while (resultSet.next()) {
            Integer questionId = resultSet.getInt("questions.question_id");
            fullQuestion = map.get(questionId);
            if(fullQuestion == null){
                String questionText = resultSet.getString("question_text");
                fullQuestion = new FullQuestion(questionId,
                        resultSet.getString("users.user_name"),
                        questionText.substring(0, Math.min(50, questionText.length())),
                        resultSet.getDate("question_publish_date"),
                        new ArrayList<Answer>());
                map.put(questionId, fullQuestion);
            }
            int answerId = resultSet.getInt("answers.answer_id");
            if(answerId > 0) {
                Answer answer = new Answer(answerId,
                        resultSet.getInt("answers.question_id"),
                        resultSet.getString("u.user_name"),
                        resultSet.getString("answers.answer_text"),
                        resultSet.getDate("answers.answer_publish_date")
                );
                fullQuestion.getAnswerList().add(answer);
            }
        }
        return new ArrayList<FullQuestion>(map.values());
    }
}
