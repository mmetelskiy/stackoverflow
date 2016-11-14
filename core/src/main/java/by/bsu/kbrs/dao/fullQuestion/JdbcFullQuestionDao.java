package by.bsu.kbrs.dao.fullQuestion;

import by.bsu.kbrs.json.FullQuestion;
import by.bsu.kbrs.tools.FullQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcFullQuestionDao implements FullQuestionDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SELECT_FULLQUESTION_BY_ID = "SELECT * FROM questions INNER JOIN users ON question_author_id = user_id WHERE question_id=:question_id";


    public void insert(FullQuestion fullQuestion) {

    }

    public FullQuestion getById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("question_id", id);
        return (FullQuestion) ((List)namedParameterJdbcTemplate.query(SQL_SELECT_FULLQUESTION_BY_ID, params, new FullQuestionMapper())).get(0);
    }

    public void remove(FullQuestion fullQuestion) {

    }

    public List<FullQuestion> getList() {
        return null;
    }

    public void update(FullQuestion fullQuestion) {

    }
}
