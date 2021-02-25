package com.iot.db.entity;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "money_collection")
public class MoneyCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_collection")
    private Timestamp lastCollection;
    @Column(name = "money_amount")
    private Float moneyAmount;

    @ManyToOne
    @JoinColumn(name = "vending_machine_id")
    private VendingMachine vendingMachine;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    public MoneyCollection() {
    }

    public MoneyCollection(Timestamp lastCollection, Float moneyAmount, VendingMachine vendingMachine,
                           Technician technician) {
        this.lastCollection = lastCollection;
        this.moneyAmount = moneyAmount;
        this.vendingMachine = vendingMachine;
        this.technician = technician;
    }

    public MoneyCollection(Integer id, Timestamp lastCollection, Float moneyAmount,
                           VendingMachine vendingMachine, Technician technician) {
        this.id = id;
        this.lastCollection = lastCollection;
        this.moneyAmount = moneyAmount;
        this.vendingMachine = vendingMachine;
        this.technician = technician;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getLastCollection() {
        return lastCollection;
    }

    public void setLastCollection(Timestamp lastCollection) {
        this.lastCollection = lastCollection;
    }

    public Float getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    @Override
    public String toString() {
        return "MoneyCollection{" +
            "id=" + id +
            ", lastCollection=" + lastCollection +
            ", moneyAmount=" + moneyAmount +
            '}';
    }
}
