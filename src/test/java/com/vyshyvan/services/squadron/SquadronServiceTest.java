package com.vyshyvan.services.squadron;

import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.Platoon;
import com.vyshyvan.model.Squadron;
import com.vyshyvan.repositories.squadron.SquadronDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SquadronServiceTest {
    @Mock
    private SquadronDAO repository;

    @InjectMocks
    private SquadronServiceImpl service;

    private List<Squadron> squadronList;

    private Squadron squadron;

    @Before
    public void setUp() throws Exception {
        squadronList = Arrays.asList(
                new Squadron("SQ1", "Squadron 1", new HashSet<Platoon>(), new MilitaryBase()),
                new Squadron("SQ2", "Squadron 2", new HashSet<Platoon>(), new MilitaryBase()),
                new Squadron("SQ3", "Squadron 3", new HashSet<Platoon>(), new MilitaryBase()),
                new Squadron("SQ4", "Squadron 4", new HashSet<Platoon>(), new MilitaryBase()),
                new Squadron("SQ5", "Squadron 5", new HashSet<Platoon>(), new MilitaryBase())
        );

        squadron = new Squadron("SQ6", "Squadron 6", new HashSet<Platoon>(), new MilitaryBase());
        int squadronId = 1;
        squadron.setId(squadronId);

        Mockito.when(repository.findAll()).thenReturn(squadronList);
        Mockito.when(repository.save(squadron)).thenReturn(squadron);

    }

    @Test
    public void insertSquadron() throws Exception {
        Squadron actualSquadron = service.insertSquadron(squadron);

        assertEquals(squadron, actualSquadron);
    }

    @Test
    public void getSquadron() throws Exception {
        int id = 1;

        Squadron expectedSquadron = new Squadron("SQ6", "Squadron 6", new HashSet<Platoon>(), new MilitaryBase());
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedSquadron));

        Squadron actualSquadron = service.getSquadron(id);

        assertEquals(expectedSquadron, actualSquadron);
    }

    @Test
    public void updateSquadron() throws Exception {
        Squadron actualSquadron = service.insertSquadron(squadron);

        assertEquals(squadron, actualSquadron);
    }

    @Test
    public void getAll() throws Exception {
        List<Squadron> actualSquadrons = service.getAll();

        assertEquals(squadronList, actualSquadrons);
    }

}