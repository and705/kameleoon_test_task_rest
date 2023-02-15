package com.nd705.kameleoon_test_task.service;

import com.nd705.kameleoon_test_task.entity.Quote;
import com.nd705.kameleoon_test_task.entity.User;

import java.util.List;

public interface QuoteService {
    public void saveQuote(Quote quote);
    public Quote getQuote(int id);
    public Quote getRandomQuote();
    public void deleteQuote(int id);
    public void voteQuote(int userId, int quoteId, boolean voteUp);
    public List<Quote> getTop(int n);
    public List<Quote> getWorse(int n);

}
