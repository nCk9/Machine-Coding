package org.example.service;

import org.example.entity.Answer;
import org.example.entity.Question;
import org.example.repository.PostRepository;

public class AnswerService {

    PostRepository repo;
    public AnswerService(PostRepository repositoryService){
        repo = repositoryService;
    }

    public void postAnswer(String authorId, String content, String questionId){
        Answer answer = new Answer(authorId, content);
        repo.doPost(answer);
        Question question = (Question) repo.getPost(questionId);
        question.addAnswer(answer.id);
    }
}
