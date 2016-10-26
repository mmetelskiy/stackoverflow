package by.bsu.kbrs.controller;

import by.bsu.kbrs.dao.question.JdbcShortQuestionDao;
import by.bsu.kbrs.json.ShortQuestion;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wladek on 10/25/16.
 */
@Controller(value = "/list")
public class ListController {

    @Autowired
    private JdbcShortQuestionDao jdbcShortQuestionDao;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getListQuestions(HttpServletResponse response){
        List<ShortQuestion> shortQuestionList = jdbcShortQuestionDao.getList();
        System.out.println(shortQuestionList.toString());
        Gson gson = new Gson();
        String json = gson.toJson(shortQuestionList);
        System.out.println(json);
        return json;
    }
}
