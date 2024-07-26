package com.yanader.mongodb.model;

import lombok.Data;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "leagues")
public class League {

    @Id
    private String id;
    private String leagueName;
    private List<User> leagueMembers;
}
