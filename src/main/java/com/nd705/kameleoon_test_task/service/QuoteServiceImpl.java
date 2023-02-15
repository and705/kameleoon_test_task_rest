package com.nd705.kameleoon_test_task.service;

import com.nd705.kameleoon_test_task.dao.QuoteRepository;
import com.nd705.kameleoon_test_task.dao.UserRepository;
import com.nd705.kameleoon_test_task.entity.Quote;
import com.nd705.kameleoon_test_task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService{
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private UserRepository userRepository;
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
    public void voteQuote(int userId, int quoteId, boolean voteUp) {
        User voter = userRepository.getById(userId);
        System.out.println(voter.toString());
        Quote quote = quoteRepository.getById(quoteId);
        System.out.println(quote.toString());
        voter.addVote(quote);
        quote.vote(voter, voteUp);
        quoteRepository.save(quote);
    }



    @Override
    public List<Quote> getTop(int n) {
        return quoteRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Quote::getQuoteRating).reversed())
                .limit(n)
                .map(Quote::newQuote)
                .toList();
    }

    @Override
    public List<Quote> getWorse(int n) {
        return quoteRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Quote::getQuoteRating))
                .limit(n)
                .map(Quote::newQuote)
                .toList();
    }
}
