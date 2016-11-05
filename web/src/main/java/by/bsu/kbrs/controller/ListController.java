package by.bsu.kbrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wladek on 11/4/16.
 */
@Controller
public class ListController {
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String getList(){
        return "questionsPage";
    }

}
