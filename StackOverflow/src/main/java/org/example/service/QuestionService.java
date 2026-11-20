package org.example.service;

import org.example.entity.Question;
import org.example.repository.PostRepository;

public class QuestionService {

    PostRepository repo;
    public QuestionService(PostRepository repositoryService){
        repo = repositoryService;
    }

    public void postQuestion(String authorId, String content, String title, String[] tags){
        Question question = new Question(authorId, content, title, tags);
        repo.doPost(question);
    }

    public void acceptAnswer(String questionId, String answerId, String authorId){
        Question question = (Question) repo.getPost(questionId); //downcasting needed -> implies we need to segregate no, abstraction has started leaking
        question.acceptAnswer(answerId, authorId);
    }
}
