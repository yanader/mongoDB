package com.yanader.mongodb.service;

import com.yanader.mongodb.model.User;
import com.yanader.mongodb.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository mockRepository;

    @InjectMocks
    UserServiceImpl userService;

    List<User> users;

    @BeforeEach
    void setup() {
        User userOne = new User("ste", "ste@email.com");
        User userTwo = new User("Graton", "graton@email.com");
        users = List.of(userOne, userTwo);
    }

    @Test
    void getAllUsers() {
        when(mockRepository.findAll()).thenReturn(users);

        // List<User> allUsers = userService.getAllUsers();

//        assertEquals(allUsers.size(), 2);
//        assertEquals("ste@email.com", allUsers.get(0).getEmail());
//        assertEquals("graton@email.com", allUsers.get(1).getEmail());
//        verify(mockRepository, times(1)).findAll();
    }
}