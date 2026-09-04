package com.example.profilesDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/demo")
public class DemoController {

    @Value("${app.welcome.message}")
    private String message;

    @Value("${app.welcome.users}")
    private List<String> users;

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        System.out.println(users);
        return ResponseEntity.ok(message);
    }
}
