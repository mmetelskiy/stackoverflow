package by.bsu.kbrs.dao.shortQuestion.impl;

import by.bsu.kbrs.dao.shortQuestion.ShortQuestionDao;
import by.bsu.kbrs.json.ShortQuestion;
import by.bsu.kbrs.tools.ShortQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wladek on 10/25/16.
 */
@Component
public class JdbcShortQuestionDao implements ShortQuestionDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SELECT_LIST_SHORTQUESTIONS = "SELECT \n" +
            "    questions.*,\n" +
            "    users.user_id,\n" +
            "    users.user_name,\n" +
            "    COUNT(answers.answer_id) AS number_answers\n" +
            "FROM\n" +
            "    questions\n" +
            "        INNER JOIN\n" +
            "    users ON question_author_id = user_id\n" +
            "        INNER JOIN\n" +
            "    answers ON questions.question_id = answers.question_id\n" +
            "GROUP BY answers.question_id;";

    public void insert(ShortQuestion shortQuestion) {

    }

    public ShortQuestion getById(Integer id) {
        return null;
    }

    public void remove(ShortQuestion shortQuestion) {

    }

    public List<ShortQuestion> getList() {
        List<ShortQuestion> orderList = (List<ShortQuestion>)namedParameterJdbcTemplate.query(SQL_SELECT_LIST_SHORTQUESTIONS, new ShortQuestionMapper());
        return orderList;
    }

    public void update(ShortQuestion shortQuestion) {

    }
}
