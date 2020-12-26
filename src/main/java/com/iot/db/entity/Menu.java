package com.iot.db.entity;

public class Menu {
    private int id;
    private String name;
    private int vendingMachineId;

    public Menu() {
    }

    public Menu(String name, int vendingMachineId) {
        this.name = name;
        this.vendingMachineId = vendingMachineId;
    }

    public Menu(int id, String name, int vendingMachineId) {
        this.id = id;
        this.name = name;
        this.vendingMachineId = vendingMachineId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(int vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Override
    public String toString() {
        return "Menu{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", vendingMachineId=" + vendingMachineId +
            '}';
    }
}
