package org.example.entity;

//enum acts a private final class -> remember similar thing we used to do while creating a singleton class!!!
public enum VoteType {
     UPVOTE(1),
     DOWNVOTE(-1);

     private final int value;

     VoteType(int value) {
          this.value = value;
     }

     public int getValue() {
          return value;
     }
}
