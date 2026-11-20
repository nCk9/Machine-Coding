package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question extends Post{
    private String title;
    private String[] tags;
    private List<String> answerIds;
    private String acceptedAnswerId;

    public Question(String authorId, String content, String title, String[] tags){
        super(authorId, content);
        this.title = title;
        this.tags = tags;
        answerIds = new ArrayList<>();
        acceptedAnswerId = "NA";
    }

    public void addAnswer(String answerId){
        answerIds.add(answerId);
    }

    public void acceptAnswer(String answerId, String authorId){
        if(this.authorId.equals(authorId) && answerIds.contains(answerId))
            acceptedAnswerId = answerId;
    }
}
