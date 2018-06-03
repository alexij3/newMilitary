package com.vyshyvan.services.militarybase;

import com.vyshyvan.model.*;
import com.vyshyvan.repositories.militarybase.MilitaryBaseDAO;
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
public class MilitaryBaseServiceTest {
    @Mock
    private MilitaryBaseDAO repository;

    @InjectMocks
    private MilitaryBaseServiceImpl service;

    private List<MilitaryBase> militaryBaseList;

    private MilitaryBase militaryBase;

    @Before
    public void setUp() throws Exception {
        militaryBaseList = Arrays.asList(
                new MilitaryBase("Base 1", new Army(), new Division(), null, null, new Soldier()),
                new MilitaryBase("Base 2", new Army(), null, new Corps(), null, new Soldier()),
                new MilitaryBase("Base 3", new Army(), null, null, new Brigade(), new Soldier())
        );

        militaryBase = new MilitaryBase("Base 4", new Army(), null, null, new Brigade(), new Soldier());
        int militaryBaseId = 1;
        militaryBase.setId(militaryBaseId);

        Mockito.when(repository.findAll()).thenReturn(militaryBaseList);
        Mockito.when(repository.save(militaryBase)).thenReturn(militaryBase);

    }

    @Test
    public void insertMilitaryBase() throws Exception {
        MilitaryBase actualMilitaryBase = service.insertMilitaryBase(militaryBase);

        assertEquals(militaryBase, actualMilitaryBase);
    }

    @Test
    public void getMilitaryBase() throws Exception {
        int id = 1;

        MilitaryBase expectedMilitaryBase = new MilitaryBase("Base 4", new Army(), null, null, new Brigade(), new Soldier());
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedMilitaryBase));

        MilitaryBase actualMilitaryBase = service.getMilitaryBase(id);

        assertEquals(expectedMilitaryBase, actualMilitaryBase);
    }

    @Test
    public void updateMilitaryBase() throws Exception {
        MilitaryBase actualMilitaryBase = service.insertMilitaryBase(militaryBase);

        assertEquals(militaryBase, actualMilitaryBase);
    }

    @Test
    public void getAll() throws Exception {
        List<MilitaryBase> actualMilitaryBases = service.getAll();

        assertEquals(militaryBaseList, actualMilitaryBases);
    }

}