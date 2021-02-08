package com.iot.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "menu_has_menu_item",
        joinColumns = {@JoinColumn(name = "menu_item_id")},
        inverseJoinColumns = {@JoinColumn(name = "menu_id")}
    )
    private List<Menu> menuList;

}
