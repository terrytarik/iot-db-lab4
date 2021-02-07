package com.iot.db.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Float price;

    @Column(name = "item_brand")
    private String itemBrand;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "menu_has_menu_item",
        joinColumns = {@JoinColumn(name = "menu_item_id")},
        inverseJoinColumns = {@JoinColumn(name = "menu_id")}
    )
    private List<Menu> menuList;

    public MenuItem() {
    }

    public MenuItem(Integer id, String name, Float price, String itemBrand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemBrand = itemBrand;
    }

    public MenuItem(String name, Float price, String itemBrand) {
        this.name = name;
        this.price = price;
        this.itemBrand = itemBrand;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }


    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", itemBrand='" + itemBrand + '\'' +
            '}';
    }
}
