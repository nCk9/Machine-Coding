package org.example.repository;

import org.example.entity.Post;

public interface PostRepository {
    public void doPost(Post post);
    public Post getPost(String postId);
}
