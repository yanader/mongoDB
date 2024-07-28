package com.yanader.mongodb.service;

import com.yanader.mongodb.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User addUser(User user);
    User deleteUser(int id);
    User updateUser(int id, User user);
}
