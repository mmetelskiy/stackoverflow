package by.bsu.kbrs.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by wladek on 11/15/16.
 */
@RestController(value = "/rating")
public class RatingQuestionController {

    @RequestMapping(value = "/{up}", method = RequestMethod.PUT)
    public @ResponseBody String ratingUp(@RequestAttribute int questionId){
        return " ";
    }

    @RequestMapping(value = "/{down}", method = RequestMethod.PUT)
    public @ResponseBody String ratingDown(@RequestAttribute int questionId){
        return " ";
    }
}
