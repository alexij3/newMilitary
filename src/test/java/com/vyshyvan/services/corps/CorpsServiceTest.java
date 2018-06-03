package com.vyshyvan.services.corps;

import com.vyshyvan.model.Corps;
import com.vyshyvan.repositories.corps.CorpsDAO;
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
public class CorpsServiceTest {
    @Mock
    private CorpsDAO repository;

    @InjectMocks
    private CorpsServiceImpl service;

    private List<Corps> corpsList;

    private Corps corps;

    @Before
    public void setUp() throws Exception {
        corpsList = Arrays.asList(
                new Corps("C1", "Corps 1"),
                new Corps("C2", "Corps 2"),
                new Corps("C3", "Corps 3")
        );

        corps = new Corps("C4", "Corps 4");
        int corpsId = 1;
        corps.setId(corpsId);

        Mockito.when(repository.findAll()).thenReturn(corpsList);
        Mockito.when(repository.save(corps)).thenReturn(corps);

    }

    @Test
    public void insertCorps() throws Exception {
        Corps actualCorps = service.insertCorps(corps);

        assertEquals(corps, actualCorps);
    }

    @Test
    public void getCorps() throws Exception {
        int id = 1;

        Corps expectedCorps = new Corps("C1", "Corps");
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedCorps));

        Corps actualCorps = service.getCorps(id);

        assertEquals(expectedCorps, actualCorps);
    }

    @Test
    public void updateCorps() throws Exception {
        Corps actualCorps = service.insertCorps(corps);

        assertEquals(corps, actualCorps);
    }

    @Test
    public void getAll() throws Exception {
        List<Corps> actualCorps = service.getAll();

        assertEquals(corpsList, actualCorps);
    }

}