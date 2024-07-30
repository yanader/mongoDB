package com.yanader.photoleague.service;

import com.yanader.photoleague.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User addUser(User user);
    User deleteUser(String id);
    User updateUser(String id, User user);
}
