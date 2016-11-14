package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/18/16.
 */
public class FullQuestion extends ShortQuestion {

    private String questionText;

    public FullQuestion(int questionId, int numberOfAnswers, int rating, String author, String questionText, Date publishDate) {
        super(questionId, numberOfAnswers, rating, author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
