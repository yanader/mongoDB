package com.yanader.mongodb.model;

import java.util.ArrayList;
import java.util.List;

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
    private Integer _id;
    private String leagueName;
    private List<Integer> leagueMembers;

    public League(String leagueName) {
        this.leagueName = leagueName;
        leagueMembers = new ArrayList<>();
    }
}
