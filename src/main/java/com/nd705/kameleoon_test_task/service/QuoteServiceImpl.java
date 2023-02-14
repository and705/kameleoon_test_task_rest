package com.nd705.kameleoon_test_task.service;

import com.nd705.kameleoon_test_task.dao.QuoteRepository;
import com.nd705.kameleoon_test_task.entity.Quote;
import com.nd705.kameleoon_test_task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService{
    @Autowired
    private QuoteRepository quoteRepository;
    @Override
    public void saveQuote(Quote quote) {
        quoteRepository.save(quote);
    }

    @Override
    public Quote getQuote(int id) {
        Quote quote = null;
        Optional<Quote> optQuote = quoteRepository.findById(id);
        if (optQuote.isPresent()) {
            quote = optQuote.get();
        }
        return quote;
    }

    @Override
    public Quote getRandomQuote() {
        Quote quote = quoteRepository.getRandomQuote();
        return quote;

    }

    @Override
    public void deleteQuote(int id) {
        quoteRepository.deleteById(id);

    }

    @Override
    public Quote voteQuoteUp(int userId, int quoteId) {

        return null;
    }



    @Override
    public List<Quote> getTop() {
        return null;
    }

    @Override
    public List<Quote> getWorse() {
        return null;
    }
}
