package com.iot.db.entity;

import java.time.LocalDateTime;

public class MoneyCollection {
    private LocalDateTime lastCollection;
    private int moneyAmount;

    public MoneyCollection() {
    }

    public MoneyCollection(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public MoneyCollection(LocalDateTime lastCollection, int moneyAmount) {
        this.lastCollection = lastCollection;
        this.moneyAmount = moneyAmount;
    }

    public LocalDateTime getLastCollection() {
        return lastCollection;
    }

    public void setLastCollection(LocalDateTime lastCollection) {
        this.lastCollection = lastCollection;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "MoneyCollection{" +
            "lastCollection=" + lastCollection +
            ", moneyAmount=" + moneyAmount +
            '}';
    }
}
