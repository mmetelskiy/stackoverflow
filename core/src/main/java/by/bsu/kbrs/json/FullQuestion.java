package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/18/16.
 */
public class FullQuestion extends ShortQuestion {

    private String questionText;

    public FullQuestion(int questionId, int numberOfAnswers, int rating, int questionAuthorId, String author, String questionText, Date publishDate) {
        super(questionId, numberOfAnswers, rating, questionAuthorId, author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
    }

    public FullQuestion(int numberOfAnswers, int rating, int questionAuthorId, String author, String questionText, Date publishDate) {
        super(numberOfAnswers, rating, questionAuthorId, author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
    }

    public FullQuestion(){
        super();
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
