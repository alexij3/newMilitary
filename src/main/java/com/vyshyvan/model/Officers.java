package com.vyshyvan.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Officers implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "soldier_id", unique = true)
    @NotNull
    private Soldier soldier;

    @Enumerated(EnumType.STRING)
    @Column(name = "rang")
    @NotNull
    private Rang rang;

    @Column(name = "academy_graduation")
    private LocalDate academyGraduation;

    @Column(name = "became_general")
    private LocalDate becameGeneral;

    public Officers() {
    }

    public Officers(Soldier soldier, Rang rang, LocalDate academyGraduation, LocalDate becameGeneral) {
        this.soldier = soldier;
        this.rang = rang;
        this.academyGraduation = academyGraduation;
        this.becameGeneral = becameGeneral;
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

    public LocalDate getAcademyGraduation() {
        return academyGraduation;
    }

    public void setAcademyGraduation(LocalDate academyGraduation) {
        this.academyGraduation = academyGraduation;
    }

    public LocalDate getBecameGeneral() {
        return becameGeneral;
    }

    public void setBecameGeneral(LocalDate becameGeneral) {
        this.becameGeneral = becameGeneral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
