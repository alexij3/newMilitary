package com.vyshyvan.services.specialty;

import com.vyshyvan.model.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty insertSpecialty(Specialty specialty);
    Specialty getSpecialty(int id);
    Specialty updateSpecialty(Specialty specialty);
    Specialty deleteSpecialty(int id);
    List<Specialty> getAll();
}
