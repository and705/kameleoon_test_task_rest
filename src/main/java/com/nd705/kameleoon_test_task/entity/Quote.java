package com.nd705.kameleoon_test_task.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "dateOfUpdate")
    private Date dateOfUpdate;
    @Column(name = "quoteRating")
    private int quoteRating;
    @OneToOne
    @JoinColumn(name = "author")
    private User author;

    public Quote() {
    }

    public Quote(String content, Date dateOfUpdate, int quoteRating, User author) {
        this.content = content;
        this.dateOfUpdate = dateOfUpdate;
        this.quoteRating = quoteRating;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public int getQuoteRating() {
        return quoteRating;
    }

    public void setQuoteRating(int quoteRating) {
        this.quoteRating = quoteRating;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}