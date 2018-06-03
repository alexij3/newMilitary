package com.vyshyvan.services.army;

import com.vyshyvan.model.Army;
import com.vyshyvan.repositories.army.ArmyDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ArmyServiceTest {
    @Mock
    private ArmyDAO repository;

    @InjectMocks
    private ArmyServiceImpl service;

    private List<Army> armyList;

    private Army army;

    @Before
    public void setUp() throws Exception {
        armyList = Arrays.asList(
                new Army("A1", "Army 1"),
                new Army("A2", "Army 2"),
                new Army("A3", "Army 3")
        );

        army = new Army("A4", "Army 4");
        long armyId = 1;
        army.setId(armyId);

        Mockito.when(repository.findAll()).thenReturn(armyList);
        Mockito.when(repository.save(army)).thenReturn(army);

    }

    @Test
    public void insertArmy() throws Exception {
        Army actualArmy = service.insertArmy(army);

        assertEquals(army, actualArmy);
    }

    @Test
    public void getArmy() throws Exception {
        long id = 1;

        Army expectedArmy = new Army("A", "army");
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedArmy));

        Army actualArmy = service.getArmy(id);

        assertEquals(expectedArmy, actualArmy);
    }

    @Test
    public void updateArmy() throws Exception {
        Army actualArmy = service.insertArmy(army);

        assertEquals(army, actualArmy);
    }

    @Test
    public void getAll() throws Exception {
        List<Army> actualArmies = service.getAll();

        assertEquals(armyList, actualArmies);
    }

}