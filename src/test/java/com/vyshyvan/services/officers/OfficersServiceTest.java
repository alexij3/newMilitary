package com.vyshyvan.services.officers;

import com.vyshyvan.model.Officers;
import com.vyshyvan.model.Rang;
import com.vyshyvan.model.Soldier;
import com.vyshyvan.repositories.officers.OfficersDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class OfficersServiceTest {
    @Mock
    private OfficersDAO repository;

    @InjectMocks
    private OfficersServiceImpl service;

    private List<Officers> officersList;

    private Officers officers;

    @Before
    public void setUp() throws Exception {
        LocalDate academyGraduation = LocalDate.of(2018, 5, 5);

        officersList = Arrays.asList(
                new Officers(new Soldier(), Rang.Капітан, academyGraduation, null),
                new Officers(new Soldier(), Rang.Полковник, academyGraduation, null),
                new Officers(new Soldier(), Rang.Лейтенант, academyGraduation, null)
        );

        officers = new Officers(new Soldier(), Rang.Генерал, academyGraduation, academyGraduation);
        int officersId = 1;
        officers.setId(officersId);

        Mockito.when(repository.findAll()).thenReturn(officersList);
        Mockito.when(repository.save(officers)).thenReturn(officers);
    }

    @Test
    public void insertOfficers() throws Exception {
        Officers actualOfficers = service.insertOfficers(officers);

        assertEquals(officers, actualOfficers);
    }

    @Test
    public void getOfficers() throws Exception {
        LocalDate academyGraduation = LocalDate.of(2018, 5, 5);
        int id = 1;

        Officers expectedOfficers = new Officers(new Soldier(), Rang.Генерал, academyGraduation, academyGraduation);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedOfficers));

        Officers actualOfficers = service.getOfficers(id);

        assertEquals(expectedOfficers, actualOfficers);
    }

    @Test
    public void updateOfficers() throws Exception {
        Officers actualOfficers = service.insertOfficers(officers);

        assertEquals(officers, actualOfficers);
    }

    @Test
    public void getAll() throws Exception {
        List<Officers> actualOfficers = service.getAll();

        assertEquals(officersList, actualOfficers);
    }

}