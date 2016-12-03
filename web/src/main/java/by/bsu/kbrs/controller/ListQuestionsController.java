package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.fullQuestion.JdbcFullQuestionDao;
import by.bsu.kbrs.dao.shortQuestion.JdbcShortQuestionDao;
import by.bsu.kbrs.json.Answer;
import by.bsu.kbrs.json.FullQuestion;
import by.bsu.kbrs.json.ShortQuestion;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladek on 10/25/16.
 */
@RestController
public class ListQuestionsController {

    @Autowired
    private JdbcShortQuestionDao jdbcShortQuestionDao;
    @Autowired
    private JdbcFullQuestionDao jdbcFullQuestionDao;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String getListQuestions(HttpServletResponse response) throws IOException {
        List<ShortQuestion> shortQuestionList = jdbcShortQuestionDao.getList();
        Gson gson = new Gson();
        String json = gson.toJson(shortQuestionList);
        response.setContentType("application/json");
        return json;
    }

    @RequestMapping( value="/list", method = RequestMethod.POST)
    public @ResponseBody String createFullQuestion(@RequestParam String questionText,  HttpServletRequest request){
        FullQuestion fullQuestion = new FullQuestion(0,0,1," ", questionText, new Date(11), new ArrayList<Answer>());
        jdbcFullQuestionDao.insert(fullQuestion);
        return fullQuestion.getQuestionId() + "";
    }

    @RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public @ResponseBody String getQuestion(@PathVariable String questionId, HttpServletResponse response){
        FullQuestion fullQuestion = jdbcFullQuestionDao.getById(Integer.parseInt(questionId));
        Gson gson = new Gson();
        String json = gson.toJson(fullQuestion);
        response.setContentType("application/json");
        return json;
    }

    @RequestMapping(value = "/{questionId}", method = RequestMethod.DELETE)
    public void deleteQuestionById(@PathVariable String questionId){
        FullQuestion fullQuestion = new FullQuestion();
        fullQuestion.setQuestionId(Integer.parseInt(questionId));
        jdbcFullQuestionDao.remove(fullQuestion);
    }
}
