package com.yanader.photoleague.model;

import java.util.HashMap;
import java.util.Map;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "leagues")
public class League {

    @Id
    private String _id;
    private String leagueName;
    private Map<String, Boolean> leagueMembers;

    public League(String leagueName, String ownerId) {
        this.leagueName = leagueName;
        leagueMembers = new HashMap<>();
        leagueMembers.put(ownerId, true);
    }

}
