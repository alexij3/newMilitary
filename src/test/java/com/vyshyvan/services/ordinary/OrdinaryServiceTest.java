package com.vyshyvan.services.ordinary;

import com.vyshyvan.model.Ordinary;
import com.vyshyvan.model.Rang;
import com.vyshyvan.model.Soldier;
import com.vyshyvan.repositories.ordinary.OrdinaryDAO;
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
public class OrdinaryServiceTest {
    @Mock
    private OrdinaryDAO repository;

    @InjectMocks
    private OrdinaryServiceImpl service;

    private List<Ordinary> ordinaryList;

    private Ordinary ordinary;

    @Before
    public void setUp() throws Exception {
        LocalDate academyGraduation = LocalDate.of(2018, 5, 5);

        ordinaryList = Arrays.asList(
                new Ordinary(new Soldier(), Rang.Рядовий),
                new Ordinary(new Soldier(), Rang.Сержант),
                new Ordinary(new Soldier(), Rang.Старшина)
        );

        ordinary = new Ordinary(new Soldier(), Rang.Єфрейтор);
        int ordinaryId = 1;
        ordinary.setId(ordinaryId);

        Mockito.when(repository.findAll()).thenReturn(ordinaryList);
        Mockito.when(repository.save(ordinary)).thenReturn(ordinary);
    }

    @Test
    public void insertOrdinary() throws Exception {
        Ordinary actualOrdinary = service.insertOrdinary(ordinary);

        assertEquals(ordinary, actualOrdinary);
    }

    @Test
    public void getOrdinary() throws Exception {
        LocalDate academyGraduation = LocalDate.of(2018, 5, 5);
        int id = 1;

        Ordinary expectedOrdinary = new Ordinary(new Soldier(), Rang.Єфрейтор);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedOrdinary));

        Ordinary actualOrdinary = service.getOrdinary(id);

        assertEquals(expectedOrdinary, actualOrdinary);
    }

    @Test
    public void updateOrdinary() throws Exception {
        Ordinary actualOrdinary = service.insertOrdinary(ordinary);

        assertEquals(ordinary, actualOrdinary);
    }

    @Test
    public void getAll() throws Exception {
        List<Ordinary> actualOrdinary = service.getAll();

        assertEquals(ordinaryList, actualOrdinary);
    }

}