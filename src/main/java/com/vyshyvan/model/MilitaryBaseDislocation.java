package com.vyshyvan.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "base_dislocation")
public class MilitaryBaseDislocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "base_id")
    @NotNull
    private MilitaryBase militaryBase;

    @ManyToOne
    @JoinColumn(name = "dislocation")
    @NotNull
    private Buildings dislocation;

    public MilitaryBaseDislocation() {
    }

    public MilitaryBaseDislocation(@NotNull MilitaryBase militaryBase, @NotNull Buildings dislocation) {
        this.militaryBase = militaryBase;
        this.dislocation = dislocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
    }

    public Buildings getDislocation() {
        return dislocation;
    }

    public void setDislocation(Buildings dislocation) {
        this.dislocation = dislocation;
    }
}
