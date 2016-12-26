package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.answer.AnswerDao;
import by.bsu.kbrs.dao.answer.impl.JdbcAnswerDao;
import by.bsu.kbrs.json.Answer;
import by.bsu.kbrs.json.FullQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by wladek on 12/25/16.
 */
@RestController
public class AnswerController {
    @Autowired
    private JdbcAnswerDao jdbcAnswerDao;

    @RequestMapping(value = "/answer/add", method = RequestMethod.POST)
    public void addNewAnswer(@RequestParam int questionId, @RequestParam String answerText, HttpServletResponse response){
        Answer answer = new Answer(questionId, "Vlad", answerText);
        jdbcAnswerDao.insert(answer);
        response.setStatus(201);
    }

    @RequestMapping(value = "/answer/remove/{answerId}", method = RequestMethod.DELETE)
    public void addNewAnswer(@PathVariable int answerId, HttpServletResponse response){
        Answer answer = new Answer();
        answer.setAnswerId(answerId);
        jdbcAnswerDao.remove(answer);
        response.setStatus(200);
    }

}
