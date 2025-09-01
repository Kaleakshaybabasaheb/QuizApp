package com.quiz.quiz.controller;

import com.quiz.quiz.QuestionService.QuestionService;
import com.quiz.quiz.dto.LoginRequest;
import com.quiz.quiz.entity.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    QuestionService questionService;

    private final String USERNAME = "user";
    private final String PASSWORD = "password";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        if(USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword())){
            return "Login Successful";
        }
        else{
            return "Invalid username or password";
        }
    }

    @GetMapping("/questions")
    public List<QuizQuestion> getQuestions (){
        return questionService.getAllQuestions();
    }

    @PostMapping("/save")
    public QuizQuestion saveQuestion (@RequestBody QuizQuestion question){
        return questionService.saveQuestion(question);
    }

}
