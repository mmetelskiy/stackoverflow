package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.fullQuestion.JdbcFullQuestionDao;
import by.bsu.kbrs.dao.shortQuestion.JdbcShortQuestionDao;
import by.bsu.kbrs.json.FullQuestion;
import by.bsu.kbrs.json.ShortQuestion;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by wladek on 10/25/16.
 */
@RestController(value = "/list")
public class ListQuestionsController {

    @Autowired
    private JdbcShortQuestionDao jdbcShortQuestionDao;
    @Autowired
    private JdbcFullQuestionDao jdbcFullQuestionDao;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getListQuestions() throws IOException {
        List<ShortQuestion> shortQuestionList = jdbcShortQuestionDao.getList();
        Gson gson = new Gson();
        String json = gson.toJson(shortQuestionList);
        return json;
    }

    @RequestMapping(value = "/{questionId}", method = RequestMethod.GET)
    public @ResponseBody String getQuestion(Integer questionId){
        FullQuestion fullQuestion = jdbcFullQuestionDao.getById(questionId);
        Gson gson = new Gson();
        String json = gson.toJson(fullQuestion);
        return json;
    }
}
