package com.question.services;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp  implements QuestionService{
    @Autowired
    private QuestionRepository questionRepo;

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return  questionRepo.findByQuizId(quizId);
    }
}
