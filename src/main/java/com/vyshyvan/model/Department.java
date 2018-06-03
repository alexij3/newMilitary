package com.vyshyvan.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_number")
    @NotNull
    private String codeNumber;

    @Column
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "platoon_id")
    @NotNull
    private Platoon platoon;

    @OneToOne
    @JoinColumn(name = "captain_id")
    @NotNull
    private Soldier captain;

    public Department() {
    }

    public Department(String codeNumber, String name, Platoon platoon, Soldier captain) {
        this.codeNumber = codeNumber;
        this.name = name;
        this.platoon = platoon;
        this.captain = captain;
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

    public Platoon getPlatoon() {
        return platoon;
    }

    public void setPlatoon(Platoon platoon) {
        this.platoon = platoon;
    }

    public Soldier getCaptain() {
        return captain;
    }

    public void setCaptain(Soldier captain) {
        this.captain = captain;
    }
}
