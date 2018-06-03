package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Army {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_number")
    private String codeNumber;

    @Column
    private String name;

    @OneToMany(mappedBy = "army", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MilitaryBase> militaryBase;

    public Army() {

    }

    public Army(String codeNumber, String name) {
        this.codeNumber = codeNumber;
        this.name = name;
    }

    public Army(Long id, String name, String codeNumber){
        this.id = id;
        this.name = name;
        this.codeNumber = codeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MilitaryBase> getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(Set<MilitaryBase> militaryBase) {
        this.militaryBase = militaryBase;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
