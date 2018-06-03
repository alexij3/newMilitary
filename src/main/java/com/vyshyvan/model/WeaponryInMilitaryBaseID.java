package com.vyshyvan.model;

import java.io.Serializable;

public class WeaponryInMilitaryBaseID implements Serializable {
    private MilitaryBase militaryBase;
    private Weaponry weaponry;

    public WeaponryInMilitaryBaseID() {
    }

    public WeaponryInMilitaryBaseID(MilitaryBase militaryBase, Weaponry weaponry) {
        this.militaryBase = militaryBase;
        this.weaponry = weaponry;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponryInMilitaryBaseID that = (WeaponryInMilitaryBaseID) o;

        if (militaryBase != null ? !militaryBase.equals(that.militaryBase) : that.militaryBase != null) return false;
        return weaponry != null ? weaponry.equals(that.weaponry) : that.weaponry == null;
    }

    @Override
    public int hashCode() {
        int result = militaryBase != null ? militaryBase.hashCode() : 0;
        result = 31 * result + (weaponry != null ? weaponry.hashCode() : 0);
        return result;
    }
}
