package by.bsu.kbrs.json;

import java.sql.Date;
import java.util.List;

/**
 * Created by wladek on 10/18/16.
 */
public class FullQuestion extends Question {

    private String questionText;
    private List<Answer> answerList;

    public FullQuestion(int questionId, int rating, int questionAuthorId, String author, String questionText, Date publishDate, List<Answer> answerList) {
        super(questionId, rating, questionAuthorId, author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
        this.answerList = answerList;
    }

    public FullQuestion( int rating, int questionAuthorId, String author, String questionText, Date publishDate, List<Answer> answerList) {
        super(rating, questionAuthorId, author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
        this.answerList = answerList;
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

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
