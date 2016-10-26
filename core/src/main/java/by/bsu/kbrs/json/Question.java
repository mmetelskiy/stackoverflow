package by.bsu.kbrs.json;

import java.sql.Date;

/**
 * Created by wladek on 10/25/16.
 */
public class Question {
    private int questionId;
    private int numberOfAnswers;
    private int rating;
    private String author;

    private Date publishDate;

    public Question(int questionId, int numberOfAnswers, int rating, String author, Date publishDate){
        this.questionId = questionId;
        this.numberOfAnswers = numberOfAnswers;
        this.rating = rating;
        this.author = author;
        this.publishDate = publishDate;
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
}
