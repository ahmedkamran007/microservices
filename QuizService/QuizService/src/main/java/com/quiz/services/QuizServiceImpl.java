package com.quiz.services;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements  QuizService{

    @Autowired
   private QuizRepository quizRepository;
    @Autowired
   private QuestionClient questionClient;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return  quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {

         List<Quiz>  quizes=  quizRepository.findAll();

         List<Quiz> newQuizList = quizes.stream().map(quiz -> {
                 quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                 return quiz;
             }).collect(Collectors.toList());
              return newQuizList;


    }


    @Override
    public Quiz get(Long id) {
        Quiz quiz=  quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
       quiz.setQuestions( questionClient.getQuestionOfQuiz(quiz.getId()));
      return quiz;
    }



//    @Override
//    public List<Quiz> get() {
//        return  quizRepository.findAll();
//    }
//
//    @Override
//    public Quiz get(Long id) {
//        return  quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
//    }
}
