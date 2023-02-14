package com.nd705.kameleoon_test_task.dao;

import com.nd705.kameleoon_test_task.entity.Quote;
import com.nd705.kameleoon_test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    @Query(value = "SELECT * FROM quotes ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public Quote getRandomQuote();
}
