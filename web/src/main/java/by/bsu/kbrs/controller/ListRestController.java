package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.question.JdbcShortQuestionDao;
import by.bsu.kbrs.json.ShortQuestion;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wladek on 10/25/16.
 */
@RestController
public class ListRestController {

    @Autowired
    private JdbcShortQuestionDao jdbcShortQuestionDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String getListQuestions(HttpServletResponse response) throws IOException {
        List<ShortQuestion> shortQuestionList = jdbcShortQuestionDao.getList();
        Gson gson = new Gson();
        String json = gson.toJson(shortQuestionList);
        return json;
    }


}
