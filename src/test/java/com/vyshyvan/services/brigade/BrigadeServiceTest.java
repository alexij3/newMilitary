package com.vyshyvan.services.brigade;

import com.vyshyvan.model.Brigade;
import com.vyshyvan.repositories.brigade.BrigadeDAO;
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
public class BrigadeServiceTest {
    @Mock
    private BrigadeDAO repository;

    @InjectMocks
    private BrigadeServiceImpl service;

    private List<Brigade> brigadeList;

    private Brigade brigade;


    @Before
    public void setUp() throws Exception {
        brigadeList = Arrays.asList(
                new Brigade("B1", "Brigade 1"),
                new Brigade("B2", "Brigade 2"),
                new Brigade("B3", "Brigade 3")
        );

        brigade = new Brigade("B4", "Brigade 4");
        int brigadeId = 1;
        brigade.setId(brigadeId);

        Mockito.when(repository.findAll()).thenReturn(brigadeList);
        Mockito.when(repository.save(brigade)).thenReturn(brigade);

    }

    @Test
    public void insertBrigade() throws Exception {
        Brigade actualBrigade = service.insertBrigade(brigade);

        assertEquals(brigade, actualBrigade);
    }

    @Test
    public void getBrigade() throws Exception {
        int id = 1;

        Brigade expectedBrigade = new Brigade("B1", "Brigade");
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedBrigade));

        Brigade actualBrigade = service.getBrigade(id);

        assertEquals(expectedBrigade, actualBrigade);
    }

    @Test
    public void updateBrigade() throws Exception {
        Brigade actualBrigade = service.insertBrigade(brigade);

        assertEquals(brigade, actualBrigade);
    }

    @Test
    public void getAll() throws Exception {
        List<Brigade> actualBrigades = service.getAll();

        assertEquals(brigadeList, actualBrigades);
    }

}