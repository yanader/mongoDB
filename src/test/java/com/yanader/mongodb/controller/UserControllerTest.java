package com.yanader.mongodb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yanader.mongodb.model.User;
import com.yanader.mongodb.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserServiceImpl mockService;

    @InjectMocks
    UserController userController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    List<User> users;

    @BeforeEach
    void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(userController).build();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        User userOne = new User("ste", "ste@email.com");
        User userTwo = new User("Graton", "graton@email.com");
        users = List.of(userOne, userTwo);
    }

    @Test
    void getAllUsers() throws Exception {
        when(mockService.getUsers()).thenReturn(users);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/photoleague/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("ste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("Graton"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("ste@email.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("graton@email.com"));

        verify(mockService, times(1)).getUsers();
    }
}