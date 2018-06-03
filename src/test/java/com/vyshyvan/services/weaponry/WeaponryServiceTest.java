package com.vyshyvan.services.weaponry;

import com.vyshyvan.model.Weaponry;
import com.vyshyvan.model.WeaponryType;
import com.vyshyvan.repositories.weaponry.WeaponryDAO;
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
public class WeaponryServiceTest {
    @Mock
    private WeaponryDAO repository;

    @InjectMocks
    private WeaponryServiceImpl service;

    private List<Weaponry> weaponryList;

    private Weaponry weaponry;

    @Before
    public void setUp() throws Exception {
        weaponryList = Arrays.asList(
                new Weaponry(WeaponryType.Автомат, "Weaponry 1", "7.62", 'n'),
                new Weaponry(WeaponryType.Автомат, "Weaponry 2", "7.62", 'n'),
                new Weaponry(WeaponryType.Ракети, "Weaponry 3", "", ' ')
        );

        weaponry = new Weaponry(WeaponryType.Карабін, "Weaponry 4", "7.62", 'n');
        int weaponryId = 1;
        weaponry.setId(weaponryId);

        Mockito.when(repository.findAll()).thenReturn(weaponryList);
        Mockito.when(repository.save(weaponry)).thenReturn(weaponry);

    }

    @Test
    public void insertWeaponry() throws Exception {
        Weaponry actualWeaponry = service.insertWeaponry(weaponry);

        assertEquals(weaponry, actualWeaponry);
    }

    @Test
    public void getWeaponry() throws Exception {
        int id = 1;

        Weaponry expectedWeaponry = new Weaponry(WeaponryType.Карабін, "Weaponry 4", "7.62", 'n');
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedWeaponry));

        Weaponry actualWeaponry = service.getWeaponry(id);

        assertEquals(expectedWeaponry, actualWeaponry);
    }

    @Test
    public void updateWeaponry() throws Exception {
        Weaponry actualWeaponry = service.insertWeaponry(weaponry);

        assertEquals(weaponry, actualWeaponry);
    }

    @Test
    public void getAll() throws Exception {
        List<Weaponry> actualWeaponry = service.getAll();

        assertEquals(weaponryList, actualWeaponry);
    }

}