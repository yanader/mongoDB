package com.yanader.mongodb.service;

import com.yanader.mongodb.model.User;
import com.yanader.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        if(!validUser(user)) return null;
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public User updateUser(String id, User updates) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        }
        User userToUpdate = optionalUser.get();
        applyUserUpdates(userToUpdate, updates);
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    private boolean validUser(User user) {
        return user.getUsername() != null && user.getEmail() != null;
    }

    private void applyUserUpdates(User userToUpdate, User updates) {
        if (updates.getUsername() != null) userToUpdate.setUsername(updates.getUsername());
        if (updates.getEmail() != null) userToUpdate.setEmail(updates.getEmail());
    }


}
