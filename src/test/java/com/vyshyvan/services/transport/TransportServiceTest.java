package com.vyshyvan.services.transport;

import com.vyshyvan.model.Transport;
import com.vyshyvan.model.TransportType;
import com.vyshyvan.repositories.transport.TransportDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TransportServiceTest {
    @Mock
    private TransportDAO repository;

    @InjectMocks
    private TransportServiceImpl service;

    private List<Transport> transportList;

    private Transport transport;

    @Before
    public void setUp() throws Exception {
        transportList = Arrays.asList(
                new Transport(TransportType.Автотранспорт, "Transport 1", 10, 5),
                new Transport(TransportType.Автотранспорт, "Transport 2", 6, 2),
                new Transport(TransportType.БМП, "Transport 3", 5, 3)
        );

        transport = new Transport(TransportType.Тягач, "Transport 4", 1, 0);
        int transportId = 1;
        transport.setId(transportId);

        Mockito.when(repository.findAll()).thenReturn(transportList);
        Mockito.when(repository.save(transport)).thenReturn(transport);

    }

    @Test
    public void insertTransport() throws Exception {
        Transport actualTransport = service.insertTransport(transport);

        assertEquals(transport, actualTransport);
    }

    @Test
    public void getTransport() throws Exception {
        int id = 1;

        Transport expectedTransport = new Transport(TransportType.Тягач, "Transport 4", 1, 0);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedTransport));

        Transport actualTransport = service.getTransport(id);

        assertEquals(expectedTransport, actualTransport);
    }

    @Test
    public void updateTransport() throws Exception {
        Transport actualTransport = service.insertTransport(transport);

        assertEquals(transport, actualTransport);
    }

    @Test
    public void getAll() throws Exception {
        List<Transport> actualTransport = service.getAll();

        assertEquals(transportList, actualTransport);
    }
}