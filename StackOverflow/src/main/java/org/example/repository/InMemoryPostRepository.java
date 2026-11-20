package org.example.repository;

import org.example.entity.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPostRepository implements PostRepository {

    private final Map<String, List<Post>> userPostMap;
    private final Map<String, Post> postMap;
    public InMemoryPostRepository(){
        userPostMap = new HashMap<>();
        postMap = new HashMap<>();
    }

    @Override
    public void doPost(Post post){
        if(userPostMap.get(post.authorId).isEmpty())
            userPostMap.put(post.authorId, new ArrayList<>());
        userPostMap.get(post.authorId).add(post);
        postMap.put(post.id, post);
    }

    @Override
    public Post getPost(String postId){
        return postMap.get(postId);
    }

}
