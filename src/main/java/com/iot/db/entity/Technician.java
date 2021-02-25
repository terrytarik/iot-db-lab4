package com.iot.db.entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;

    @OneToMany(mappedBy = "technician", cascade = CascadeType.REMOVE)
    private List<MoneyCollection> moneyCollections;

    public Technician() {
    }

    public Technician(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Technician(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<MoneyCollection> getMoneyCollections() {
        return moneyCollections;
    }

    public void setMoneyCollections(List<MoneyCollection> moneyCollections) {
        this.moneyCollections = moneyCollections;
    }

    @Override
    public String toString() {
        return "Technician{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
    }
}
