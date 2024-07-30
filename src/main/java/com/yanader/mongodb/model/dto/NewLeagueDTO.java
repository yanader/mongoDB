package com.yanader.mongodb.model.dto;

import com.yanader.mongodb.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewLeagueDTO {

    private String leagueName;
    private String ownerId;
}
