package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="weaponry_in_mbase")
public class WeaponryInMilitaryBase implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    private MilitaryBase militaryBase;

    @ManyToOne
    @NotNull
    private Weaponry weaponry;

    @Column
    @NotNull
    private int amount;

    public WeaponryInMilitaryBase() {
    }

    public WeaponryInMilitaryBase(MilitaryBase militaryBase, Weaponry weaponry, int amount) {
        this.militaryBase = militaryBase;
        this.weaponry = weaponry;
        this.amount = amount;
    }

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
    }

    public Weaponry getWeaponry() {
        return weaponry;
    }

    public void setWeaponry(Weaponry weaponry) {
        this.weaponry = weaponry;
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
