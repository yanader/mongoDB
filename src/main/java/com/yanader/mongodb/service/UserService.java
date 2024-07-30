package com.yanader.mongodb.service;

import com.yanader.mongodb.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User addUser(User user);
    User deleteUser(String id);
    User updateUser(String id, User user);
}
