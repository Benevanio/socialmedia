package com.users.socialmedia.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.users.socialmedia.domain.Post;
import com.users.socialmedia.domain.User;
import com.users.socialmedia.dto.AuthorDTO;
import com.users.socialmedia.dto.CommentDTO;
import com.users.socialmedia.repository.PostRepository;
import com.users.socialmedia.repository.UserRepository;

@Component
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "John", "john@gmail.com");
        User user2 = new User(null, "Bob", "bob@gmail.com");
        User user3 = new User(null, "Alex", "alex@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
                new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.format(new Date()), new AuthorDTO(user2));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.format(new Date()), new AuthorDTO(user3));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.format(new Date()), new AuthorDTO(user2));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);

    }
}
