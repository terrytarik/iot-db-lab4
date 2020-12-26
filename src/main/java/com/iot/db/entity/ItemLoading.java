package com.iot.db.entity;

public class ItemLoading {
    private String lastLoading;
    private int moneyAmount;
    private int technicianId;
    private int vendingMachineId;

    public ItemLoading() {
    }

    public ItemLoading(int moneyAmount, int technicianId, int vendingMachineId) {
        this.moneyAmount = moneyAmount;
        this.technicianId = technicianId;
        this.vendingMachineId = vendingMachineId;
    }

    public ItemLoading(String lastLoading, int moneyAmount, int technicianId, int vendingMachineId) {
        this.lastLoading = lastLoading;
        this.moneyAmount = moneyAmount;
        this.technicianId = technicianId;
        this.vendingMachineId = vendingMachineId;
    }

    public String getLastLoading() {
        return lastLoading;
    }

    public void setLastLoading(String lastLoading) {
        this.lastLoading = lastLoading;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }

    public int getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(int vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Override
    public String toString() {
        return "ItemLoading{" +
            "lastLoading='" + lastLoading + '\'' +
            ", moneyAmount=" + moneyAmount +
            ", technicianId=" + technicianId +
            ", vendingMachineId=" + vendingMachineId +
            '}';
    }
}
