package com.iot.db.entity;

import java.time.LocalDateTime;

public class ItemLoading {
    private LocalDateTime lastLoading;
    private int moneyAmount;

    public ItemLoading() {
    }

    public ItemLoading(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public ItemLoading(LocalDateTime lastLoading, int moneyAmount) {
        this.lastLoading = lastLoading;
        this.moneyAmount = moneyAmount;
    }

    public LocalDateTime getLastLoading() {
        return lastLoading;
    }

    public void setLastLoading(LocalDateTime lastLoading) {
        this.lastLoading = lastLoading;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "ItemLoading{" +
            "lastLoading=" + lastLoading +
            ", moneyAmount=" + moneyAmount +
            '}';
    }
}
