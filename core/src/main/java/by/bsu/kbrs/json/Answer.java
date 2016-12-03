package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 12/3/16.
 */
public class Answer {
    private int questionId;
    private int answerId;
    private int authorId;
    private String authorName;
    private String answerText;
    private Date publishDate;

    public Answer(int answerId, int questionId, int authorId, String authorName, String answerText, Date publishDate){
        this.answerId = answerId;
        this.questionId = questionId;
        this.authorId = authorId;
        this.authorName = authorName;
        this.answerText = answerText;
        this.publishDate = publishDate;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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
