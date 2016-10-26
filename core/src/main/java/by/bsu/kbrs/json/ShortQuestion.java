package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/18/16.
 */
public class ShortQuestion extends Question{

    private String header;

    public ShortQuestion(int questionId, int numberOfAnswers, int rating, String author, String header, Date publishDate) {
        super(questionId, numberOfAnswers, rating, author, publishDate);
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
