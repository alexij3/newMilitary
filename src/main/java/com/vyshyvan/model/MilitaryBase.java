package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "military_base")
public class MilitaryBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="army_id")
    @NotNull
    private Army army;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "corps_id")
    private Corps corps;

    @ManyToOne
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    @OneToOne
    @JoinColumn(name = "captain_id")
    private Soldier captain;

    @OneToMany(mappedBy = "militaryBase", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TransportInMilitaryBase> transportInMilitaryBase = new HashSet<>();

    @OneToMany(mappedBy = "militaryBase", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<WeaponryInMilitaryBase> weaponryInMilitaryBase = new HashSet<>();


    public MilitaryBase() {
    }

    public MilitaryBase(String name) {
        this.name = name;
    }

    public MilitaryBase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MilitaryBase(String name, Army army, Division division, Corps corps, Brigade brigade, Soldier captain) {
        this.name = name;
        this.army = army;
        this.division = division;
        this.corps = corps;
        this.brigade = brigade;
        this.captain = captain;
    }

    public MilitaryBase(String name, Soldier captain, Set<TransportInMilitaryBase> transportInMilitaryBase, Set<WeaponryInMilitaryBase> weaponryInMilitaryBase) {
        this.name = name;
        this.captain = captain;
        this.transportInMilitaryBase = transportInMilitaryBase;
        this.weaponryInMilitaryBase = weaponryInMilitaryBase;
    }

    public MilitaryBase(String name, Army army, Division division, Corps corps, Brigade brigade, Set<Buildings> dislocation, Soldier captain, Set<TransportInMilitaryBase> transportInMilitaryBase, Set<WeaponryInMilitaryBase> weaponryInMilitaryBase) {
        this.name = name;
        this.army = army;
        this.division = division;
        this.corps = corps;
        this.brigade = brigade;
        this.captain = captain;
        this.transportInMilitaryBase = transportInMilitaryBase;
        this.weaponryInMilitaryBase = weaponryInMilitaryBase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Corps getCorps() {
        return corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public Set<TransportInMilitaryBase> getTransportInMilitaryBase() {
        return transportInMilitaryBase;
    }

    public void setTransportInMilitaryBase(Set<TransportInMilitaryBase> transportInMilitaryBase) {
        this.transportInMilitaryBase = transportInMilitaryBase;
    }

    public Set<WeaponryInMilitaryBase> getWeaponryInMilitaryBase() {
        return weaponryInMilitaryBase;
    }

    public void setWeaponryInMilitaryBase(Set<WeaponryInMilitaryBase> weaponryInMilitaryBase) {
        this.weaponryInMilitaryBase = weaponryInMilitaryBase;
    }

    public Soldier getCaptain() {
        return captain;
    }

    public void setCaptain(Soldier captain) {
        this.captain = captain;
    }

    @Override
    public String toString() {
        return "MilitaryBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
