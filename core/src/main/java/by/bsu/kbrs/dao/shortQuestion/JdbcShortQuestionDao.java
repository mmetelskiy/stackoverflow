package by.bsu.kbrs.dao.shortQuestion;

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

    private static String SQL_SELECT_LIST_SHORTQUESTIONS = "SELECT * FROM questions INNER JOIN users ON question_author_id = user_id";

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
