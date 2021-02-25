package com.iot.db.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "vending_machine")
public class VendingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String address;

    @OneToMany(mappedBy = "vendingMachine")
    private List<MoneyCollection> moneyCollections;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public VendingMachine() {
    }

    public VendingMachine(String address, Menu menu) {
        this.address = address;
        this.menu = menu;
    }

    public VendingMachine(Integer id, String address, Menu menu) {
        this.id = id;
        this.address = address;
        this.menu = menu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MoneyCollection> getMoneyCollections() {
        return moneyCollections;
    }

    public void setMoneyCollections(List<MoneyCollection> moneyCollections) {
        this.moneyCollections = moneyCollections;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
            "id=" + id +
            ", address='" + address + '\'' +
            '}';
    }
}
