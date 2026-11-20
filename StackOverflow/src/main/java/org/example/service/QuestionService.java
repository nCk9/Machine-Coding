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

}
