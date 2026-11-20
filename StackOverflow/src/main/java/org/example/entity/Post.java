package org.example.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Post {
    public String id;
    public String authorId;
    public String content;
    public Map<String, VoteType> userVoteMap;
    public Timestamp createdTimeStamp;
    public AtomicInteger voteCount;

    protected Post(String authorId, String content){
        this.id = UUID.randomUUID().toString();
        this.createdTimeStamp = new Timestamp(System.currentTimeMillis());
        userVoteMap = new HashMap<>();
        voteCount = new AtomicInteger(0);
    }

    public void castVote(String userId, VoteType newVote) {
        if (this.authorId.equals(userId)) {
            throw new IllegalArgumentException("Author cannot cast vote");
        }

        userVoteMap.compute(userId, (key, oldVote) -> {
            if (oldVote == newVote) { //comparing enums using == is fine.
                return oldVote; // Idempotent: no change
            }
            updateVoteCount(oldVote, newVote);
            return newVote;
        });
    }

    private void updateVoteCount(VoteType oldVote, VoteType newVote) {
        int oldValue = (oldVote == null) ? 0 : oldVote.getValue();
        int newValue = newVote.getValue();
        int delta = newValue - oldValue; // Handles +1, -1, +2, and -2 automatically
        voteCount.addAndGet(delta);
    }
}
