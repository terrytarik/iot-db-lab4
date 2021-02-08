package com.iot.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<VendingMachine> vendingMachine;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "menu_has_menu_item",
        joinColumns = {@JoinColumn(name = "menu_id")},
        inverseJoinColumns = {@JoinColumn(name = "menu_item_id")}
    )
    private List<MenuItem> menuItems;
}
