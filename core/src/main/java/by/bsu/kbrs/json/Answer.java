package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 12/3/16.
 */
public class Answer {
    private int questionId;
    private int answerId;
    private String authorName;
    private String answerText;
    private Date publishDate;

    public Answer(){

    }

    public Answer(int answerId, int questionId, String authorName, String answerText, Date publishDate){
        this(questionId, authorName, answerText);
        this.setAnswerId(answerId);
        this.setPublishDate(publishDate);
    }
    public Answer(int questionId, String authorName, String answerText){
        this.questionId = questionId;
        this.authorName = authorName;
        this.answerText = answerText;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
