package com.iot.db.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "menu")
    private List<VendingMachine> vendingMachine;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "menu_has_menu_item",
        joinColumns = {@JoinColumn(name = "menu_id")},
        inverseJoinColumns = {@JoinColumn(name = "menu_item_id")}
    )
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }

    public Menu(Integer id, String name, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
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

    public List<VendingMachine> getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(List<VendingMachine> vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Menu{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
