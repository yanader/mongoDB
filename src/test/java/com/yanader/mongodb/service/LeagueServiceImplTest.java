package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;
import com.yanader.mongodb.model.User;
import com.yanader.mongodb.repository.LeagueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeagueServiceImplTest {

    @Mock
    LeagueRepository mockRepository;

    @InjectMocks
    LeagueServiceImpl leagueService;

    League league;

    @BeforeEach
    void setup() {
        league = new League("Test League");
    }

    @Test
    void getLeagueByName() {
        when(mockRepository.findByLeagueName("Test League")).thenReturn(league);

        League returnedLeague = leagueService.getLeagueByName("Test League");

        assertEquals("Test League", returnedLeague.getLeagueName());
        assertEquals(0, returnedLeague.getLeagueMembers().size());
        verify(mockRepository, times(1)).findByLeagueName("Test League");

    }
}