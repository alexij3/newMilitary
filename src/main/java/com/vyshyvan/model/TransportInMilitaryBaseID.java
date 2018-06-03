package com.vyshyvan.model;

import java.io.Serializable;

public class TransportInMilitaryBaseID implements Serializable {
    private MilitaryBase militaryBase;
    private Transport transport;

    public TransportInMilitaryBaseID() {
    }

    public TransportInMilitaryBaseID(MilitaryBase militaryBase, Transport transport) {
        this.militaryBase = militaryBase;
        this.transport = transport;
    }

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportInMilitaryBaseID that = (TransportInMilitaryBaseID) o;

        if (militaryBase != null ? !militaryBase.equals(that.militaryBase) : that.militaryBase != null) return false;
        return transport != null ? transport.equals(that.transport) : that.transport == null;
    }

    @Override
    public int hashCode() {
        int result = militaryBase != null ? militaryBase.hashCode() : 0;
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        return result;
    }
}
