package com.users.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.socialmedia.domain.User;
import com.users.socialmedia.dto.UserDTO;
import com.users.socialmedia.repository.UserRepository;
import com.users.socialmedia.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
