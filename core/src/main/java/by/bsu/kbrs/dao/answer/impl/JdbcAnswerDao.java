package by.bsu.kbrs.dao.answer.impl;

import by.bsu.kbrs.dao.answer.AnswerDao;
import by.bsu.kbrs.json.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wladek on 12/25/16.
 */
@Component
public class JdbcAnswerDao implements AnswerDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_INSERT_ANSWER = "INSERT INTO answers (question_id, author_id, answer_text, answer_publish_date) " +
            "VALUES (:question_id, (SELECT user_id FROM users WHERE user_name=:author_name LIMIT 1), :answer_text, :answer_publish_date)";

    private static String SQL_DELETE_ANSWER_BY_ID = "DELETE FROM answers WHERE answer_id = :answer_id";

    public void insert(Answer answer) {
        Map<String, Object> params = new HashMap<String, Object>();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        answer.setPublishDate(new Date(new java.util.Date().getTime()));
        params.put("question_id", answer.getQuestionId());
        params.put("author_name", answer.getAuthorName());
        params.put("answer_text", answer.getAnswerText());
        params.put("answer_publish_date", answer.getPublishDate());
        namedParameterJdbcTemplate.update(SQL_INSERT_ANSWER, new MapSqlParameterSource(params), holder);
        answer.setAnswerId(holder.getKey().intValue());
    }

    public Answer getById(Integer id) {
        return null;
    }

    public void remove(Answer answer) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("answer_id", answer.getAnswerId());
        namedParameterJdbcTemplate.update(SQL_DELETE_ANSWER_BY_ID, params);
    }

    public List<Answer> getList() {
        return null;
    }

    public void update(Answer answer) {

    }
}
