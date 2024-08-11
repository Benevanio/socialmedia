package com.users.socialmedia.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.users.socialmedia.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitleContaining(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

}
