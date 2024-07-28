package com.yanader.mongodb.service;

import com.yanader.mongodb.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User addUser(User user);
    public User deleteUser(int id);
    public User updateUser(int id, User user);
}
