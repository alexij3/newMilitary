package com.vyshyvan.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Ordinary implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "soldier_id", unique = true)
    @NotNull
    private Soldier soldier;

    @Enumerated(EnumType.STRING)
    @Column(name = "rang")
    @NotNull
    private Rang rang;

    public Ordinary() {
    }

    public Ordinary(Soldier soldier, Rang rang) {
        this.soldier = soldier;
        this.rang = rang;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
