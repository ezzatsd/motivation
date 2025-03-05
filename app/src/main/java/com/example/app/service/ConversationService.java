package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.app.model.Conversation;
import com.example.app.repository.ConversationRepository;

import java.util.logging.Logger;
import java.util.List;
import java.util.Date;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    private static final Logger logger = Logger.getLogger(ConversationService.class.getName());


    @Autowired
    private RestTemplate restTemplate;

    public String sendMessage(String username, String message) {
        logger.info("Ceci est un message d'information. 2");
        Conversation conversation = new Conversation();
        conversation.setUsername(username);
        conversation.setMessage(message);
        conversation.setDate(new Date());
        String quote = restTemplate.getForObject("http://localhost:8080/api/getQuote", String.class);
        conversation.setCitation(quote);
        conversationRepository.save(conversation);
        return quote;
    }

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

}