package com.nd705.kameleoon_test_task.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    @ManyToMany (cascade=CascadeType.ALL)
//    @JoinColumn(name = "votes")
//    @JoinTable(
//            name= "vote_voter",
//            joinColumns = @JoinColumn(name = "votes"),
//            inverseJoinColumns = @JoinColumn(name = "voters")
//    )
    private Set<User> voters = new TreeSet<>();

    public Quote() {
    }

    public Quote(String content, Date dateOfUpdate, int quoteRating, User author) {
        this.content = content;
        this.dateOfUpdate = dateOfUpdate;
        this.quoteRating = quoteRating;
        this.author = author;
    }

    public Quote(Long id, String content, Date dateOfUpdate, int quoteRating, User author, Set<User> voters) {
        this.id = id;
        this.content = content;
        this.dateOfUpdate = dateOfUpdate;
        this.quoteRating = quoteRating;
        this.author = author;
        this.voters = voters;
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

    public Long getId() {
        return id;
    }

    public Set<User> getVoters() {
        return voters;
    }

    public void setVoters(Set<User> voters) {
        this.voters = voters;
    }

    public void vote(User user, boolean voteUp){
        for (User voter:voters){
            if (voter.getId().equals(user.getId())){
                return;
            }
        }
        voters.add(user);
        quoteRating += voteUp? 1:-1;

    }
    public static Quote newQuote (Quote quote) {
        return new Quote(quote.getId(), quote.getContent(), quote.getDateOfUpdate(), quote.getQuoteRating(), quote.getAuthor(), quote.getVoters());
    }


    @Override
    public String toString() {
        return "{\n" +
                "   \"id\" : " + "\"" + id + "\"" + ",\n" +
                "   \"content\" : " + "\"" + content + "\"" + ",\n" +
                "   \"dateOfUpdate\" : " + "\"" + dateOfUpdate + "\"" + ",\n" +
                "   \"quoteRating\" : " + quoteRating + ",\n" +
                "   \"author\" : " + author.getName() + "\n" +
                '}';
    }
}
