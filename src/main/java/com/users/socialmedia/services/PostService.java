package com.users.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.socialmedia.domain.Post;
import com.users.socialmedia.repository.PostRepository;
import com.users.socialmedia.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return post;
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContaining(text);
    }
}
