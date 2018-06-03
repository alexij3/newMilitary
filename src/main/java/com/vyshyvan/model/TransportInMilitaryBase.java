package com.vyshyvan.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="transport_in_mbase")
public class TransportInMilitaryBase implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    private MilitaryBase militaryBase;

    @ManyToOne
    @NotNull
    private Transport transport;

    @Column
    @NotNull
    private int amount;

    public TransportInMilitaryBase() {
    }

    public TransportInMilitaryBase(MilitaryBase militaryBase, Transport transport, int amount) {
        this.militaryBase = militaryBase;
        this.transport = transport;
        this.amount = amount;
    }

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
