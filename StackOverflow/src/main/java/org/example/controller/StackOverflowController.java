package org.example.controller;

import org.example.entity.VoteType;
import org.example.repository.RepositoryFactory;
import org.example.repository.PostRepository;
import org.example.service.AnswerService;
import org.example.service.QuestionService;
import org.example.service.VoteService;

public class StackOverflowController {
    //the orchestrator
    //QuestionService, AnswerService, VoteService, CommentService  -> Facade pattern

    QuestionService questionService;
    AnswerService answerService;
    PostRepository repositoryService;
    RepositoryFactory repositoryFactory;
    VoteService voteService;

    public StackOverflowController(){
        repositoryFactory = new RepositoryFactory();
        repositoryService = repositoryFactory.createRepository("IN_MEMORY");
        questionService = new QuestionService(repositoryService);
        answerService = new AnswerService(repositoryService);
        voteService = new VoteService(repositoryService);
    }

    public void postQuestion(String authorId, String content, String title, String[] tags){
        questionService.postQuestion(authorId, content, title, tags);
    }

    public void castVote(String postId, String userId, VoteType voteType) throws Exception {
        voteService.castVote(postId, userId, voteType);
    }

    public void postAnswer(String authorId, String content, String questionId){
        answerService.postAnswer(authorId, content, questionId);
    }

    public void acceptAnswer(String questionId, String answerId, String authorId){
        questionService.acceptAnswer(questionId, answerId, authorId);
    }

}
