package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
   private QuizService quizService;


   @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);

    }

    @GetMapping
    public List<Quiz> get(){
       return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizService.get(id);
    }
}
