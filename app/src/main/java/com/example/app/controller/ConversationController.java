package com.example.app.controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.service.ConversationService;
import java.util.logging.Logger;



@Controller 
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    private static final Logger logger = Logger.getLogger(ConversationController.class.getName());

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String username, @RequestParam String message, Model model) {
        logger.info("Ceci est un test.");
        String quote = conversationService.sendMessage(username, message);
        model.addAttribute("quote", quote);
        return "index";
    }

    @GetMapping("/conversations")
    public String getAllConversations(Model model) {
        model.addAttribute("conversations", conversationService.getAllConversations());
        return "conversations"; // La vue conversation.html
    }
}