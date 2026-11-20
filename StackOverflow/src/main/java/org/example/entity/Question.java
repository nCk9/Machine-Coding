package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question extends Post{
    private String title;
    private String[] tags;
    private List<String> answerIds;


    public Question(String authorId, String content, String title, String[] tags){
        super(authorId, content);
        this.title = title;
        this.tags = tags;
        answerIds = new ArrayList<>();
    }

    public void addAnswer(String answerId){
        answerIds.add(answerId);
    }
}
