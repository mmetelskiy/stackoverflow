package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 12/3/16.
 */
public class Question {
    private int questionId;

    private int rating;
    private int questionAuthorId;
    private String author;
    private String header;

    private Date publishDate;

    public Question(){
        super();
    }

    public Question(int questionId, int rating, int questionAuthorId, String author, String header, Date publishDate) {
        this(rating, questionAuthorId, author, header, publishDate);
        this.questionId = questionId;
    }

    public Question(int rating, int questionAuthorId, String author, String header, Date publishDate) {
        this.header = header;
        this.rating = rating;
        this.questionAuthorId = questionAuthorId;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getQuestionAuthorId() {
        return questionAuthorId;
    }

    public void setQuestionAuthorId(int questionAuthorId) {
        this.questionAuthorId = questionAuthorId;
    }
}
