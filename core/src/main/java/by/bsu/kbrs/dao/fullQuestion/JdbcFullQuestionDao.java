package by.bsu.kbrs.dao.fullQuestion;

import by.bsu.kbrs.json.FullQuestion;
import by.bsu.kbrs.tools.FullQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcFullQuestionDao implements FullQuestionDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SELECT_FULLQUESTION_BY_ID = "SELECT * FROM questions INNER JOIN users ON question_author_id = user_id WHERE question_id=:question_id";
    private static String SQL_DELETE_QUESTION_BY_ID = "DELETE FROM questions WHERE question_id = :question_id";
    private static String SQL_INSERT_QUESTION = "INSERT INTO questions (question_text, num_answers, question_rating, question_author_id, question_publish_date) " +
                                                "VALUES (:question_text, :num_answers, :question_rating, :question_author_id, :question_publish_date)";


    public void insert(FullQuestion fullQuestion) {
        Map<String, Object> params = new HashMap<String, Object>();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        params.put("question_text", fullQuestion.getQuestionText());
        params.put("num_answers", fullQuestion.getNumberOfAnswers());
        params.put("question_rating", fullQuestion.getRating());
        params.put("question_author_id", fullQuestion.getQuestionAuthorId());
        params.put("question_publish_date", fullQuestion.getPublishDate());
        namedParameterJdbcTemplate.update(SQL_INSERT_QUESTION, new MapSqlParameterSource(params), holder);
        fullQuestion.setQuestionId(holder.getKey().intValue());
    }

    public FullQuestion getById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("question_id", id);
        return (FullQuestion) ((List)namedParameterJdbcTemplate.query(SQL_SELECT_FULLQUESTION_BY_ID, params, new FullQuestionMapper())).get(0);
    }

    public void remove(FullQuestion fullQuestion) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("question_id", fullQuestion.getQuestionId());
        namedParameterJdbcTemplate.update(SQL_DELETE_QUESTION_BY_ID, params);
        System.out.println("Success");
    }

    public List<FullQuestion> getList() {
        return null;
    }

    public void update(FullQuestion fullQuestion) {

    }
}
