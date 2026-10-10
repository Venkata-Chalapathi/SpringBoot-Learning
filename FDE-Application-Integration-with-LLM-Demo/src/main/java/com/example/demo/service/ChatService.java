package com.example.demo.service;

import com.example.demo.aitools.CalculatorTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private ChatClient chatClient;

    private CalculatorTool calculatorTool;

    private List<Message> history = new ArrayList();

    private final String SYSTEM_PROMPT = """
            You are a helpful AI assistant that performs arithmetic
            calculations using the available calculate tool.
        
            Supported operations:
            - add: Addition
            - subtract: Subtraction
            - multiply: Multiplication
            - divide: Division
            - mod: Modulus
            - power: Exponentiation
        
            Instructions:
            1. Understand the user's mathematical query.
            2. Use the calculate tool whenever a calculation is required.
            3. Identify the correct operation and pass the appropriate
               values to the tool.
            4. Present the result clearly and accurately.
            5. If the user attempts division by zero or an invalid
               operation, explain the issue politely.
            6. Respond in simple, understandable language.
        """;

    public ChatService(ChatClient.Builder builder, CalculatorTool calculatorTool ){
        this.chatClient = builder.build();
        this.calculatorTool = calculatorTool;
    }

    public String chat(String message){

        // USER Role
        history.add(new UserMessage(message));

        // SYSTEM + Conversation History
        String output = chatClient.prompt()
                .system(SYSTEM_PROMPT)
                .messages(history)
                .tools(calculatorTool)
                .call()
                .content();

        // ASSISTANT Role
        history.add(new AssistantMessage(output));

        return output;
    }
}
