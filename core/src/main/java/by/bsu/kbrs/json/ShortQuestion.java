package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/18/16.
 */
public class ShortQuestion extends Question{
    private int numberOfAnswers;
    public ShortQuestion(){
        super();
    }

    public ShortQuestion(int questionId, int numberOfAnswers, int rating, String author, String header, Date publishDate) {
        super(questionId, rating, author,header,publishDate);
        this.numberOfAnswers = numberOfAnswers;
    }

    public ShortQuestion(int numberOfAnswers, int rating, String author, String header, Date publishDate) {
        super(rating, author, header, publishDate);
        this.numberOfAnswers = numberOfAnswers;

    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }
}
