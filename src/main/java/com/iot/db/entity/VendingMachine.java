package com.iot.db.entity;

public class VendingMachine {
    private int id;
    private String adress;

    public VendingMachine() {
    }

    public VendingMachine(String adress) {
        this.adress = adress;
    }

    public VendingMachine(int id, String adress) {
        this.id = id;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
            "id=" + id +
            ", adress='" + adress + '\'' +
            '}';
    }
}
