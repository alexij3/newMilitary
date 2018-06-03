package com.vyshyvan.services.transportinmilitarybase;

import com.vyshyvan.model.MilitaryBase;
import com.vyshyvan.model.Transport;
import com.vyshyvan.model.TransportInMilitaryBase;
import com.vyshyvan.repositories.transportinmilitarybase.TransportInMilitaryBaseDAO;
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
public class TransportInMilitaryBaseServiceTest {
    @Mock
    private TransportInMilitaryBaseDAO repository;

    @InjectMocks
    private TransportInMilitaryBaseServiceImpl service;

    private List<TransportInMilitaryBase> transportInMilitaryBaseList;

    private TransportInMilitaryBase transportInMilitaryBase;

    @Before
    public void setUp() throws Exception {
        transportInMilitaryBaseList = Arrays.asList(
                new TransportInMilitaryBase(new MilitaryBase(), new Transport(), 10),
                new TransportInMilitaryBase(new MilitaryBase(), new Transport(), 20),
                new TransportInMilitaryBase(new MilitaryBase(), new Transport(), 30)
        );

        transportInMilitaryBase = new TransportInMilitaryBase(new MilitaryBase(), new Transport(), 40);
        int transportInMilitaryBaseId = 1;
        transportInMilitaryBase.setId(transportInMilitaryBaseId);

        Mockito.when(repository.findAll()).thenReturn(transportInMilitaryBaseList);
        Mockito.when(repository.save(transportInMilitaryBase)).thenReturn(transportInMilitaryBase);

    }

    @Test
    public void insertTransportInMilitaryBase() throws Exception {
        TransportInMilitaryBase actualTransportInMilitaryBase = service.insertTransportInMilitaryBase(transportInMilitaryBase);

        assertEquals(transportInMilitaryBase, actualTransportInMilitaryBase);
    }

    @Test
    public void getTransportInMilitaryBase() throws Exception {
        int id = 1;

        TransportInMilitaryBase expectedTransportInMilitaryBase = new TransportInMilitaryBase(new MilitaryBase(), new Transport(), 50);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedTransportInMilitaryBase));

        TransportInMilitaryBase actualTransportInMilitaryBase = service.getTransportInMilitaryBase(id);

        assertEquals(expectedTransportInMilitaryBase, actualTransportInMilitaryBase);
    }

    @Test
    public void updateTransportInMilitaryBase() throws Exception {
        TransportInMilitaryBase actualTransportInMilitaryBase = service.insertTransportInMilitaryBase(transportInMilitaryBase);

        assertEquals(transportInMilitaryBase, actualTransportInMilitaryBase);
    }

    @Test
    public void getAll() throws Exception {
        List<TransportInMilitaryBase> actualTransportInMilitaryBase = service.getAll();

        assertEquals(transportInMilitaryBaseList, actualTransportInMilitaryBase);
    }

}