package com.yanader.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    @Id
    private String _id;
    private String username;
    private String email;
    private Map<String, Boolean> leagueMemberships;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        leagueMemberships = new HashMap<>();
    }

}
