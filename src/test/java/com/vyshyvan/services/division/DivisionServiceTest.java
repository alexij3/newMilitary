package com.vyshyvan.services.division;

import com.vyshyvan.model.Division;
import com.vyshyvan.repositories.division.DivisionDAO;
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
public class DivisionServiceTest {
    @Mock
    private DivisionDAO repository;

    @InjectMocks
    private DivisionServiceImpl service;

    private List<Division> divisionList;

    private Division division;


    @Before
    public void setUp() throws Exception {
        divisionList = Arrays.asList(
                new Division("D1", "Division 1"),
                new Division("D2", "Division 2"),
                new Division("D3", "Division 3")
        );

        division = new Division("D4", "Division 4");
        int divisionId = 1;
        division.setId(divisionId);

        Mockito.when(repository.findAll()).thenReturn(divisionList);
        Mockito.when(repository.save(division)).thenReturn(division);

    }

    @Test
    public void insertDivision() throws Exception {
        Division actualDivision = service.insertDivision(division);

        assertEquals(division, actualDivision);
    }

    @Test
    public void getDivision() throws Exception {
        int id = 1;

        Division expectedDivision = new Division("D1", "Division");
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedDivision));

        Division actualDivision = service.getDivision(id);

        assertEquals(expectedDivision, actualDivision);
    }

    @Test
    public void updateDivision() throws Exception {
        Division actualDivision = service.insertDivision(division);

        assertEquals(division, actualDivision);
    }

    @Test
    public void getAll() throws Exception {
        List<Division> actualDivisions = service.getAll();

        assertEquals(divisionList, actualDivisions);
    }
}