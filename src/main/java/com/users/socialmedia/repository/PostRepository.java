package com.users.socialmedia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.users.socialmedia.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
