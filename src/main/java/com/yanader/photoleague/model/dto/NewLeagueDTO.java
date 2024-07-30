package com.yanader.photoleague.model.dto;

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
