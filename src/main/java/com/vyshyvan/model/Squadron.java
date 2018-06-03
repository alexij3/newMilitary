package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Squadron {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "code_number")
    private String codeNumber;

    @Column
    private String name;

    @OneToMany(mappedBy = "squadron", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Platoon> platoons;

    @ManyToOne
    @NotNull
    private MilitaryBase militaryBase;

    public Squadron() {
    }

    public Squadron(String codeNumber, String name) {
        this.codeNumber = codeNumber;
        this.name = name;
    }

    public Squadron(String codeNumber, String name, Set<Platoon> platoons) {
        this.codeNumber = codeNumber;
        this.name = name;
        this.platoons = platoons;
    }

    public Squadron(String codeNumber, String name, Set<Platoon> platoons, @NotNull MilitaryBase militaryBase) {
        this.codeNumber = codeNumber;
        this.name = name;
        this.platoons = platoons;
        this.militaryBase = militaryBase;
    }

    public Set<Platoon> getPlatoons() {
        return platoons;
    }

    public void setPlatoons(Set<Platoon> platoons) {
        this.platoons = platoons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
    }
}
