package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Weaponry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "weaponry_type")
    private WeaponryType weaponryType;

    @Column
    private String name;

    @Column
    private String caliber;

    @Column
    private char silencer;

    @OneToMany(mappedBy = "weaponry", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<WeaponryInMilitaryBase> weaponryInMilitaryBase = new HashSet<>();

    public Weaponry() {
    }

    public Weaponry(WeaponryType weaponryType, String name, String caliber, char silencer) {
        this.weaponryType = weaponryType;
        this.name = name;
        this.caliber = caliber;
        this.silencer = silencer;
    }

    public Weaponry(WeaponryType weaponryType, String name, String caliber, char silencer, Set<WeaponryInMilitaryBase> weaponryInMilitaryBase) {
        this.weaponryType = weaponryType;
        this.name = name;
        this.caliber = caliber;
        this.silencer = silencer;
        this.weaponryInMilitaryBase = weaponryInMilitaryBase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WeaponryType getWeaponryType() {
        return weaponryType;
    }

    public void setWeaponryType(WeaponryType weaponryType) {
        this.weaponryType = weaponryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public char getSilencer() {
        return silencer;
    }

    public void setSilencer(char silencer) {
        this.silencer = silencer;
    }

    public Set<WeaponryInMilitaryBase> getWeaponryInMilitaryBase() {
        return weaponryInMilitaryBase;
    }

    public void setWeaponryInMilitaryBase(Set<WeaponryInMilitaryBase> weaponryInMilitaryBase) {
        this.weaponryInMilitaryBase = weaponryInMilitaryBase;
    }
}
