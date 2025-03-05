package com.example.api.service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Quote;
import com.example.api.repository.QuoteRepository;

@Service
public class QuoteService {

    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    @Autowired
    private QuoteRepository quoteRepository;

    public String getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            logger.info("No quotes available");
            return "No quotes available";
        }
        Random random = new Random();
        Quote randomQuote = quotes.get(random.nextInt(quotes.size()));
        
        String formattedQuote = "\"" + randomQuote.getText() + "\" - " + randomQuote.getAuthor();
        logger.info("Random Quote: {}", formattedQuote);
        
        return formattedQuote;
    }


}