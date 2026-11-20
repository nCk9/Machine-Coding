package org.example.entity;

public class Answer extends Post{
    private boolean isAcceptedAnswer;

    public Answer(String authorId, String content){
        super(authorId, content);
        isAcceptedAnswer = false;
    }

    public void setIsAcceptedAnswer(Boolean flag){
        isAcceptedAnswer = flag;
    }
}
