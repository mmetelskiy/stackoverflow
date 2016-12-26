package by.bsu.kbrs.json;

import java.sql.Date;
import java.util.List;

/**
 * Created by wladek on 10/18/16.
 */
public class FullQuestion extends Question {

    private String questionText;
    private List<Answer> answerList;

    public FullQuestion(int questionId, String author, String questionText, Date publishDate, List<Answer> answerList) {
        super(questionId, author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
        this.answerList = answerList;
    }

    public FullQuestion(String author, String questionText, Date publishDate, List<Answer> answerList) {
        super( author, questionText.substring(0, Math.min(50, questionText.length())), publishDate);
        this.questionText = questionText;
        this.answerList = answerList;
    }

    public FullQuestion(String author, String questionText) {
        this.questionText = questionText;
        this.setAuthor(author);
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

    public int getNumAnswers(){
        return  answerList.size();
    }
}
