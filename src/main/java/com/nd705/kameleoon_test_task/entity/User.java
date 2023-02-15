package com.nd705.kameleoon_test_task.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "dateOfCreation")
    private Date dateOfCreation;

    @ManyToMany (cascade=CascadeType.ALL)
//   @JoinColumn(name = "voters")
//    @JoinTable(
//            name= "vote_voter",
//            joinColumns = @JoinColumn(name = "voters"),
//            inverseJoinColumns = @JoinColumn(name = "votes")
//    )
    private Set<Quote> votes = new TreeSet<>();




    public User() {
    }

    public User(String name, String email, String password, Date dateOfCreation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfCreation = dateOfCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date date) {
        this.dateOfCreation = date;
    }

    public Long getId() {
        return id;
    }

    public Set<Quote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Quote> votes) {
        this.votes = votes;
    }

    public void addVote(Quote quote){
        votes.add(quote);
    }
    @Override
    public String toString() {
        return "{\n" +
                "   \"id\" : " + "\"" + id + "\"" + ",\n" +
                "   \"name\" : " + "\"" + name + "\""  + ",\n" +
                "   \"email\" : " + "\"" + email + "\"" + ",\n" +
                "   \"password\" : " + "\"" + password + "\"" + ",\n" +
                "   \"dateOfCreation\" : " + "\"" + dateOfCreation + "\"" + ",\n" +
                '}';
    }
}
