package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/18/16.
 */
public class FullQuestion extends ShortQuestion {

    public FullQuestion(int questionId, int numberOfAnswers, int rating, String author, String header, Date publishDate) {
        super(questionId, numberOfAnswers, rating, author, header, publishDate);
    }
}
