package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/18/16.
 */
public class ShortQuestion{
    private int questionId;
    private int numberOfAnswers;
    private int rating;
    private int questionAuthorId;
    private String author;
    private String header;

    private Date publishDate;

    public ShortQuestion(){
        super();
    }

    public ShortQuestion(int questionId, int numberOfAnswers, int rating, int questionAuthorId, String author, String header, Date publishDate) {
        this.header = header;
        this.questionId = questionId;
        this.numberOfAnswers = numberOfAnswers;
        this.rating = rating;
        this.questionAuthorId = questionAuthorId;
        this.author = author;
        this.publishDate = publishDate;
    }

    public ShortQuestion(int numberOfAnswers, int rating, int questionAuthorId, String author, String header, Date publishDate) {
        this.header = header;
        this.numberOfAnswers = numberOfAnswers;
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

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
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
