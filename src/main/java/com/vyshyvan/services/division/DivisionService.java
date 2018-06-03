package com.vyshyvan.services.division;

import com.vyshyvan.model.Division;

import java.util.List;

public interface DivisionService {
    Division insertDivision(Division division);
    Division getDivision(int id);
    Division updateDivision(Division division);
    void deleteDivision(int id);
    List<Division> getAll();
}
