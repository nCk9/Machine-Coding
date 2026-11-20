package org.example.service;

import org.example.entity.Post;
import org.example.entity.VoteType;
import org.example.repository.PostRepository;

public class VoteService {

    private final PostRepository repo;
    public VoteService(PostRepository repositoryService){
        repo = repositoryService;
    }

    public void castVote(String postId, String userId, VoteType voteType) throws Exception {
        Post post = repo.getPost(postId);
        post.castVote(userId, voteType);
    }
}
