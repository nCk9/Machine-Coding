package org.example.repository;

public class RepositoryFactory {

     public PostRepository createRepository(String repositoryType){
        if(repositoryType.equals("IN_MEMORY")){
            return new InMemoryPostRepository();
        }
        throw new IllegalArgumentException("Unknown repo type");
    }
}
