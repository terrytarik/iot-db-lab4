package com.iot.db.entity;

public class MoneyCollection {
    private String lastCollection;
    private int moneyAmount;
    private int vendingMachineId;

    public MoneyCollection() {
    }

    public MoneyCollection(int moneyAmount, int vendingMachineId) {
        this.moneyAmount = moneyAmount;
        this.vendingMachineId = vendingMachineId;
    }

    public MoneyCollection(String lastCollection, int moneyAmount, int vendingMachineId) {
        this.lastCollection = lastCollection;
        this.moneyAmount = moneyAmount;
        this.vendingMachineId = vendingMachineId;
    }

    public String getLastCollection() {
        return lastCollection;
    }

    public void setLastCollection(String lastCollection) {
        this.lastCollection = lastCollection;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(int vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Override
    public String toString() {
        return "MoneyCollection{" +
            "lastCollection=" + lastCollection +
            ", moneyAmount=" + moneyAmount +
            ", vendingMachineId=" + vendingMachineId +
            '}';
    }
}
