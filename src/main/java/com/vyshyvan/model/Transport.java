package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type")
    private TransportType transportType;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column(name = "fightings_seats")
    private int fightingSeats;

    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TransportInMilitaryBase> transportInMilitaryBase = new HashSet<>();

    public Transport() {
    }

    public Transport(TransportType transportType, String name, int capacity, int fightingSeats) {
        this.transportType = transportType;
        this.name = name;
        this.capacity = capacity;
        this.fightingSeats = fightingSeats;
    }

    public Transport(TransportType transportType, String name, int capacity, int fightingSeats, Set<TransportInMilitaryBase> transportInMilitaryBase) {
        this.transportType = transportType;
        this.name = name;
        this.capacity = capacity;
        this.fightingSeats = fightingSeats;
        this.transportInMilitaryBase = transportInMilitaryBase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFightingSeats() {
        return fightingSeats;
    }

    public void setFightingSeats(int fightingSeats) {
        this.fightingSeats = fightingSeats;
    }

    public Set<TransportInMilitaryBase> getTransportInMilitaryBase() {
        return transportInMilitaryBase;
    }

    public void setTransportInMilitaryBase(Set<TransportInMilitaryBase> transportInMilitaryBase) {
        this.transportInMilitaryBase = transportInMilitaryBase;
    }
}
