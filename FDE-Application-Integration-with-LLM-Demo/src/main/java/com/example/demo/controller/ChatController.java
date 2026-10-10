package com.example.demo.controller;

import com.example.demo.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {

        return chatService.chat(message);
    }
}
