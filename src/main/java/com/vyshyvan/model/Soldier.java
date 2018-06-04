package com.vyshyvan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "military_base_id", nullable = true)
    @JsonIgnore
    private MilitaryBase militaryBase;

    @Transient
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Department department;

    @Transient
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Officers officers;

    @Transient
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Ordinary ordinary;

    @Transient
    private String militaryBaseName;

    @Transient
    private long militaryBaseId;

    @ElementCollection(targetClass = Specialty.class)
    @CollectionTable(name = "soldier_specialty", joinColumns = @JoinColumn (name = "id_soldier", nullable = false))
    @Enumerated(EnumType.STRING)
    @Column(name = "specialty", nullable = false)
    private Set<Specialty> specialty;

    public Soldier() {
    }

    public Soldier(String name, int age, MilitaryBase militaryBase, Set<Specialty> specialty) {
        this.name = name;
        this.age = age;
        this.militaryBase = militaryBase;
        this.militaryBaseName = militaryBase.getName();
        this.specialty = specialty;
    }

    public Soldier(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Officers getOfficers() {
        return officers;
    }

    public void setOfficers(Officers officers) {
        this.officers = officers;
    }

    public Ordinary getOrdinary() {
        return ordinary;
    }

    public void setOrdinary(Ordinary ordinary) {
        this.ordinary = ordinary;
    }

    public Soldier(String name, int age, MilitaryBase militaryBase) {
        this.name = name;
        this.age = age;
        this.militaryBase = militaryBase;
        this.militaryBaseName = militaryBase.getName();
    }

    public long getMilitaryBaseId() {
        if (militaryBase != null)
            return militaryBase.getId();
        return 0;
    }

    public void setMilitaryBaseId(long militaryBaseId) {
        this.militaryBaseId = militaryBaseId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
        this.militaryBaseName = militaryBase.getName();
    }

    public Set<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Set<Specialty> specialty) {
        this.specialty = specialty;
    }

    public String getMilitaryBaseName() {
        if (militaryBase != null)
        return militaryBase.getName();
        return "";
    }

    public void setMilitaryBaseName(String militaryBaseName) {

        this.militaryBaseName = militaryBaseName;
    }
}
