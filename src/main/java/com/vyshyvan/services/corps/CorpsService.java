package com.vyshyvan.services.corps;

import com.vyshyvan.model.Corps;

import java.util.List;

public interface CorpsService {
    Corps insertCorps(Corps corps);
    Corps getCorps(int id);
    Corps updateCorps(Corps corps);
    void deleteCorps(int id);
    List<Corps> getAll();
}
