package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;
import com.yanader.mongodb.repository.LeagueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeagueServiceImplTest {

    @Mock
    LeagueRepository mockRepository;

    @InjectMocks
    LeagueServiceImpl leagueService;

    League leagueOne;
    League leagueTwo;
    List<League> leagueList;

    @BeforeEach
    void setup() {
        leagueOne = new League("Test League One", null);
        leagueTwo = new League("Test League Two", null);
        leagueList = new ArrayList<>();
        leagueList.add(leagueOne);
        leagueList.add(leagueTwo);
    }

    @Test
    void getLeagueByNameReturnsLeague() {
        when(mockRepository.findByLeagueName("Test League One")).thenReturn(leagueOne);

        League returnedLeague = leagueService.getLeagueByName("Test League One");

        assertEquals("Test League One", returnedLeague.getLeagueName());
        assertEquals(0, returnedLeague.getLeagueMembers().size());
        verify(mockRepository, times(1)).findByLeagueName("Test League One");
    }

    @Test
    void getLeagueByNameDoesNotReturnLeague() {
        when(mockRepository.findByLeagueName("No League")).thenReturn(null);

        League returnedLeague = leagueService.getLeagueByName("No League");

        assertNull(returnedLeague);
        verify(mockRepository, times(1)).findByLeagueName("No League");
    }

    @Test
    void getLeaguesReturnsListOfLeagues() {
        when(mockRepository.findAll()).thenReturn(leagueList);

        List<League> list = leagueService.getLeagues();

        assertEquals(2, list.size());
        assertEquals("Test League One", list.get(0).getLeagueName());
        assertEquals("Test League Two", list.get(1).getLeagueName());
        verify(mockRepository, times(1)).findAll();
    }
}