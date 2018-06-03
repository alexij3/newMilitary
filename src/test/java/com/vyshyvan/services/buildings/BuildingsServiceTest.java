package com.vyshyvan.services.buildings;

import com.vyshyvan.model.Buildings;
import com.vyshyvan.repositories.buildings.BuildingsDAO;
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
public class BuildingsServiceTest {
    @Mock
    private BuildingsDAO repository;

    @InjectMocks
    private BuildingsServiceImpl service;

    private List<Buildings> buildingsList;

    private Buildings buildings;

    @Before
    public void setUp() throws Exception {
        buildingsList = Arrays.asList(
                new Buildings("Buildings 1"),
                new Buildings("Buildings 2"),
                new Buildings("Buildings 3")
        );

        buildings = new Buildings("Buildings 4");
        int buildingsId = 1;
        buildings.setId(buildingsId);

        Mockito.when(repository.findAll()).thenReturn(buildingsList);
        Mockito.when(repository.save(buildings)).thenReturn(buildings);
    }

    @Test
    public void insertBuildings() throws Exception {
        Buildings actualBuildings = service.insertBuildings(buildings);

        assertEquals(buildings, actualBuildings);
    }

    @Test
    public void getBuildings() throws Exception {
        int id = 1;

        Buildings expectedBuildings = new Buildings("Buildings 1");
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedBuildings));

        Buildings actualBuildings = service.getBuildings(id);

        assertEquals(expectedBuildings, actualBuildings);
    }

    @Test
    public void updateBuildings() throws Exception {
        Buildings actualBuildings = service.insertBuildings(buildings);

        assertEquals(buildings, actualBuildings);
    }

    @Test
    public void getAll() throws Exception {
        List<Buildings> actualBuildings = service.getAll();

        assertEquals(buildingsList, actualBuildings);
    }

}