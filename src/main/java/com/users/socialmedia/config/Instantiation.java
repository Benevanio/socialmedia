package com.users.socialmedia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.users.socialmedia.domain.User;
import com.users.socialmedia.repository.UserRepository;

@Component
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User(null, "John", "john@gmail.com");
        User user2 = new User(null, "Bob", "bob@gmail.com");
        User user3 = new User(null, "Alex", "alex@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
