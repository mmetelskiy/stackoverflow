package by.bsu.kbrs.dao.fullQuestion.impl;

import by.bsu.kbrs.dao.fullQuestion.FullQuestionDao;
import by.bsu.kbrs.json.FullQuestion;
import by.bsu.kbrs.tools.FullQuestionSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcFullQuestionDao implements FullQuestionDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SELECT_FULLQUESTION_BY_ID = "SELECT \n" +
            "    questions.*,\n" +
            "    answers.*,\n" +
            "    users.user_name,\n" +
            "    u.user_name\n" +
            "FROM\n" +
            "    questions\n" +
            "        INNER JOIN\n" +
            "    users ON questions.question_author_id = users.user_id\n" +
            "        INNER JOIN\n" +
            "    answers ON questions.question_id = answers.question_id\n" +
            "        INNER JOIN\n" +
            "    users u ON answers.author_id = u.user_id\n" +
            "WHERE\n" +
            "    questions.question_id =:question_id";
    private static String SQL_DELETE_QUESTION_BY_ID = "DELETE FROM questions WHERE question_id = :question_id";
    private static String SQL_INSERT_QUESTION = "INSERT INTO questions (question_text, num_answers, question_rating, question_author_id, question_publish_date) " +
                                                "VALUES (:question_text, :num_answers, :question_rating, (SELECT user_id from users WHERE user_name=:question_author_name LIMIT 1), :question_publish_date)";
    private static String SQL_UPDATE_RATING_UP;
    private static String SQL_UPDATE_RATING_DOWN;


    public void insert(FullQuestion fullQuestion) {
        Map<String, Object> params = new HashMap<String, Object>();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        fullQuestion.setPublishDate(new Date(new java.util.Date().getTime()));
        params.put("question_text", fullQuestion.getQuestionText());
        params.put("num_answers", 0);
        params.put("question_rating", 0);
        params.put("question_author_name", fullQuestion.getAuthor());
        params.put("question_publish_date", fullQuestion.getPublishDate());
        namedParameterJdbcTemplate.update(SQL_INSERT_QUESTION, new MapSqlParameterSource(params), holder);
        fullQuestion.setQuestionId(holder.getKey().intValue());
    }

    public FullQuestion getById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("question_id", id);
        return (FullQuestion) ((List)namedParameterJdbcTemplate.query(SQL_SELECT_FULLQUESTION_BY_ID, params, new FullQuestionSetExtractor())).get(0);
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

    public void updateRatingUp(int questionId){

    }

    public void updateRatingDown(int questionId){

    }
}
