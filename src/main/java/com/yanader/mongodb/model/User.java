package com.yanader.mongodb.model;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "users")
public class User {

    @Id
    private ObjectId id;
    private String username;
    private String email;
    private List<ObjectId> leagueMemberships;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        leagueMemberships = new ArrayList<>();
    }


}
