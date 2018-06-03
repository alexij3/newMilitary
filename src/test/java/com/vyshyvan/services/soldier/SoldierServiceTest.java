package com.vyshyvan.services.soldier;

import com.vyshyvan.model.Soldier;
import com.vyshyvan.repositories.soldier.SoldierDAO;
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
public class SoldierServiceTest {
    @Mock
    private SoldierDAO repository;

    @InjectMocks
    private SoldierServiceImpl service;

    private List<Soldier> soldierList;

    private Soldier soldier;

    @Before
    public void setUp() throws Exception {
        soldierList = Arrays.asList(
                new Soldier("Soldier 1", 25),
                new Soldier("Soldier 2", 27),
                new Soldier("Soldier 3", 28)
        );

        soldier = new Soldier("Soldier 4", 24);
        int soldierId = 1;
        soldier.setId(soldierId);

        Mockito.when(repository.findAll()).thenReturn(soldierList);
        Mockito.when(repository.save(soldier)).thenReturn(soldier);

    }

    @Test
    public void insertSoldier() throws Exception {
        Soldier actualSoldier = service.insertSoldier(soldier);

        assertEquals(soldier, actualSoldier);
    }

    @Test
    public void getSoldier() throws Exception {
        int id = 1;

        Soldier expectedSoldier = new Soldier("Soldier 4", 34);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedSoldier));

        Soldier actualSoldier = service.getSoldier(id);

        assertEquals(expectedSoldier, actualSoldier);
    }

    @Test
    public void updateSoldier() throws Exception {
        Soldier actualSoldier = service.insertSoldier(soldier);

        assertEquals(soldier, actualSoldier);
    }

    @Test
    public void getAll() throws Exception {
        List<Soldier> actualSoldier = service.getAll();

        assertEquals(soldierList, actualSoldier);
    }

}