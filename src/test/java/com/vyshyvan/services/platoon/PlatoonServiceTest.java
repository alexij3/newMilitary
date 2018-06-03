package com.vyshyvan.services.platoon;

import com.vyshyvan.model.Platoon;
import com.vyshyvan.model.Squadron;
import com.vyshyvan.repositories.platoon.PlatoonDAO;
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
public class PlatoonServiceTest {
    @Mock
    private PlatoonDAO repository;

    @InjectMocks
    private PlatoonServiceImpl service;

    private List<Platoon> platoonList;

    private Platoon platoon;

    @Before
    public void setUp() throws Exception {
        platoonList = Arrays.asList(
                new Platoon("PT1", "Platoon 1", new Squadron()),
                new Platoon("PT2", "Platoon 2", new Squadron()),
                new Platoon("PT3", "Platoon 3", new Squadron())
        );

        platoon = new Platoon("PT4", "Platoon 4", new Squadron());
        int platoonId = 1;
        platoon.setId(platoonId);

        Mockito.when(repository.findAll()).thenReturn(platoonList);
        Mockito.when(repository.save(platoon)).thenReturn(platoon);

    }

    @Test
    public void insertPlatoon() throws Exception {
        Platoon actualPlatoon = service.insertPlatoon(platoon);

        assertEquals(platoon, actualPlatoon);
    }

    @Test
    public void getPlatoon() throws Exception {
        int id = 1;

        Platoon expectedPlatoon = new Platoon("PT3", "Platoon 3", new Squadron());
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedPlatoon));

        Platoon actualPlatoon = service.getPlatoon(id);

        assertEquals(expectedPlatoon, actualPlatoon);
    }

    @Test
    public void updatePlatoon() throws Exception {
        Platoon actualPlatoon = service.insertPlatoon(platoon);

        assertEquals(platoon, actualPlatoon);
    }

    @Test
    public void getAll() throws Exception {
        List<Platoon> actualPlatoons = service.getAll();

        assertEquals(platoonList, actualPlatoons);
    }

}