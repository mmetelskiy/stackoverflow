package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.answer.AnswerDao;
import by.bsu.kbrs.dao.answer.impl.JdbcAnswerDao;
import by.bsu.kbrs.json.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wladek on 12/25/16.
 */
@RestController
public class AnswerController {
    @Autowired
    private JdbcAnswerDao jdbcAnswerDao;

    @RequestMapping(value = "/answer/add", method = RequestMethod.POST)
    public @ResponseBody
    String addNewAnswer(@RequestParam int question_id, @RequestParam int author_id, @RequestParam String answer_text){
        //jdbcAnswerDao.insert(new Answer());
        return  null;
    }


}
