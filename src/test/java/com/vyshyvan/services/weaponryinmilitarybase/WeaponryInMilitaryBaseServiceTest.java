package com.vyshyvan.services.weaponryinmilitarybase;

import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.Weaponry;
import com.vyshyvan.model.WeaponryInMilitaryBase;
import com.vyshyvan.repositories.weaponryinmilitarybase.WeaponryInMilitaryBaseDAO;
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
public class WeaponryInMilitaryBaseServiceTest {
    @Mock
    private WeaponryInMilitaryBaseDAO repository;

    @InjectMocks
    private WeaponryInMilitaryBaseServiceImpl service;

    private List<WeaponryInMilitaryBase> weaponryInMilitaryBaseList;

    private WeaponryInMilitaryBase weaponryInMilitaryBase;

    @Before
    public void setUp() throws Exception {
        weaponryInMilitaryBaseList = Arrays.asList(
                new WeaponryInMilitaryBase(new MilitaryBase(), new Weaponry(), 10),
                new WeaponryInMilitaryBase(new MilitaryBase(), new Weaponry(), 20),
                new WeaponryInMilitaryBase(new MilitaryBase(), new Weaponry(), 30)
        );

        weaponryInMilitaryBase = new WeaponryInMilitaryBase(new MilitaryBase(), new Weaponry(), 40);
        int weaponryInMilitaryBaseId = 1;
        weaponryInMilitaryBase.setId(weaponryInMilitaryBaseId);

        Mockito.when(repository.findAll()).thenReturn(weaponryInMilitaryBaseList);
        Mockito.when(repository.save(weaponryInMilitaryBase)).thenReturn(weaponryInMilitaryBase);

    }

    @Test
    public void insertWeaponryInMilitaryBase() throws Exception {
        WeaponryInMilitaryBase actualWeaponryInMilitaryBase = service.insertWeaponryInMilitaryBase(weaponryInMilitaryBase);

        assertEquals(weaponryInMilitaryBase, actualWeaponryInMilitaryBase);
    }

    @Test
    public void getWeaponryInMilitaryBase() throws Exception {
        int id = 1;

        WeaponryInMilitaryBase expectedWeaponryInMilitaryBase = new WeaponryInMilitaryBase(new MilitaryBase(), new Weaponry(), 50);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedWeaponryInMilitaryBase));

        WeaponryInMilitaryBase actualWeaponryInMilitaryBase = service.getWeaponryInMilitaryBase(id);

        assertEquals(expectedWeaponryInMilitaryBase, actualWeaponryInMilitaryBase);
    }

    @Test
    public void updateWeaponryInMilitaryBase() throws Exception {
        WeaponryInMilitaryBase actualWeaponryInMilitaryBase = service.insertWeaponryInMilitaryBase(weaponryInMilitaryBase);

        assertEquals(weaponryInMilitaryBase, actualWeaponryInMilitaryBase);
    }

    @Test
    public void getAll() throws Exception {
        List<WeaponryInMilitaryBase> actualWeaponryInMilitaryBase = service.getAll();

        assertEquals(weaponryInMilitaryBaseList, actualWeaponryInMilitaryBase);
    }

}