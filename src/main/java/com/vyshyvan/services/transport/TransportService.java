package com.vyshyvan.services.transport;

import com.vyshyvan.model.Transport;

import java.util.List;

public interface TransportService {
    Transport insertTransport(Transport transport);
    Transport getTransport(int id);
    Transport updateTransport(Transport transport);
    void deleteTransport(int id);
    List<Transport> getAll();
}
